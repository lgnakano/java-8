package com.learnJava.streams_terminal;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.*;

public class StreamsMappingExample {

    public static void main(String[] args) {

        Set<String> namesSet = StudentDataBase.getAllStudents()
                .stream()
                .collect(mapping(Student::getName,toSet())); // this avoids the additional map intermediate operation.

        System.out.println("namesSet : " + namesSet);

        Set<String> namesSet2 = StudentDataBase.getAllStudents()
                .stream()
                .map(Student::getName)
                .collect(toSet());

        System.out.println("namesSet : " + namesSet2);

        List<String> namesList = StudentDataBase.getAllStudents()
                .stream()
                .collect(mapping(Student::getName,toList())); // this avoids the additional map intermediate operation.

        System.out.println("namesList : " + namesList);

        List<String> namesList2 = StudentDataBase.getAllStudents()
                .stream()
                .map(Student::getName)
                .collect(toList()); // this avoids the additional map intermediate operation.

        System.out.println("namesList : " + namesList2);

    }

}
