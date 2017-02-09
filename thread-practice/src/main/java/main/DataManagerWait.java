package main;

/**
 * Created by fedinskiy on 09.02.17.
 */
public class DataManagerWait {
    public static final Object lock= new Object();
    public static  boolean ready=false;

    public static void sendData(){
        try {
                if(!ready)lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Data sended");

    }

    public static void prepareData(){
        synchronized (lock){
            System.out.println("Prepared");
            lock.notify();

        }
}

}
