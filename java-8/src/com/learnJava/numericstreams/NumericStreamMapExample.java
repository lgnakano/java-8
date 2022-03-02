package com.learnJava.numericstreams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.reducing;
import static java.util.stream.Collectors.toList;

public class NumericStreamMapExample {


    public static List<Integer> mapToObj(){

        List<Integer> integerList = new ArrayList<>();
        //            Integer integer = i;
        for (int i = 1; i <= 5; i++)
            integerList.add(i);

        return integerList;

    }

    public static double mapToDouble(){

      return   IntStream.rangeClosed(1,5)
                .mapToDouble((i) ->  i)
                .sum();

    }

    public static long mapToLong(){

        return   IntStream.rangeClosed(1,5)
                .mapToLong((i) ->  i)
                .sum();

    }

    public static void main(String[] args) {

        System.out.println("mapToObj : " + mapToObj());

        System.out.println("mapToDouble() : " + mapToDouble());

        System.out.println("mapToLong() : " + mapToLong());

    }
}
