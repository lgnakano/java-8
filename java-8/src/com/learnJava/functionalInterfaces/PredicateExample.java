package com.learnJava.functionalInterfaces;

import java.util.function.Predicate;

public class PredicateExample {

    static Predicate<Integer> p = (i) -> {return  i%2 ==0;};

    static Predicate<Integer> p1 = (i) -> i%2 ==0;

    static Predicate<Integer> p2 = (i) -> i%5 ==0;


    public static void predicateAnd(){

        System.out.println("Result in predicateAnd : " + p1.and(p2).test(10));
        System.out.println("Result in predicateAnd : " + p1.and(p2).test(9));
    }

    public static void predicateOr(){

        System.out.println("Result in predicateOr : " + p1.or(p2).test(15));
        System.out.println("Result in predicateOr : " + p1.or(p2).test(9));
    }

    public static void predicateNegate(){

        System.out.println("Result in predicateNegate : " + p1.and(p2).negate().test(10)); //equivalent to reversing the result
        System.out.println("Result in predicateNegate : " + p1.and(p2).negate().test(9)); //equivalent to reversing the result

    }


    public static void main(String[] args) {

        System.out.println("Result is p : " + p.test(2));

        System.out.println("Result is p1 : " + p1.test(3));

        predicateAnd();

        predicateOr();

        predicateNegate();

    }


}
