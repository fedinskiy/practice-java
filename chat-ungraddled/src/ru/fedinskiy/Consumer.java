package ru.fedinskiy;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

import static java.lang.Thread.sleep;
import static ru.fedinskiy.MessageConstants.getConnectionName;
import static ru.fedinskiy.MessageConstants.getConnectionSocket;

/**
 * Created by fedinskiy on 14.03.17.
 */
public class Consumer implements Runnable{
	private final int WAIT_PERIOD = 10000;
	private int waitBeforeAknowledgement;
	private ChatPerson sender;
	
	public Consumer(ChatPerson sender,int waitSeconds) {
		this.sender = sender;
		waitBeforeAknowledgement=waitSeconds*1000;
	}
	
	@Override
	public void run() {
		ActiveMQConnectionFactory factory= new ActiveMQConnectionFactory(getConnectionSocket());
		Connection connection= null;
		boolean exit=false;
		try {
			connection = factory.createConnection();
			connection.setClientID(sender.getNickname());
			connection.start();
			Session session=connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);

			final Topic topic = session.createTopic(getConnectionName());
			MessageConsumer consumer=session.createDurableSubscriber(topic,sender.getNickname());
			
			
			Message lastmessage=null;
			String text ="";
			do {
				Message message =consumer.receive(WAIT_PERIOD);
				
				if (null!=message){
					final String jmsMessageID = message.getJMSMessageID();
					
					if((lastmessage==null)||!jmsMessageID.equals(lastmessage.getJMSMessageID())) {
						boolean isMessageReaded=false;
						text = ((TextMessage) message).getText();
						lastmessage=message;
						try {
							isMessageReaded = (message.getIntProperty(MessageConstants.getSenderId()) != sender.getId());
						}catch (NumberFormatException e){
							e.printStackTrace();
						}
						if(isMessageReaded) {
							try {
								sleep(waitBeforeAknowledgement);
							} catch (InterruptedException e) {
								System.out.println("nosleep");
							}
							System.out.println("I'm aknowledging");
							message.acknowledge();
						}
						System.out.println(text);
					}
				}
		
				synchronized(sender) {
					exit=sender.getStopChat().get();
				}
			} while (!exit);
			consumer.close();
			session.close();
			connection.close();
		} catch (JMSException e) {
			e.printStackTrace();
		}
	
	}
	
	
}
