import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by fedinskiy on 14.03.17.
 */
public class Producer implements Runnable {
	
	@Override
	public void run() {
		ActiveMQConnectionFactory factory= new ActiveMQConnectionFactory("vm://localhost");
		try {
			Connection connection=factory.createConnection();
			connection.start();
			Session session=connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			Destination destination=session.createQueue("Dest");
			MessageProducer producer=session.createProducer(destination);
			producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
			TextMessage textMessage = session.createTextMessage("Hello world");
			producer.send(textMessage);
			session.close();
			connection.close();
			
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}
