package CarShop;

import models.Car;
import models.Order;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.rmi.UnexpectedException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by fedinskiy on 13.02.17.
 */
class StoreTest {
    static Store store;

    @BeforeEach
    public void initStore(){
        store=new Store();
        assertNotNull(store);
    }

    @Test
    void createCar() {

        store.createCar(100,"Lada","abc");
        assertNotNull(store.getFreeCars());
        assertTrue(store.getFreeCars().size()>0);
        store.getFreeCars().stream().forEach((car1)->{
                assertEquals(car1.getPrice(),100);
                assertEquals(car1.getModel(),"Lada");
                assertEquals(car1.getRegNum(),"abc");
        });
    }

    @Test
    void save() {

    }

    @Test
    void recover() {

    }

    @Test
    void getFirstOrder() {
        Order order=store.getFirstOrder();
        assertNotNull(order);
    }

    @Test()
    void sellCar() throws CarNotFoundException {
       assertThrows(CarNotFoundException.class, () -> {store.sellCar
                ("GAZ",
                        "John",
                        "Connor",
                        "798654321");        });
        store.createCar(100,"Lada","ABC");
        store.sellCar("Lada", "John","Connor","798654321" );
        assertTrue(store.getFreeCars().size()==0);


        assertTrue(store.getOrders().stream().filter((order1) -> (order1.getCar()
                .getModel().equals("Lada"))
                    && (order1.getCar().getPrice()==100)
                    && (order1.getCar().getRegNum()=="ABC")).count()>0);

        assertTrue(store.getContractList().size()==1);
        assertTrue(store.getContractList().values().stream().filter(
                (client ->
                        client.getFirstName()=="John"
                                &&client.getLastName()=="Connor"
                &&client.getPhoneNumber()=="798654321")
                ).count()>0);

    }

    @Test
    void getContractList(){
        assertNotNull(store.getContractList());
        assertTrue(store.getContractList().size()==0);
    }

    @Test
    void getOrders() {

    }

    @Test
    void getFreeCars() {

    }

}