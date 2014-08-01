package com.hackbulgaria.corejava.generics2;

public class NewInstanceClazz {
    public static <T> T newInstance(Class<T> clazz) throws InstantiationException, IllegalAccessException {
        return clazz.newInstance();
    }
}
