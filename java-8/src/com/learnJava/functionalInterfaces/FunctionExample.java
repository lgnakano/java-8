package com.learnJava.functionalInterfaces;

import java.util.function.Function;

public class FunctionExample {

    static Function<String,String> upperCase = String::toUpperCase;

    static Function<String,String> addSomeString =  (name) -> name.toUpperCase().concat(" default");

    static Function<String,Integer> strLength = String::length;




    public static void main(String[] args) {

        System.out.println("Result is : " + upperCase.apply("java8"));

        System.out.println("Result of andthen : " + upperCase.andThen(addSomeString).apply("java8"));

        System.out.println("Result of compose : " + upperCase.compose(addSomeString).apply("java8"));

        Function<String,String> abc = Function.identity();

        System.out.println(abc.apply("ABC"));

        System.out.println(strLength.apply(abc.apply("abc")));


    }
}
