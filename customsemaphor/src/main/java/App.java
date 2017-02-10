import calculators.BasicCalculator;
import calculators.Cubator;
import calculators.Kvadrator;
import calculators.Unator;
import consumer.Consumer;

/**
 * Created by fedinskiy on 10.02.17.
 */
public class App {
    public static void main(String[] args) {
        final Consumer consumer1 = new Consumer();
        final BasicCalculator[] calculators = new BasicCalculator[6];
        final Thread[] threads = new Thread[6];

        calculators[0]=new Cubator(consumer1,new int[]{3, 3});
        calculators[1] = new Kvadrator(consumer1,new int[]{3, 3});
        calculators[2] = new Unator(consumer1,new int[]{3, 3});

        calculators[3]= new Cubator(consumer1,new int[]{2, 2, 2});
        calculators[4] = new Kvadrator(consumer1,new int[]{2, 2, 2});
        calculators[5] = new Unator(consumer1,new int[]{2, 2, 2});

        for (int i=0;i<=5;++i){
            threads[i]=new Thread(calculators[i]);
            threads[i].start();
        }

        for (int i=0;i<=5;++i){
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Final");
        //consumer1.printMessage();
    }
}
