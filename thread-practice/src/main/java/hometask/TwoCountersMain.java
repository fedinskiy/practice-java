package hometask;

/**
 * Created by fedinskiy on 09.02.17.
 */
public class TwoCountersMain {
    public static void main(String[] args) {

        Thread thSec= new Thread(new Runnable() {
            public void run() {
                Counter counter=new Counter();
                for(int i=0;i<25;++i) {
                    counter.countSeconds();
                }
            }
        });
        Thread th1= new Thread(new Runnable() {
            public void run() {
                Counter counter=new Counter();
                    counter.showSeconds(1,20);

            }
        });
        Thread th5= new Thread(new Runnable() {
            public void run() {
                Counter counter=new Counter();
                counter.showSeconds(5,20);

            }
        });
        Thread th7= new Thread(new Runnable() {
            public void run() {
                Counter counter=new Counter();
                counter.showSeconds(7,20);

            }
        });
        thSec.start();
        th1.start();
        th5.start();
        th7.start();
    }
}
