package com.test.jdk8demo;

/**
 * @Description
 * 使用 Lambda 表达式需要注意以下两点：
 *     Lambda 表达式主要用来定义行内执行的方法类型接口，例如，一个简单方法接口。在上面例子中，我们使用各种类型的Lambda表达式来定义MathOperation接口的方法。然后我们定义了sayMessage的执行。
 *     Lambda 表达式免去了使用匿名方法的麻烦，并且给予Java简单但是强大的函数化的编程能力。
 * @Author xuzhiqiang
 * @Date Created in 2021/1/30 15:17
 * @QQ 975945156
 */

public class TestTwo {
    public static void main(String[] args) {
        TestTwo testTwo = new TestTwo();

        //类型声明
        MathOperation addition= (int a,int b) -> a+b;

        //不用类型声明
        MathOperation substraction = (a,b)->a-b;

        //大括号中的返回语句
        MathOperation multiplication = (int a,int b) -> {return a*b;};
//        MathOperation multiplication = (int a,int b) ->a*b;

        //没有大括号及返回语句
        MathOperation division = (int a,int b) -> a/b;

        System.out.println("10+5=:"+testTwo.operate(10,5,addition));
        System.out.println("10-5=:"+testTwo.operate(10,5,substraction));
        System.out.println("10×5=:"+testTwo.operate(10,5,multiplication));
        System.out.println("10÷5=:"+testTwo.operate(10,5,division));

        //不用括号
        GreetingService greetingService1 = message -> System.out.println("Hello"+message);

        //用括号
        GreetingService greetingService2 = (message) -> System.out.println("Hello"+message);

        greetingService1.sayMessage("Runoob");
        greetingService2.sayMessage("Google");

    }

    interface MathOperation {
        int operation(int a ,int b );
    }

    interface GreetingService{
        void sayMessage(String message);
    }

    private int operate(int a, int b,MathOperation mathOperation){
        return mathOperation.operation(a, b);
    }
}
