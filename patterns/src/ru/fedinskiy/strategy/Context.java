package ru.fedinskiy.strategy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fedinskiy on 09.03.17.
 */
public class Context {
	private SendStrategy currentStrategy;
	private List<SendStrategy> availableStrategies=new ArrayList<SendStrategy>();
	
	public void addStrateguy(SendStrategy strategy) {
		availableStrategies.add(strategy);
	}
	
	public void sendMoney(int sum){
		chooseStrategy();
		currentStrategy.sendMoney(sum);
	}
	
	private void chooseStrategy() {
		SendStrategy tempStrategy = new BankStrategy();
		tempStrategy.setPercent(100);
		tempStrategy.setPercent(200);
		
		for (SendStrategy strategy : availableStrategies) {
			if (strategy.getTime() > 4) {
				continue;
			}
			if (strategy.getPercent() < tempStrategy.getPercent()) {
				tempStrategy = strategy;
			}
		}
		currentStrategy=tempStrategy;
	}
}
