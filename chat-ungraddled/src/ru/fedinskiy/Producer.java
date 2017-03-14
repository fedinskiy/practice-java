package ru.fedinskiy;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by fedinskiy on 14.03.17.
 */
public class Producer implements Runnable {
	private String nickname;
	private AtomicBoolean stopChat;
	
	public Producer(String nickname, AtomicBoolean stopChat) {
		this.nickname = nickname;
		this.stopChat=stopChat;
	}
	
	@Override
	public void run() {
		ActiveMQConnectionFactory factory= new ActiveMQConnectionFactory("tcp://localhost:61616");
		try {
			String message="";
			Scanner scanner = new Scanner(System.in);
			
			Connection connection=factory.createConnection();
			connection.start();
			Session session=connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			Destination destination=session.createTopic("Dest");
			MessageProducer producer=session.createProducer(destination);
			producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
			
			producer.send(session.createTextMessage(nickname+" is joined chat"));
			
			message=scanner.nextLine();
			while(!message.equals("exit")) {
				TextMessage textMessage = session.createTextMessage(nickname+": "+message);
				producer.send(textMessage);
				message=scanner.nextLine();
			}
			synchronized(stopChat) {
				stopChat.set(true);
			}
			
			session.close();
			connection.close();
			
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}
