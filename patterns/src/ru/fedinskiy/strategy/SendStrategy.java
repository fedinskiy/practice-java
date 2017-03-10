package ru.fedinskiy.strategy;

/**
 * Created by fedinskiy on 09.03.17.
 */
public abstract class SendStrategy {
	private int time;
	private int percent;
			
	public abstract void sendMoney(int sum);
	
	public int getTime() {
		return time;
	}
	
	public void setTime(int time) {
		this.time = time;
	}
	
	public int getPercent() {
		return percent;
	}
	
	public void setPercent(int percent) {
		this.percent = percent;
	}
}
