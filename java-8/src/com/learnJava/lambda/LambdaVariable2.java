package com.learnJava.lambda;

import java.util.function.Consumer;

public class LambdaVariable2 {

    static int value = 4;
    int value2 = 2;

    public static void main(String[] args) {


        // int value =4; //effectively final
        Consumer<Integer> c1 = (a) -> {
            value=6;
            System.out.println(a+value);
//            value2 ++;
        };
        value =2;
//        value2++;

        c1.accept(2);
    }
}
