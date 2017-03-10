package ru.fedinskiy.strategy;

/**
 * Created by fedinskiy on 09.03.17.
 */
public class MailStrategy extends SendStrategy{
	private int percent;
	
	public MailStrategy() {
		this.setTime(3);
	}
	
	@Override
	public void sendMoney(int sum) {
		System.out.println("you send sum "+sum +" with percent "+" and delays three days");
	}
}
