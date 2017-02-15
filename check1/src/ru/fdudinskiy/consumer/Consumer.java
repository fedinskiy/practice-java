package ru.fdudinskiy.consumer;

import java.util.HashMap;

/**
 * Created by fedinskiy on 13.02.17.
 */
public class Consumer implements Runnable {
    private final HashMap<Integer, Integer> numberCount;
    private volatile Boolean stopFlag;

    public Consumer(HashMap<Integer, Integer> numberCount, Boolean stopFlag) {
        this.numberCount = numberCount;
        this.stopFlag = stopFlag;
    }

    @Override
    public void run() {
        boolean needToStop;
        do {
            System.out.println("Consumer run");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (numberCount) {
                try {
                    numberCount.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println();
                needToStop=stopFlag;
                if (!needToStop) {
                    System.out.println("создано чисел:" + numberCount.size());
                } else {
                    numberCount.notify();
                    return;
                }
                numberCount.notify();
            }
        }while(!stopFlag);
    }


}
