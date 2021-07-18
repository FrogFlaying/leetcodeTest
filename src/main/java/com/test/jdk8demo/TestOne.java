package com.test.jdk8demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Description Java8新特性lamda表达式
 * @Author xuzhiqiang
 * @Date Created in 2021/1/29 23:49
 * @QQ 975945156
 */

public class TestOne {
    public static void main(String args[]) {

        List<String> names1 = new ArrayList<String>();
        names1.add("Google");
        names1.add("Apple");
        names1.add("Orange");
        names1.add("Baidu");
        names1.add("Soh");

        List<String> names2 = new ArrayList<String>();
        names2.add("Google");
        names2.add("Apple");
        names2.add("Orange");
        names2.add("Baidu");
        names2.add("Soh");

        TestOne testOne = new TestOne();

        System.out.println("使用Java7语法");
        testOne.sortUsingJava7(names1);
        System.out.println(names1);

        System.out.println("使用Java8语法");
        testOne.sortUsingJava8(names2);
        System.out.println(names2);
    }


//7
    private void sortUsingJava7(List<String> names){
            Collections.sort(names, new Comparator<String>(){
                @Override
                public int compare(String s1,String s2){
                    return s1.compareTo(s2);
                }
            });
        }

//8
    private void sortUsingJava8(List<String> names) {
        Collections.sort(names, (s1,s2) -> s1.compareTo(s2));
    }
}
