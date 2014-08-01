package com.hackbulgaria.corejava.generics2;

import java.util.ArrayList;
import java.util.List;

public class Favourites {

    List<Object> favourites;

    public Favourites() {
        favourites = new ArrayList<>();
    }

    public <T> void add(Class<T> type, T value) {
        T elem = type.cast(value);
        favourites.add(elem);
    }

    public <T> List<T> get(Class<T> type) {
        List<T> out = new ArrayList<T>();
        for (Object favourite : favourites){
            if (favourite.getClass().equals(type)){
                out.add(type.cast(favourite));
            }
        }
        return out;
    }
}
