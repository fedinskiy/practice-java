import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by fedinskiy on 14.03.17.
 */
public class Producer implements Runnable {
	private String nickname;
	
	public Producer(String nickname) {
		this.nickname = nickname;
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
			Destination destination=session.createQueue("Dest");
			MessageProducer producer=session.createProducer(destination);
			producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
			
			message=scanner.nextLine();
			while(!message.equals("exit")) {
				TextMessage textMessage = session.createTextMessage(message);
				producer.send(textMessage);
				message=scanner.nextLine();
			}
		
			
			session.close();
			connection.close();
			
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}
