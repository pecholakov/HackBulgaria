package com.hackbulgaria.corejava.collectionsandgenerics;

import java.util.Collection;
import java.util.Iterator;
import java.util.Stack;

public class Reverse <T> {

    public void reverseCollection(Collection <T> collection){
        Stack<T> stack = new Stack<T>();
        Iterator<T> iter = collection.iterator();
        while(iter.hasNext()){
            stack.add(iter.next());
        }
        collection.clear();
        while(!stack.empty()){
            collection.add(stack.pop());
        }
    }
}
