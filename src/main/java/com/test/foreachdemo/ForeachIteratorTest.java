package com.test.foreachdemo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Description
 * @Author xuzhiqiang
 * @Date Created in 2021/2/3 22:19
 * @QQ 975945156
 */

public class ForeachIteratorTest {

    public static void main(String[] args) {

        CartItem item1 = new CartItem("pg8", 1111.11, 10);
        CartItem item2 = new CartItem("pg8p", 2222, 15);
        CartItem item3 = new CartItem("pg11", 3333, 20);

        //筛选价格
        List list = new ArrayList<>();
        list.add(item1);
        list.add(item2);
        list.add(item3);

        List items = filter2(list);

        System.out.println(items);
    }
    // 筛选售价在2000以上的手机方法1
    public static List filter1(List items){
        for (Object obj : items) {
            CartItem item = (CartItem) obj;
            if (item.getPrice()<2000){
                item.remove(item);
            }
        }
        return items;
    }
    // 筛选售价在2000以上的手机方法2
    public static List filter2(List items){
        for (Iterator it = items.iterator();it.hasNext(); ) {
            CartItem item= (CartItem) it.next();
            if (item.getPrice()<2000){
                it.remove();
            }
        }
        return items;
    }


    // 求出购买所有商品所需的总价格
    private static Double getTotalPrice(CartItem...items){
        double ret = 0.0;

        for  (CartItem item : items) {
            ret = ret + item.getPrice() * item.getNumber();
        }


        return ret;
    }
}
