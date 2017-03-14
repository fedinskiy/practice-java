import java.util.Scanner;

/**
 * Created by fedinskiy on 14.03.17.
 */
public class Application {
	public static void main(String[] args) {
		
		final String nick;
		Scanner scanner=new Scanner(System.in);
		System.out.println("Write your nickname");
		if(scanner.hasNextLine()) {
			nick = scanner.nextLine();
			Thread thread = new Thread(new Consumer());
			thread.start();
			Thread prodThread = new Thread(new Producer(nick));
			
			prodThread.start();
		}
		
	}
}
