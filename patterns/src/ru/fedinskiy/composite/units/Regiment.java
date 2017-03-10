package ru.fedinskiy.composite.units;

import ru.fedinskiy.composite.composedunits.BattleComposition;
import ru.fedinskiy.composite.interfaces.FinancialUnit;

/**
 * Created by fedinskiy on 08.03.17.
 */
public class Regiment extends BattleComposition implements FinancialUnit {
	private long budget;
	
	public Regiment(long budget) {
		this.budget = budget;
	}
	
	@Override
	public long getBudget() {
		return budget;
	}
	
	@Override
	protected Regiment clone() throws CloneNotSupportedException {
		final Regiment clone = new Regiment(this.budget);
		return clone;
	}
}
