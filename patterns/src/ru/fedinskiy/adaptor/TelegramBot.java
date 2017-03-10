package ru.fedinskiy.adaptor;

/**
 * Created by fedinskiy on 08.03.17.
 */
public class TelegramBot {
	public void sendMessage(String message, int groupId, int userID) {
		System.out.println("sending message " + message + " to " + userID + " from " + groupId);
	}
	
	public void sendSpam(int num, String message) {
		System.out.println("You send spam to " + num + " people ");
	}
	
	public void sleep(int millis) {
		System.out.println("You sleep for " + millis + " ms");
	}
}
