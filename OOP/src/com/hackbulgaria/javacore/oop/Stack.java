package com.hackbulgaria.javacore.oop;

public interface Stack<T> {

    boolean isEmpty();

    T peek();

    T pop();

    void push(T element);
    
    int length();

}
