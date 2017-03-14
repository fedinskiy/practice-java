/**
 * Created by fedinskiy on 14.03.17.
 */
public class Application {
	public static void main(String[] args) {
		Thread thread = new Thread(new Consumer());
		thread.start();
		Thread prodThread = new Thread(new Producer());
		
		prodThread.start();
	}
}
