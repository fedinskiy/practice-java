package com.semakin;

import java.lang.reflect.Proxy;

public class Main {

    public static void main(String[] args) {
        Director director = new Director();
        IEmploye employProxy = (IEmploye) Proxy.newProxyInstance(Director.class.getClassLoader(),
                Director.class.getInterfaces(),
                new Invoker(director));

        employProxy.setName("Artem");
    }
}
