package main;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by fedinskiy on 09.02.17.
 */
public class AtomicMain {
    public static volatile AtomicInteger count=new AtomicInteger(0);
    public static Object locker=new Object();

    public static void main(String[] args) {
        Runnable myRunnable = new Runnable() {
            public void run() {
                Random rand = new Random();
                    count.addAndGet(1);
                    System.out.println(count);
            }
        };

        for(int i =0;i<100;i++){
            Thread thread = new Thread(myRunnable);
            thread.start();
        }
    }
}
