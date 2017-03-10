package ru.fedinskiy.composite.composedunits;

import ru.fedinskiy.composite.interfaces.Unit;

import java.util.ArrayList;

/**
 * Created by fedinskiy on 08.03.17.
 */
public abstract class ArmyUnit implements Unit, Cloneable {
	protected ArrayList<Unit> units=new ArrayList<>();
	
	@Override
	public int getNumberOfSoldiers() {
		int totalNumber=0;
		for (Unit unit:units){
			totalNumber+=unit.getNumberOfSoldiers();
		}
		return totalNumber;
	}
	
	public void add(Unit unit){
		units.add(unit);
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		ArmyUnit armyUnit= (ArmyUnit) super.clone();
		armyUnit.units= (ArrayList<Unit>) this.units.clone();
		return armyUnit;
	}
}
