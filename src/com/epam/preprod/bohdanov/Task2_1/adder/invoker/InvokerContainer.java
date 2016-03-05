package com.epam.preprod.bohdanov.Task2_1.adder.invoker;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Contains implementations {@link Invoker} with convert String to simple types
 */
public final class InvokerContainer {
    private static Map<Class<?>, Invoker> invokers;

    static {
        invokers = new HashMap<Class<?>, Invoker>();

        invokers.put(Integer.class, new Invoker() {
            @Override
            public void call(Method method, Object target, String value) throws NumberFormatException,
                    IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                method.invoke(target, Integer.valueOf(value));
            }
        });

        invokers.put(Long.class, new Invoker() {
            @Override
            public void call(Method method, Object target, String value) throws NumberFormatException,
                    IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                method.invoke(target, Long.valueOf(value));
            }
        });

        invokers.put(String.class, new Invoker() {
            @Override
            public void call(Method method, Object target, String value)
                    throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                method.invoke(target, value);
            }
        });

        invokers.put(Boolean.class, new Invoker() {
            @Override
            public void call(Method method, Object target, String value)
                    throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                method.invoke(target, Boolean.valueOf(value));
            }
        });
    }

    public static Invoker getInvoker(Class<?> key) {
        return invokers.get(key);
    }
}
