package ru.fedinskiy.observer;

import java.awt.image.ImageObserver;

/**
 * Created by fedinskiy on 09.03.17.
 */
public class Researcher implements IObserver {
	private int i;
	public Researcher(int i) {
		this.i=i;
	}
	
	@Override
	public void message(String message) {
		System.out.println("message "+message+", mr "+i);
		
	}
}
