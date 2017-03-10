package ru.fedinskiy.composite.composedunits;

import ru.fedinskiy.composite.interfaces.BattleUnit;
import ru.fedinskiy.composite.interfaces.FinancialUnit;
import ru.fedinskiy.composite.interfaces.Unit;

/**
 * Created by fedinskiy on 08.03.17.
 */
	public class FinancialComposition extends BattleComposition implements FinancialUnit{
	
	@Override
	public long getBudget() {
		int totalNumber=0;
		for (Unit unit:units){
			if(unit instanceof FinancialUnit) {
				totalNumber += ((FinancialUnit) unit).getBudget();
			}
		}
		return totalNumber;
	}
}
