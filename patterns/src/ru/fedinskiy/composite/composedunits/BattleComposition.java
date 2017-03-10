package ru.fedinskiy.composite.composedunits;

import ru.fedinskiy.composite.interfaces.BattleUnit;
import ru.fedinskiy.composite.interfaces.Unit;

/**
 * Created by fedinskiy on 08.03.17.
 */
public class BattleComposition extends ArmyUnit implements BattleUnit{
	@Override
	public int getAmmunition() {
		int totalNumber=0;
		for (Unit unit:units){
			if(unit instanceof BattleUnit) {
				totalNumber += ((BattleUnit) unit).getAmmunition();
			}
		}
		return totalNumber;
	}
}
