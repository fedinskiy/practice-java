package ru.fedinskiy;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by fedinskiy on 14.03.17.
 */
public class Application {
	public static void main(String[] args) {
		AtomicBoolean stopChat=new AtomicBoolean(false);
		final String nick;
		Scanner scanner=new Scanner(System.in);
		System.out.println("Write your nickname");
		if(scanner.hasNextLine()) {
			nick = scanner.nextLine();
			Thread thread = new Thread(new Consumer(stopChat));
			thread.start();
			Thread prodThread = new Thread(new Producer(nick,stopChat));
			
			prodThread.start();
		}
		
	}
}
