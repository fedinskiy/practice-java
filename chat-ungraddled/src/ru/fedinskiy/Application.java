package ru.fedinskiy;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

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
			System.out.println("Введите время, которое данный пользователь чата должен ждать перед отправкой опещения о прочтении сообщения");
			final Integer wait = Integer.parseInt(scanner.nextLine());
			final int id=new Random().nextInt();
			ChatPerson person=new ChatPerson(nick, id, new AtomicBoolean(false));
			Thread thread = new Thread(new Consumer(person,wait));
			thread.start();
			Thread prodThread = new Thread(new Producer(person));
			
			prodThread.start();
		}
		
	}
}
