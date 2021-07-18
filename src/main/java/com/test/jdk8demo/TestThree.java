package com.test.jdk8demo;

/**
 * @Description
 * @Author xuzhiqiang
 * @Date Created in 2021/2/8 21:45
 * @QQ 975945156
 */

public class TestThree {
    final static String salutation = "Hello";


    public static void main(String[] args) {
        GreetingService greetingService = message ->
                System.out.println(salutation + message);
        greetingService.sayMessage("Boy");

    }

    interface GreetingService {
        void sayMessage(String message);
    }
}
