package ru.fdudinskiy;

import ru.fdudinskiy.consumer.Consumer;
import ru.fdudinskiy.generator.Generator;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        HashMap<Integer, Integer> numberCounter = new HashMap<Integer, Integer>(100);
        Boolean stopFlag=false;
        Thread[] threads= new Thread[2];


        Generator generator = new Generator(numberCounter,stopFlag);
        Consumer consumer= new Consumer(numberCounter,stopFlag);

        threads[0]=new Thread(generator);
        threads[1]=new Thread(consumer);

        for(Thread t :threads){
            t.setDaemon(true);
            t.run();
        }

        for(Thread t :threads){
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
