package ru.fedinskiy.composite.units;

import ru.fedinskiy.composite.composedunits.FinancialComposition;

/**
 * Created by fedinskiy on 08.03.17.
 */
public class Army extends FinancialComposition {
	public Army copy() throws CloneNotSupportedException {
		return (Army) this.clone();
	}
}
