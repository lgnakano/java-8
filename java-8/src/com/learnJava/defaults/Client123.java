package com.learnJava.defaults;

public class Client123 implements Interface1,Interface2,Interface3 {

    public void methodA(){ //overriding the default method in the implementation class.
        System.out.println("Inside method A "+ Client123.class);
    }

    // 1 -> class that implements the interface
    // 2 -> the sub interface that extends the interface
    // 3 -> the pareent interface that was extended

    public static void main(String[] args) {

        Client123 client123 = new Client123();
        client123.methodA(); // resolves to child Interface Implementation
        client123.methodB();
        client123.methodC();


    }
}
