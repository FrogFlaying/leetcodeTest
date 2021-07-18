package com.test.JsonArraySortDemo;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class JsonTest {

    @Test
    public  void test() {
        //----------------JsonObject创建的方法-----------------------------------------------------------
        //创建JsonObject第一种方法
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("UserName", "kobi");
        jsonObject.put("age", "34");
        jsonObject.put("workIn", "ALI");//此处的"ALI"也可以替换为一个json{"sex":"男","station":"徐州","hoobey":"coding"}
        // System.out.println("jsonObject1：" + jsonObject);//jsonObject1：{"UserName":"kobi","workIn":"ALI","age":"34"}
        //用Iterator迭代器遍历取值，建议用反射机制解析到封装好的对象中

        for (Map.Entry<String,Object> entry:jsonObject.entrySet()){
            System.out.println("key:"+entry.getKey());
            System.out.println("value:"+entry.getValue());
        }

        //创建JsonObject第二种方法
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("UserName", "ZHULI");
        hashMap.put("age", "30");
        hashMap.put("workIn", "ALI");
        // System.out.println("jsonObject2：" + JSONObject.fromObject(hashMap));//jsonObject2：{"UserName":"ZHULI","workIn":"ALI","age":"30"}


        //----------------JSONArray创建的方法-----------------------------------------------------------
        //一：遍历JsonArray
        String str = "[{name:'a',value:'aa'},{name:'b',value:'bb'},{name:'c',value:'cc'},{name:'d',value:'dd'}]";  // 一个未转化的字符串
        JSONArray json = JSONArray.parseArray(str); // 首先把字符串转成 JSONArray  对象
        if (json.size() > 0) {
            for (int i = 0; i < json.size(); i++) {
                JSONObject job = json.getJSONObject(i);  // 遍历 jsonarray 数组，把每一个对象转成 json 对象
                // System.out.println(job);//{"name":"a","value":"aa"}  {"name":"b","value":"bb"} {"name":"c","value":"cc"}.....
                //  System.out.println(job.get("name"));  // a b c d

            }
        }

        //创建JsonArray方法2
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("kobi");
        arrayList.add("34");
        arrayList.add("ALI");
        //System.out.println("jsonArray2：" + JSONArray.fromObject(arrayList));//jsonArray2：["kobi","34","ALI"]


    }

    @Test
    public void test0105() {
        /*
取出name4值过程步骤:  1.将以上字符串转成JSONArray对象  2.取出对象的第一项,JSONObject 3.取出name1的值JSONObject
                      4.然后取出name2的值JSONObject对象  5.取出name4的值value2
* */
        /*  记住":"前是键,符号后是值  大括号成对找  一层层拨开就清楚了*/
        String str = "[{name1:{name2:{name3:'value1',name4:'value2'}}},{}]";

        JSONArray jsonArray = JSONArray.parseArray(str);//  将结果转成JSONArray对象的形式

        JSONObject getJsonObj = jsonArray.getJSONObject(0);//获取json数组中的第一项

        JSONObject json = getJsonObj.getJSONObject("name1").getJSONObject("name2");//{"name4":"value2","name3":"value1"}
        Object value = json.get("name4");
        System.out.println(value);//value2
    }

    @Test
    public void test01051() {
        JSONObject json = new JSONObject();
        JSONArray jsonArray = new JSONArray();

        json.put("key", "value");//JSONObject对象中添加键值对
        jsonArray.add(json);//将JSONObject对象添加到Json数组中


        System.out.println(json);
        System.out.println(jsonArray);
    }

}