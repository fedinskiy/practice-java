package ru.fedinskiy.adaptor;

/**
 * Created by fedinskiy on 08.03.17.
 */
public class AdapterGeneralizeTelegram extends TelegramBot implements Bot {
	@Override
	public void sendMessage(String message, int userID) {
		this.sendMessage(message, searchGroupID(),userID);
	}
	
	private int searchGroupID() {
		return 0;
	}
	
	@Override
	public void sendSpam(String message, int num) {
		
	}
	
	@Override
	public void sleep(float millis) {
		
	}
}
