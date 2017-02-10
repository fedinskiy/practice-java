import java.lang.reflect.Method;

/**
 * Created by fedinskiy on 10.02.17.
 */
public class Invoker implements java.lang.reflect.InvocationHandler{
    private Object obj;

    public Invoker(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("invoking method"+method.getName());
        return method.invoke(obj, args);
    }
}
