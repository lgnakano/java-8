package com.learnJava.functionalInterfaces;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateStudentExample {

    static Predicate<Student> p1 = (s) -> s.getGradeLevel()>=3;

    static Predicate<Student> p2 = (s) -> s.getGpa()>=3.9;

    static Function<Integer,Predicate<Integer>> gradePredicate = (toCompare) -> (number) -> number > toCompare;
    static Function<Double,Predicate<Double>>  gpaPredicate = (toCompare) -> (number) -> number > toCompare;

    public static void filterStudentByGradeLevel() {
        System.out.println("filterStudentByGradeLevel");
        List<Student> studentList = StudentDataBase.getAllStudents();
        studentList.forEach((student) -> {
            if (p1.test(student)) {
                System.out.println(student);
            }
        });
    }

    public static void main(String[] args) {

        List<Student> studentList = StudentDataBase.getAllStudents();

        studentList.stream()
                .filter(PredicateStudentExample.p1)
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println();

        studentList.forEach((student -> {
            if(p1.test(student)){
                System.out.println(student);
            }
        }));

        System.out.println();

        studentList.forEach((student -> {
            if(p1.and(p2).test(student)){
                System.out.println(student);
            }
        }));

        System.out.println();

        boolean result = gradePredicate.apply(2).test(5) && gpaPredicate.apply(3.6).test(3.9);
        System.out.println("Result from Predicate : " + result);

        studentList.forEach((student -> {
            if (gradePredicate.apply(student.getGradeLevel()).test(4)) {
                System.out.println(student);
            }
        }));

        System.out.println();

        filterStudentByGradeLevel();

    }
}
