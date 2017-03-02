package ru.fdudinskiy.consumer;

import java.util.HashMap;

/**
 * Created by fedinskiy on 13.02.17.
 */
public class Consumer implements Runnable {
	private final HashMap<Integer, Integer> numberCount;
	private volatile Boolean stopFlag;
	
	public Consumer(HashMap<Integer, Integer> numberCount, Boolean stopFlag) {
		System.out.println("Consumer Constructor");
		this.numberCount = numberCount;
		this.stopFlag = stopFlag;
	}
	
	@Override
	public void run() {
		System.out.println("Consumer run");
		do {
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (numberCount) {
				System.out.println();
//				needToStop = stopFlag;
				if (!stopFlag.booleanValue()) {
					System.out.println("создано чисел:" + numberCount.size());
				} else {
					numberCount.notify();
					return;
				}
				numberCount.notify();
			}
		} while (!stopFlag.booleanValue());
	}
	
	
}
