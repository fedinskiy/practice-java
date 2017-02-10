package com.semakin;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Invoker implements java.lang.reflect.InvocationHandler{
    private Object obj;

    public Invoker (Object obj){
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //if(method.getName().equals("Some"))
        System.out.println("I invoke method " + method.getName());

        return method.invoke(obj, args);
    }
}
