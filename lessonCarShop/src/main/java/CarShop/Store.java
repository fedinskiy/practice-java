package CarShop;

import datamanager.DataManager;
import models.Car;
import models.Client;
import models.Order;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

/**
 * Created by sa on 08.02.17.
 */

public class Store {
    private HashMap<Order, Client> contractList = new HashMap<>(256);
    private HashSet<Car> cars = new HashSet<>(32);
    private HashSet<Client> clients = new HashSet<>(256);
    private static final String FILE_CONTRACTS = "fileContracts.txt";
    private static final String FILE_CARS = "fileCars.txt";
    private static final String FILE_CLIENTS = "fileClients.txt";

    private static Logger logger = Logger.getLogger(Store.class);

    static {
        DOMConfigurator.configure("src/main/resources/log4j.xml");
    }

    public void createCar(int price, String model,
                          String regNumber) {
        Car car = new Car(price, model, regNumber);
        cars.add(car);
    }

    public void save() {
        DataManager.serialize(cars, FILE_CARS);
        DataManager.serialize(clients, FILE_CLIENTS);
        DataManager.serialize(contractList, FILE_CONTRACTS);
    }

    public void recover() {
        ArrayList<Car> list = new ArrayList<>();
        DataManager.deserialize(FILE_CARS, list);
        for (Car car :
                list) {
            cars.add(car);
        }

        ArrayList<Client> listClient = new ArrayList<>();
        DataManager.deserialize(FILE_CLIENTS, listClient);
        for (Client client :
                listClient) {
            clients.add(client);
        }

        ArrayList<Order> contractListOne = new ArrayList<>();
        ArrayList<Client> contractListTwo = new ArrayList<>();
        DataManager.deserialize(FILE_CONTRACTS, contractList);
    }

    public Order getFirstOrder() {
        for (Order order :
                contractList.keySet()) {
            return order;
        }
        return null;

    }

    public void sellCar(String model,
                        String firstName,
                        String lastName,
                        String phoneNumber) throws CarNotFoundException {
        Client client = new Client(firstName,
                lastName, phoneNumber);
        clients.add(client);

        Car tmpCar = null;
        for (Car car :
                cars) {
            if (car.getModel().equals(model)) {
                tmpCar = car;
                break;
            }
        }
        if (tmpCar != null) {
            Random random = new Random();
            Order order = new Order(tmpCar,
                    tmpCar.getPrice() * 2,
                    random.nextLong(), (short) 80
            );
            contractList.put(order, client);
            cars.remove(tmpCar);
        } else {
            CarNotFoundException ex=new CarNotFoundException();
            logger.error("car with model "+model+" was not found", ex);
            throw ex;
        }
    }

    public ArrayList<Order> getOrders() {
        return new ArrayList<Order>(contractList.keySet());
    }

    public ArrayList<Car> getFreeCars() {
        ArrayList<Car> cars = new ArrayList<>(this.cars.size());
        cars.addAll(cars);
        return cars;
    }

    public HashMap<Order, Client> getContractList() {
        return contractList;
    }
}
