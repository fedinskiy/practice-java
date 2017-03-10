package ru.fedinskiy.keeper;

/**
 * Created by fedinskiy on 09.03.17.
 */
public class CareTaker {
	private Memento holdState;
	
	public Memento getHoldState() {
		return holdState;
	}
	
	public void setHoldState(Memento holdState) {
		this.holdState = holdState;
	}
}
