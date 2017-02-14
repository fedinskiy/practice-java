package models;

import java.io.Serializable;

/**
 * Created by sa on 08.02.17.
 */
public class Car implements Serializable{
    private int price;
    private String model;
    private String regNum;

    public int getPrice() {
        return price;
    }

    @Override
    public int hashCode() {
        return regNum.hashCode() * 21;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null){
            return false;
        }

        if (obj == this){
            return true;
        }

        if(!(obj instanceof Car)){
            return false;
        }

        Car car = (Car) obj;
        if(this.getRegNum().equals(car.getRegNum())){
            return true;
        }
        return false;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRegNum() {
        return regNum;
    }

    public void setRegNum(String regNum) {
        this.regNum = regNum;
    }

    public Car(int price, String model, String regNum) {

        this.price = price;
        this.model = model;
        this.regNum = regNum;
    }
}
