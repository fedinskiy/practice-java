package ru.fedinskiy;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final int LOOK_COUNTER=1_000_000;
    static List<Object> cache = new LinkedList<>();
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
        	
            switch (sc.next()){
                case "collectable":
	                System.out.println("collectable");
                	createBigObject();
	                break;
                case "clickable":
	                System.out.println("clickable");
                	cache.add(createBigObject());
                	break;
                default:break;
            }
        }
    }
    
    public static List<Object> createBigObject(){
        Random rand = new Random();
        List<Object> result = new LinkedList<>();
        for(int i=0; i< LOOK_COUNTER; i++){
            String tmp = "anyString "+rand.nextInt();
            result.add(tmp);
	        System.out.println(tmp);
        }
	    return result;
    }
}
