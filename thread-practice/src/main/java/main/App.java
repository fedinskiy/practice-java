package main;

import java.util.Random;

/**
 * Created by fedinskiy on 09.02.17.
 */
public class App {
    public static volatile int  count=0;
    public static Object locker=new Object();

    public static void main(String[] args) {
        Runnable myRunnable = new Runnable() {
            public void run() {
                Random rand = new Random();
                /*try {
                    Thread.sleep(rand.nextInt(10000));

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
                synchronized (locker) {
                    count++;
                    System.out.println(count);
                }
            }
        };

        for(int i =0;i<100;i++){
            Thread thread = new Thread(myRunnable);
            thread.start();
        }
    }
}
