package com.hackbulgaria.javacore.oop;

public class StackUniqueElements<T> extends StackImpl<T> {

    @Override
    public void push(T element) {
        if (top == capacity) {
            resizeStack(capacity * 2);
        }
        if (!this.elementAlreadyExist(element)) {
            stack[top++] = element;
        }
        else{
            System.out.println("This element is already in the stack!");
        }
    }

    private boolean elementAlreadyExist(T element) {
        for (int i = 0; i < stack.length; i++) {
            if (stack[i].equals(element)) {
                return true;
            }
        }
        return false;
    }
}
