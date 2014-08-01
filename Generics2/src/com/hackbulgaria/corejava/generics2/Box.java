package com.hackbulgaria.corejava.generics2;


public class Box<T> {
    T data;
    
    Box(){
        
    }
    
    Box(T data){
        this.data = data;
    }
    
    public void set(T data){
        this.data = data;
    }
    
    public T get(){
        return data;
    }
}
