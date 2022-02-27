package com.learnJava.streams;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class StreamFlatMapExample {

    public static Map<String, Long> studentActivitiesWithCount() {

        return StudentDataBase.getAllStudents()
                .stream()
                .map(Student::getActivities) //Stream<List<String>>
                .flatMap(List::stream) //<Stream<String>
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())) ;
//        return studentActivities;

    }

    public static List<Map.Entry<String, Long>> studentActivitiesWithCountSorted() {
        return studentActivitiesWithCount()
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toList());
    }

    public static List<Map.Entry<String, Long>> studentActivitiesWithCountSortedByFreqDec() {
        return studentActivitiesWithCount()
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toList());
    }

    public static List<String> printStudentActivities() {

        return StudentDataBase.getAllStudents()
                .stream()
                .map(Student::getActivities) //Stream<List<String>>
                .flatMap(List::stream) //<Stream<String>
                .collect(toList());

    }

    public static List<String> printUniqueStudentActivities() {

        return StudentDataBase.getAllStudents()
                .stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct()
                .sorted()
                .collect(toList());

    }

    public static long getStudentActivitiesCount() {

        return StudentDataBase.getAllStudents()
                .stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct()
                .count();

    }

    public static void main(String[] args) {


        System.out.println("Student Activities : " + printStudentActivities());
        System.out.println("Unique Student Activities : " + printUniqueStudentActivities());
        System.out.println("Unique Student Activities Count: " + getStudentActivitiesCount());
        System.out.println("Student Activities with count: " + studentActivitiesWithCount());
        System.out.println("Student Activities with count, sorted: " + studentActivitiesWithCountSorted());
        System.out.println("Student Activities with count, sorted by decreasing frequency: " + studentActivitiesWithCountSortedByFreqDec());
    }

}
