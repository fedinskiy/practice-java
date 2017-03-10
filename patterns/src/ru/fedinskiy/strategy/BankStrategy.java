package ru.fedinskiy.strategy;

/**
 * Created by fedinskiy on 09.03.17.
 */
public class BankStrategy extends SendStrategy {


	@Override
	public void sendMoney(int sum) {
		System.out.println("you send " +sum+" with percent "+this.getPercent());
	}
	public BankStrategy withPercent(int sum){
		this.setPercent(sum);
		return this;
	}
}
