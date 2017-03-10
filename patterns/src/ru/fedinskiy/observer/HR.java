package ru.fedinskiy.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fedinskiy on 09.03.17.
 */
public class HR implements IObservable {
	private List<IObserver> observers = new ArrayList<>();
	private final String name;
	
	public HR(String name) {
		this.name = name;
	}
		
		@Override
	public void addObserver(IObserver observer) {
		observers.add(observer);
	}
	
	@Override
	public void removeObserver(IObserver observer) {
		observers.remove(observer);
	}
	
	@Override
	public void notifyAllObservers() {
		for(IObserver observer: observers){
			observer.message(name+" i found some job for you");
		}
	}
}
