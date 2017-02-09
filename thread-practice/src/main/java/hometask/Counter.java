package hometask;

/**
 * Created by fedinskiy on 09.02.17.
 */
public class Counter {
    public static final Object lock = new Object();
    private static volatile int elapsedTime = 0;

    public void countSeconds() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (lock) {
            elapsedTime++;
            lock.notify();
        }
    }

    public void showSeconds(int frequency, int stopAfter) {
        int time=0;
        int lastTime=0;
        while (true) {
            synchronized (lock) {
                try {
                    lock.wait();
                    time=elapsedTime;
                    lock.notify();

                    if(time>stopAfter)  return;
                    if(time != lastTime){
                        if ((time % frequency) == 0) {
                            System.out.println(frequency+" seconds count: " + time);
                           }
                        lastTime=time;
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
                //System.out.println("Waiting for lock");

        }
    }
}
