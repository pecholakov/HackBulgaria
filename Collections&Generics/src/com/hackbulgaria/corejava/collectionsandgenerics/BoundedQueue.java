package com.hackbulgaria.corejava.collectionsandgenerics;

import java.util.LinkedList;

public class BoundedQueue <T> extends LinkedList<T>{
    
    private static final long serialVersionUID = 1L;
    private int limit;
    
    public BoundedQueue(int limit) {
        this.limit = limit;
    }
    
    @Override
    public boolean offer (T elem){
        if (elem == null){
            return false;
        }
        if (this.size() == limit){
            this.removeFirst();
        }
        this.add(elem);
        return true;
    }
   
}
