package com.hackbulgaria.corejava.collectionsandgenerics;


public class Student {
    
    private String name;
    private int grade;
    
    public Student() {
        this.name = "";
        this.grade = 0;
    }
    
    public Student(String name, int grade){
        this.name = name;
        this.grade = grade;
    }
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    
    
}
