package com.hackbulgaria.javacore.oop;

public class Main {

    public static void main(String[] args) {
        StackImpl<String> moi = new StackImpl<>();
        moi.push("a");
        moi.push("b");
        moi.push("c");
        
        int len = moi.length();
        for (int i = 0; i <= len; i++) {
            System.out.println(moi.pop());
        }
        
       
//        while (!moi.isEmpty()){
//            System.out.println(moi.pop());
//        }
    }

}
