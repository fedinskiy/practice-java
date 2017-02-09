package hometask;

/**
 * Created by fedinskiy on 09.02.17.
 */
public class TwoCountersMain {
    public static void main(String[] args) {
        final int countUntil=20;
        Thread thSec= new Thread(new Runnable() {
            public void run() {
                Counter counter=new Counter();
                for(int i=0;i<countUntil;++i) {
                    counter.countSeconds();
                }
            }
        });
        Thread th1= new Thread(new Runnable() {
            public void run() {
                Counter counter=new Counter();
                    counter.showSeconds(1,countUntil);

            }
        });
        Thread th5= new Thread(new Runnable() {
            public void run() {
                Counter counter=new Counter();
                counter.showSeconds(5,countUntil);

            }
        });
        Thread th7= new Thread(new Runnable() {
            public void run() {
                Counter counter=new Counter();
                counter.showSeconds(7,countUntil);

            }
        });
        thSec.start();
        th1.start();
        th5.start();
        th7.start();
    }
}
