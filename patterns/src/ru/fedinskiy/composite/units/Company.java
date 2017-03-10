package ru.fedinskiy.composite.units;

import ru.fedinskiy.composite.composedunits.ArmyUnit;
import ru.fedinskiy.composite.interfaces.BattleUnit;

/**
 * Created by fedinskiy on 08.03.17.
 */
public class Company extends ArmyUnit implements BattleUnit {
	private int ammunition;
	
	public Company(int ammunition) {
		this.ammunition = ammunition;
	}
	
	@Override
	public int getAmmunition() {
		return ammunition;
	}
	
	@Override
	protected Company clone() throws CloneNotSupportedException {
		final Company clone = (Company) super.clone();
		clone.ammunition=this.ammunition;
		return clone;
	}
}
