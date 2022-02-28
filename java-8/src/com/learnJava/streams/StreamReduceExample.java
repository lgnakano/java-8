package com.learnJava.streams;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.toList;

public class StreamReduceExample {

    public static int performMultiplication(List<Integer> integerList){

        return integerList.stream()
                // 1
                // 3
                // 5
                // 7
                // a=1, b=1 (from stream) => result 1 is returned
                // a=1, b=3 (from stream) => result 3 is returned
                // a=3, b=5 (from stream) => result 15 is returned
                // a=15, b=7 (from stream) => result 105 is returned
                .reduce(1, (a,b) -> a*b);

    }

    public static Optional<Integer> performMultiplicationWithNoInitialValue(List<Integer> integerList){

        return integerList.stream()
                .reduce( (a,b) -> a*b); // performs multiplication for each element in the stream and returns a new result fo.
    }

    public static String combineStudentNames(){

        return StudentDataBase.getAllStudents().stream()
                .map(Student::getName)
                .distinct()
                .reduce("", String::concat);  // performs multiplication for each element in the stream.
    }

    public static Optional<Student> getHighestGradeStudent(){

        return StudentDataBase.getAllStudents()
                .stream()
                .reduce((s1,s2)->(s1.getGpa()>s2.getGpa()) ? s1 : s2);
    }




    public static void main(String[] args) {

        List<Integer> integerList = List.of(1,3,5,7);
        List<Integer> integerList1 = List.of();

        System.out.println("Result is : " + performMultiplication(integerList));
        Optional<Integer> result = performMultiplicationWithNoInitialValue(integerList);
        System.out.println(result.isPresent());

        if(result.isPresent()){
            System.out.println("Result is : " +result.get());
        }else{
            System.out.println("Result is : " +0);
        }

        System.out.println("Result is : " + performMultiplication(integerList1));
        Optional<Integer> result1 = performMultiplicationWithNoInitialValue(integerList1);

        System.out.println(result1.isPresent());
        if(result1.isPresent()){
            System.out.println("Result is : " +result1.get());
        }else{
            System.out.println("Result is : " +0);
        }


        System.out.println(combineStudentNames());
        System.out.println(getHighestGradeStudent().isPresent()?getHighestGradeStudent().get():null);
    }
}
