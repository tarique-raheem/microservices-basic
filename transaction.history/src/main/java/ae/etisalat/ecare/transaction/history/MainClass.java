package ae.etisalat.ecare.transaction.history;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;

public class MainClass {

	private final static String QUEUE_NAME = "products";
	
	public static void main(String[] args) throws Exception{

		
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("10.140.0.5");
		try (Connection connection = factory.newConnection();
		     Channel channel = connection.createChannel()) {
			
			channel.queueDeclare(QUEUE_NAME, true, false, false, null);
			
			String message = "Hello World!";
			channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
			System.out.println(" [x] Sent '" + message + "'");

		}
		
		
		
		
	}

}
