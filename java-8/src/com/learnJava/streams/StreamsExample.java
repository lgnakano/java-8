package com.learnJava.streams;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamsExample {

    public static void main(String[] args) {

        Predicate<Student> gradePredicate = student -> student.getGradeLevel()>=3;
        Predicate<Student> gpaPredicate = student -> student.getGradeLevel()>=3.9;

/*
        List<String> names = Arrays.asList("adam","dan","jenny");
        names.stream();
        names.parallelStream();
        StudentDataBase.getAllStudents().stream();
        StudentDataBase.getAllStudents().parallelStream();
*/


        Map<String,List<String>> studentMap = StudentDataBase.getAllStudents().stream() //.parallelStream dont forger.
                .filter(gradePredicate)
                .peek((student) -> System.out.println("After 1st filter " + student ))
                .filter(gpaPredicate) // Stream<Student>
                .peek((student) -> System.out.println("After 2nd filter " + student ))
                .collect(Collectors.toMap(Student::getName ,Student::getActivities ));

        System.out.println("studentMap  : " + studentMap);

        List<String> studentActivities = StudentDataBase.getAllStudents().
                stream() // Stream<Student>
                .map(Student::getActivities) //<Stream<List<Activities>>
                .flatMap(List::stream) //<Stream<String>
                .distinct() // removes duplicates
                .collect(Collectors.toList()); //collects it to a list.

        System.out.println("Student activities: " + studentActivities );

        List<String> namesList = StudentDataBase.getAllStudents().
                stream() // Stream<Student>
                .peek((System.out::println))
                .map(Student::getName) //<Stream<List<Activities>>
                .peek(System.out::println)
                .distinct() // removes duplicates
                .collect(Collectors.toList()); //collects it to a list.

        System.out.println("namesList  : " + namesList);


    }
}
