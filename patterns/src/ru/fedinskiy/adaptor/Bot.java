package ru.fedinskiy.adaptor;

/**
 * Created by fedinskiy on 08.03.17.
 */
public interface Bot {
	public void sendMessage(String message, int userID);
	public void sendSpam(String message, int num);
	public void sleep(float millis);
}
