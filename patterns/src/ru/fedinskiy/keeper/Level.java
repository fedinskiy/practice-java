package ru.fedinskiy.keeper;

/**
 * Created by fedinskiy on 09.03.17.
 */
public class Level {
	public String state;
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public Memento saveState(){
		return new Memento(state);
	}
	
	public void restoreState(Memento memento){
		state=memento.getState();
	}
}
