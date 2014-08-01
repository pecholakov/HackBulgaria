package com.hackbulgaria.javacore.oop;
import java.util.Arrays;

public class StackImpl<T> implements Stack<T> {
    
    protected int capacity;
    protected int top;
    protected Object[] stack;
    
    StackImpl() {
        top = 0;
        capacity = 2;
        stack = new Object[capacity];
    }   

    @Override
    public void push(T element) {
        if (top == capacity) {
            resizeStack(capacity * 2);
        }
        stack[top++] = element;
    }
    
    @Override
    public T pop() {
        if (4 * top < capacity) {
            resizeStack(capacity / 2);
        }
        T topElem = (T) stack[--top];
        stack[top] = null;
        return topElem;
    }
    
    @Override
    public T peek() {
        return (T) stack[--top];
    }
    
    @Override
    public boolean isEmpty() {
        return top == 0;
    }

    @Override
    public int length() {
        return top - 1;
    }
    
    protected void resizeStack(int new_capacity){
        capacity = new_capacity;
        stack = Arrays.copyOf(stack, capacity);
    }

}
