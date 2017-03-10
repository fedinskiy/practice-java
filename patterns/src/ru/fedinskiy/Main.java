package ru.fedinskiy;

import ru.fedinskiy.chain.BabkiRumors;
import ru.fedinskiy.chain.OfficeRumors;
import ru.fedinskiy.chain.TeshaRumors;
import ru.fedinskiy.keeper.CareTaker;
import ru.fedinskiy.keeper.Level;
import ru.fedinskiy.strategy.BankStrategy;
import ru.fedinskiy.strategy.Context;
import ru.fedinskiy.strategy.MailStrategy;
import ru.fedinskiy.strategy.WebMoneyStrategy;


/**
 * Created by fedinskiy on 08.03.17.
 */
public class Main {
	public static void main(String[] args) {
		Context context=new Context();
		context.addStrateguy(new BankStrategy().withPercent(13));
		context.addStrateguy(new MailStrategy());
		context.addStrateguy(new WebMoneyStrategy());
	
		context.sendMoney(1000_000);
	}
}
