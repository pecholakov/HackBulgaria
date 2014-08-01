package com.hackbulgaria.javacore.oop;

public class Pair {
    private final Object first;
    private final Object second;

    public Pair(Object first, Object second) {
        this.first = first;
        this.second = second;
    }

    public Object getFirst() {
        return this.first;
    }

    public Object getSecond() {
        return this.second;
    }

    @Override
    public String toString() {
        return String.format("(%s, %s)", this.first.toString(), this.second.toString());
    }

    @Override
    public boolean equals(Object objToCompare){
        
        if(objToCompare instanceof Pair){
            if (this.getFirst().equals(((Pair) objToCompare).getFirst()) &&
                    this.getSecond().equals(((Pair) objToCompare).getSecond())){
                return true;
            }
        }
        return false;
    }
}

