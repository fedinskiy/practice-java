package main;

import java.util.Random;

/**
 * Created by fedinskiy on 09.02.17.
 */
public class WaitNotifyMain {
    public static void main(String[] args) {
        Thread th1= new Thread(new Runnable() {
            public void run() {
                Random random = new Random();
                try {
                    Thread.sleep(random.nextInt(1));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                DataManagerWait.prepareData();
            }
        });
        Thread th2= new Thread(new Runnable() {
            public void run() {
                Random random = new Random();
                try {
                    Thread.sleep(random.nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                DataManagerWait.sendData();
            }
        });
        th1.start();
        th2.start();
    }
}
