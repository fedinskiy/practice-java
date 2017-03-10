package ru.fedinskiy.strategy;

/**
 * Created by fedinskiy on 09.03.17.
 */
public class WebMoneyStrategy extends SendStrategy {
	
	public WebMoneyStrategy(){
		setPercent(200);
	}
	
	@Override
	public void sendMoney(int sum) {
		System.out.println("you sent money "+sum+" with webmoney");
	}
	
	@Override
	public int getTime() {
		return 0;
	}
	
	@Override
	public void setPercent(int Percent) {
		
	}
}
