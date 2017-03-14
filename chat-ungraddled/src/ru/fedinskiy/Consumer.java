package ru.fedinskiy;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by fedinskiy on 14.03.17.
 */
public class Consumer implements Runnable{
	
	private final int WAIT_PERIOD = 10000;
	private AtomicBoolean stopChat;
	
	public Consumer(AtomicBoolean stopChat) {
		this.stopChat=stopChat;
	}
	
	@Override
	public void run() {
		ActiveMQConnectionFactory factory= new ActiveMQConnectionFactory("tcp://localhost:61616");
		Connection connection= null;
		boolean exit=false;
		try {
			connection = factory.createConnection();
			connection.start();
			Session session=connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			Destination destination=session.createTopic("Dest");
			MessageConsumer consumer=session.createConsumer(destination);
			
			
			Message lastmessage=null;
			String text ="";
			do {
				Message message =consumer.receive(WAIT_PERIOD);
				
				if (null!=message){
					final String jmsMessageID = message.getJMSMessageID();
					if((lastmessage==null)||!jmsMessageID.equals(lastmessage.getJMSMessageID())) {
						text = ((TextMessage) message).getText();
						lastmessage=message;
						System.out.println(text);
					}
				}
		
				synchronized(stopChat) {
					exit=stopChat.get();
				}
			} while (!exit);
			
			session.close();
			connection.close();
		} catch (JMSException e) {
			e.printStackTrace();
		}
	
	}
}
