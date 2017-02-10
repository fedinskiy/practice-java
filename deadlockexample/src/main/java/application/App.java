package application;

/**
 * Created by fedinskiy on 10.02.17.
 */
public class App {
    public static void main(String[] args) {
        final Object lock1 = new Object();
        final Object lock2 = new Object();

        Runnable run1 = new Runnable() {
            public void run() {
                System.out.println("t1 lock1");
                synchronized (lock1){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (lock2){
                        System.out.println("th1 loch2");
                    }
                }
            }
        };
        Runnable run2 = new Runnable() {
            public void run() {
                System.out.println("t2 lock1");
                synchronized (lock2){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (lock1){
                        System.out.println("th2 loch2");
                    }
                }
            }
        };

        Thread th1 = new Thread(run1);
        Thread th2 = new Thread(run2);
        th1.start();
        th2.start();
    }
}
