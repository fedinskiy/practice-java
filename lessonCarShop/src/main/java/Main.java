import CarShop.CarNotFoundException;
import CarShop.Store;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

/**
 * Created by sa on 08.02.17.
 */
public class Main {
    public static final Logger logger = Logger.getLogger(Main.class);

    static {
        DOMConfigurator.configure("src/main/resources/log4j.xml");
    }

    public static void main(String[] args) throws CarNotFoundException {
        Store store = new Store();
        logger.trace("I have Created store");
        store.createCar(500000, "kia-rio",
                "B146AA");

       /* store.sellCar("kia-reva",
                "Jhon",
                "Konner" ,
                "+79126241898");
*/
        store.save();
    }
}
