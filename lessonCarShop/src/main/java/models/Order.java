package models;

import com.sun.org.apache.xpath.internal.operations.Or;

import java.io.Serializable;

/**
 * Created by sa on 08.02.17.
 */
public class Order implements Serializable {
    private Car car;
    private int sum;
    private long orderNumber;
    private short orgNumber;

    @Override
    public String toString() {
        return car.getModel() + " Regnum: " +
                car.getRegNum() + " sum: " + sum +
                " orderNum: " + orderNumber +
                " orgNumber: " + orgNumber;
    }

    public short getOrgNumber() {
        return orgNumber;
    }

    public void setOrgNumber(short orgNumber) {
        this.orgNumber = orgNumber;
    }

    public Order(Car car, int sum, long orderNumber, short orgNumber) {
        this.car = car;
        this.sum = sum;
        this.orderNumber = orderNumber;
        this.orgNumber = orgNumber;
    }

    @Override
    public int hashCode() {
        return (int) (orderNumber * 21 + orgNumber);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null){
            return false;
        }

        if(obj == this){
            return true;
        }

        if(!(obj instanceof Order)){
            return false;
        }

        Order order = (Order)obj;
        if(this.getOrderNumber() == order.getOrderNumber()
                && this.getOrgNumber() == order.getOrderNumber()){
            return true;
        }
        return false;
    }

    public Car getCar() {

        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(long orderNumber) {
        this.orderNumber = orderNumber;
    }
}
