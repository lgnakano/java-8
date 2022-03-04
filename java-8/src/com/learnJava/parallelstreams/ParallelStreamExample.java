package com.learnJava.parallelstreams;

import java.util.function.Supplier;
import java.util.stream.IntStream;

public class ParallelStreamExample {

    public static long checkPerformanceResult(Supplier<Integer> sum , int numberOfTimes){

        long start = System.currentTimeMillis();
        for(int i=0;i<numberOfTimes;i++){
//            System.out.println(
                    sum.get()
//            )
            ;
        }

        long end = System.currentTimeMillis();
        return end-start;
    }

    public static int sum_sequential_stream(){

        return IntStream.rangeClosed(1,100000000)
                .sum();

    }

    public static int sum_parallel_stream(){

        return IntStream.rangeClosed(1,100000000)
                  .parallel() // splits the data in to multiple parts //775057
                    .sum();
    }

    public static void main(String[] args) {

        System.out.println(Runtime.getRuntime().availableProcessors());

        long sequentialDuration = checkPerformanceResult(ParallelStreamExample::sum_sequential_stream,100);
        System.out.println("sequentialDuration in MilliSeconds: " + sequentialDuration);
        //System.out.println("sequentialDuration in MilliSecs : " + TimeUnit.NANOSECONDS.toMillis(sequentialDuration));
        long parallelDuration =checkPerformanceResult(ParallelStreamExample::sum_parallel_stream,100);

        System.out.println("parallelDuration in MilliSeconds: " + parallelDuration);
      //  System.out.println("parallelDuration in MilliSecs : " + TimeUnit.NANOSECONDS.toMillis(parallelDuration));

    }
}
