package consumer;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by fedinskiy on 13.02.17.
 */
public class Shuffler {
    public Boolean IsShuffle(String str1, String str2){
        boolean wasFound;
        if (str1.equals(str2)){
            return false;
        }
        if (str1.length()!=str2.length()){
            return false;
        }

        for(char c1:str1.toCharArray()){
            wasFound=false;
            for(char c2:str2.toCharArray()){
                if (c1==c2){
                    wasFound=true;
                    break;
                }
            }
           if(!wasFound) {
               return false;
           }
        }
        return true;

    }

    public static void main(String[] args) {
        System.out.println(counter(1,32));
    }
    public static Integer counter(Integer start, Integer end){
        int count=0;
        for(int i=start;i<=end;i++){
            for (int pow=0;pow<=8;pow++){
                int bar= (int) (1*Math.pow(10,pow));
                int barrier=3*(bar/10);
                barrier=barrier==0?3:barrier;
                if (i<barrier) break;
                if  ((i%bar)==barrier||(i/bar==3)){
                    System.out.println(i);
                    count++;
                }
            }
        }
        return count;
    }
}
