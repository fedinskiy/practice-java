package main;

/**
 * Created by fedinskiy on 09.02.17.
 */
public class DataManagerSimple {
    private static boolean ready=false;

    public static void sendData(){
        while (!ready){
            System.out.println("Waiting for data");
        }
        System.out.println("Data sended");
    }

    public static void prepareData(){
        System.out.println("Data prepared");
        ready=true;
    }

}
