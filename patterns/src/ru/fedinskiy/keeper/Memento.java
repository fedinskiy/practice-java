package ru.fedinskiy.keeper;

/**
 * Created by fedinskiy on 09.03.17.
 */
public class Memento {
	private final String state;
	
	public Memento(String state) {
		this.state = state;
	}
	
	public String getState() {
		return state;
	}
}
