package ru.fedinskiy.adaptor;

/**
 * Created by fedinskiy on 08.03.17.
 */
public class AdapterCompositionVK implements Bot {
	private static final int DELAY=100;
	private VKBot bot = new VKBot();
	
	@Override
	public void sendMessage(String message, int userID) {
		bot.sendMessage(message, checkIsFriend(), userID);
	}
	
	private boolean checkIsFriend() {
		return false;
	}
	
	@Override
	public void sendSpam(String message, int num) {
		bot.sendSpam(message, num,DELAY);
	}
	
	@Override
	public void sleep(float millis) {
		
	}
}
