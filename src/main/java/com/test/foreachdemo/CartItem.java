package com.test.foreachdemo;

/**
 * @Description
 * @Author xuzhiqiang
 * @Date Created in 2021/2/3 22:21
 * @QQ 975945156
 */

public class CartItem {

    private static Integer number;

    private static Double price;

    private static Object name;

    public CartItem(String name, double price, int number) {

    }

    public Double getPrice() {
        CartItem.this.getPrice();
        return price;
    }


    public void setPrice(Double price){
        CartItem.price = price;
    }

    public void remove(CartItem item) {

    }

    public static Object getName() {
        return name;
    }

    public static void setName(Object name) {
        CartItem.name = name;
    }

    public static Integer getNumber() {
        return number;
    }

    public static void setNumber(Integer number) {
        CartItem.number = number;
    }

}
