package ru.fdudinskiy.generator;

import java.util.HashMap;
import java.util.Random;

/**
 * Created by fedinskiy on 13.02.17.
 */
public class Generator implements Runnable {
    private final HashMap<Integer, Integer> numberCount;
    private volatile Boolean stopFlag;
    private final Random rand;
    private final int range = 10;

    public Generator(HashMap numberCount, Boolean stopFlag) {
        rand = new Random();
        this.numberCount = numberCount;
        this.stopFlag = stopFlag;
    }

    @Override
    public void run() {
        boolean needToStop;
        do {
            System.out.println("Generator run");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
	        System.out.println("Generator 2");
            synchronized (numberCount) {
	            System.out.println("Generator 3");
           //     try {
                    //numberCount.wait();
	                System.out.println("Generator 4");
               // } catch (InterruptedException e) {
               //     e.printStackTrace();
            //    }
                needToStop = stopFlag;
                int newNumber = rand.nextInt(range);
                System.out.println("nn: " + newNumber);

                addNumber(newNumber, numberCount);
                numberCount.notify();
	            try {
		            numberCount.wait();
	            } catch (InterruptedException e) {
		            e.printStackTrace();
	            }
            }
//            numberCount.notify();
        } while (!stopFlag);
    }

    public void addNumber(int number, HashMap<Integer, Integer> numberCount) {
        Integer count = numberCount.get(number);
        if (null == count || count == 0) {
            count = 1;
        } else {
            count = count + 1;
        }
        numberCount.put(number, count);
        System.out.println("size is" + numberCount.size());
        if ((range) == numberCount.size()) {
            stopFlag = true;
        }
    }
}
