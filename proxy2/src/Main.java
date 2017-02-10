import java.lang.reflect.Proxy;

/**
 * Created by fedinskiy on 10.02.17.
 */
public class Main {
    public static void main(String[] args) {
        Director director = new Director();
        IEmployee employProxy = (IEmployee) Proxy.newProxyInstance(Director.class.getClassLoader(),
                Director.class.getInterfaces(), new Invoker(director));

        employProxy.setName("");
    }
}
