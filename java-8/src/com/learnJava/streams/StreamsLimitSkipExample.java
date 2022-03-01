package com.learnJava.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamsLimitSkipExample {

    public static Optional<Integer> limit(List<Integer> integers){
        return  integers.stream()
                .peek(System.out::println)
                .limit(2)
                .peek(System.out::println)
                .reduce(Integer::sum);

    }

    public static Optional<Integer> skip(List<Integer> integers){
        return  integers.stream()
                .peek(System.out::println)
                .skip(3)
                .peek(System.out::println)
                .reduce(Integer::sum);
    }
    

    public static void main(String[] args) {

        List<Integer> integers = Arrays.asList(6,7,8,9,10);

        Optional<Integer> limitResult = limit(integers);
        int result = limitResult.orElse(0);
        System.out.println("The limit result is : " + result);

        Optional<Integer> skipResult = skip(integers);
        int result1 = skipResult.orElse(0);
        System.out.println("The skip result is : " + result1);

    }
}
