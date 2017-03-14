package ru.fedinskiy;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.util.Scanner;

import static ru.fedinskiy.MessageConstants.getConnectionName;
import static ru.fedinskiy.MessageConstants.getConnectionSocket;

/**
 * Created by fedinskiy on 14.03.17.
 */
public class Producer implements Runnable {
	private ChatPerson sender;
	
	public Producer(ChatPerson sender) {
		this.sender = sender;
	}
	
	public String nickname() {
		return sender.getNickname();
	}
	
	@Override
	public void run() {
		ActiveMQConnectionFactory factory= new ActiveMQConnectionFactory(getConnectionSocket());
		try {
			final Connection connection=factory.createConnection();
			connection.start();
			Session session=connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);
			final Topic destination= session.createTopic(getConnectionName());
			final MessageProducer producer=session.createProducer(destination);
			final Scanner scanner = new Scanner(System.in);
			producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
			
			System.out.println("Your id is "+sender.getId());
			sendTextMessage(nickname()+" is joined chat",session,producer);
			
			String message=scanner.nextLine();
			while(!message.equals("exit")) {
				sendTextMessage(nickname()+": "+message,session,producer);
				System.out.println("Сообщение "+message+" получено");
				message=scanner.nextLine();
			}
			sendTextMessage(nickname()+" покинул чат",session,producer);
			
			synchronized(sender) {
				sender.getStopChat().set(true);
			}
			
			producer.close();
			session.close();
			connection.close();
			
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
	
	private void sendTextMessage(String text, Session session,MessageProducer producer ) throws JMSException {
		final TextMessage textMessage = session.createTextMessage(text);
		
		textMessage.setIntProperty(MessageConstants.getSenderId(),sender.getId());
		producer.send(textMessage);
	}
}
