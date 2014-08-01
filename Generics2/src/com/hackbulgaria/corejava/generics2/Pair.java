package com.hackbulgaria.corejava.generics2;

public class Pair<F, S> {
    F first;
    S second;

    Pair() {

    }

    Pair(F first, S second) {
        this.first = first;
        this.second = second;
    }

    public void setFirst(F first) {
        this.first = first;
    }

    public void setSecond(S second) {
        this.second = second;
    }

    public F first() {
        return first;
    }

    public S second() {
        return second;
    }

    @Override
    public String toString() {
        return "<" + first + ", " + second + ">";
    }
}
