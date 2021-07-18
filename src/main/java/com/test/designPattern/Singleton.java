package com.test.designPattern;

/**
 * @Description 双重校验锁实现对象单例
 * @Author xuzhiqiang
 * @Date Created in 2021/6/19 22:29
 * @QQ 975945156
 */

public class Singleton {

    private volatile static Singleton uniqueInstance;

    private Singleton() {
    }

    public static Singleton getUniqueInstance() {
        //先判断对象是否实例过，没有实例化过才进入加锁代码
        if (uniqueInstance == null) {
            //类对象加锁
            synchronized (Singleton.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Singleton();
                }
            }
        }
        return uniqueInstance;
    }

}
