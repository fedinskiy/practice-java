package ru.fedinskiy.composite.units;

import ru.fedinskiy.composite.interfaces.Unit;

/**
 * Created by fedinskiy on 08.03.17.
 */
public class Squad implements Unit {
	private int numberOfSoldiers;
	
	public Squad(int numberOfSoldiers) {
		this.numberOfSoldiers = numberOfSoldiers;
	}
	
	@Override
	public int getNumberOfSoldiers() {
		return numberOfSoldiers;
	}
	
	public void setNumberOfSoldiers(int numberOfSoldiers) {
		this.numberOfSoldiers = numberOfSoldiers;
	}
	
	@Override
	protected Squad clone() throws CloneNotSupportedException {
		final Squad clone = (Squad) super.clone();
		clone.numberOfSoldiers = this.numberOfSoldiers;
		return clone;
	}
}
