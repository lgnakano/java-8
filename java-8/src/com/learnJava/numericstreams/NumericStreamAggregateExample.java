package com.learnJava.numericstreams;

import com.learnJava.data.StudentDataBase;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class NumericStreamAggregateExample {

    public static void main(String[] args) {


        int sum = IntStream.rangeClosed(1,50).sum();
        System.out.println("Sum : "+ sum);

        OptionalInt max = IntStream.rangeClosed(1,50).max();
        System.out.println(max.isPresent());
        System.out.println(max.isPresent()?max.getAsInt():"list is empty");
        System.out.println(max.orElse(0));

        OptionalLong min = LongStream.rangeClosed(1,50).min();
        System.out.println(min.isPresent()?min.getAsLong():"list is empty");
        System.out.println(min.orElse(0));

        OptionalDouble avg = IntStream.rangeClosed(1,50).average();
        System.out.println(avg.isPresent()?avg.getAsDouble():"list is empty");
        System.out.println(avg.orElse(0));

    }
}
