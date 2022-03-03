package com.learnJava.streams_terminal;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

import java.util.stream.Collectors;

public class StreamsSumAvgExample {

    public static int sum(){

        return StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.summingInt(Student::getNoteBooks));
    }

    public static int sum2(){

        return StudentDataBase.getAllStudents()
                .stream()
                .mapToInt(Student::getNoteBooks)
                .sum();
    }
    public static double average(){

        return StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.averagingInt(Student::getNoteBooks));
    }


    public static void main(String[] args) {


        System.out.println("Total no of Notebooks : " + sum());

        System.out.println("Total no of Notebooks : " + sum2());

        System.out.println("Average no of Notebooks : " + average());
    }
}
