package com.learnJava.streams;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

public class CollectionsvsStreams {

    public static void main(String[] args) {

        ArrayList<String> names = new ArrayList<>();
        names.add("Adam");
        names.add("Jim");
        names.add("Jenny");

        System.out.println(names);

        Stream<String> namesStream = names.stream();

        namesStream.forEach(System.out::println);
//        namesStream.foreach(System.out::println); // already executed, cannot be used.
        //But the code below creates new streams at each execution.
        names.stream().forEach(System.out::println);

        names.stream().forEach(System.out::println);

        names.forEach(System.out::println);

        names.forEach(System.out::println);
    }
}
