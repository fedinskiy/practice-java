import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by fedinskiy on 14.03.17.
 */
public class Consumer implements Runnable{
	
	private final int TEN_SECONDS = 10000;
	
	@Override
	public void run() {
		ActiveMQConnectionFactory factory= new ActiveMQConnectionFactory("tcp://localhost:61616");
		Connection connection= null;
		try {
			connection = factory.createConnection();
			connection.start();
			Session session=connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			Destination destination=session.createQueue("Dest");
			MessageConsumer consumer=session.createConsumer(destination);
			Message message =consumer.receive(TEN_SECONDS);
			System.out.println(((TextMessage )message).getText());
			session.close();
			connection.close();
		} catch (JMSException e) {
			e.printStackTrace();
		}
	
	}
}
