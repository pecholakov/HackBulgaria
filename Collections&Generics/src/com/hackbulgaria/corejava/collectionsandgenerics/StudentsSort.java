package com.hackbulgaria.corejava.collectionsandgenerics;

import java.util.List;

public class StudentsSort {

    public static void sort(List<Student> students) {
        sortByGrade(students);
        sortByName(students);
    }

    private static void sortByGrade(List<Student> students) {
        for (int i = 0; i < students.size() - 1; i++) {
            for (int j = i + 1; j < students.size(); j++) {
                if (students.get(i).getGrade() > students.get(j).getGrade()) {
                    Student temp = students.get(i);
                    students.set(i, students.get(j));
                    students.set(j, temp);
                }
            }
        }
    }

    private static void sortByName(List<Student> students) {
        for (int i = 0; i < students.size() - 1; i++) {
            for (int j = i + 1; j < students.size(); j++) {
                String currentStudent = students.get(i).getName();
                String nextStudent = students.get(j).getName();
                if (students.get(i).getGrade() == students.get(j).getGrade()) {
                    if (currentStudent.compareTo(nextStudent) > 0) {
                        Student temp = students.get(i);
                        students.set(i, students.get(j));
                        students.set(j, temp);
                    }

                }
            }
        }
    }
}
