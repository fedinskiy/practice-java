package ru.fedinskiy.adaptor;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by fedinskiy on 08.03.17.
 */
public class VKBot {
	public void sendMessage(String message, boolean isFriend, int userID){
		System.out.println("You sent message to user in VK");
	}
	public void sendSpam(String message, int num, int delay){
		
	}
	public void sleep(float millis){
		System.out.println("Not implemented");
	}
}
