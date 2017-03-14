package ru.fedinskiy;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by fedinskiy on 14.03.17.
 */
public class ChatPerson {
	private final String nickname;
	private final int id;
	private AtomicBoolean stopChat;
	
	public ChatPerson(String nickname, int id, AtomicBoolean stopChat) {
		this.nickname = nickname;
		this.id = id;
		this.stopChat = stopChat;
	}
	
	public String getNickname() {
		return nickname;
	}
	
	public AtomicBoolean getStopChat() {
		return stopChat;
	}
	
	public int getId() {
		return id;
	}
}
