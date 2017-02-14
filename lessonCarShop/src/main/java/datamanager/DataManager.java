package datamanager;

import models.Car;
import models.Client;
import models.Order;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sa on 08.02.17.
 */
public class DataManager {
    private static final Logger logger = Logger.getLogger(DataManager.class);

    static {
        PropertyConfigurator.configure("src/main/resources/log4j.properties");
    }

    public static void serialize(Collection<? extends Serializable> list, String fileName) {
        fileName = "/C:x";
        try (FileOutputStream fos = new FileOutputStream(fileName);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            for (Serializable serializable :
                    list) {
                oos.writeObject(serializable);
            }

        } catch (FileNotFoundException e) {
            logger.error("something");
        } catch (IOException e) {
            logger.error("something 2");

        }
    }

    public static void serialize(Map<? extends Serializable,
            ? extends Serializable> map, String fileName) {

        try (FileOutputStream fos = new FileOutputStream(fileName);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(map);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deserialize(String fileName,
                                   HashMap<Order, Client> collection) {

        try (FileInputStream fis = new FileInputStream(fileName);
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            collection = (HashMap<Order, Client>) ois.readObject();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void deserialize(String fileName,
                                   List<Car> collection) {

        try (FileInputStream fis = new FileInputStream(fileName);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            Car serializable;
            while ((serializable = (Car) ois.readObject()) != null) {
                collection.add(serializable);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void deserialize(String fileName,
                                   Collection<Client> collection) {

        try (FileInputStream fis = new FileInputStream(fileName);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            Client serializable;
            while ((serializable = (Client) ois.readObject()) != null) {
                collection.add(serializable);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
