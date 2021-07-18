package com.test.JsonArraySortDemo;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.test.bean.JsonArraySortBean;
import org.apache.commons.lang.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @Description
 * @Author xuzhiqiang
 * @Date Created in 2021/4/8 19:49
 * @QQ 975945156
 */

public class JsonArraySortTest {

    @Test
    public void test() throws IOException {
        String path = "Test.json";

        ClassPathResource resource = new ClassPathResource(path);
        File file = resource.getFile();
        String jsonString = FileUtils.readFileToString(file, "utf-8");
        JSONObject jsonObject = JSONObject.parseObject(jsonString);

        JSONArray data = JSONArray.parseArray(String.valueOf(jsonObject.get("data")));


        List<JsonArraySortBean> jsonArraySortBeanList = new ArrayList<>();
        data.stream().forEach(a -> {
            JSONObject dataObject = (JSONObject) a;
            JsonArraySortBean jsonArraySortBean = new JsonArraySortBean();
            String riskTag = String.valueOf(dataObject.get("riskTag"));
            String riskTagId = null;
            if (riskTag.equals("风险")) {
                riskTagId = "1";
            } else if (riskTag.equals("警示")) {
                riskTagId = "2";
            }
            String event = String.valueOf(dataObject.get("event"));
            String date = String.valueOf(dataObject.get("date"));
            String title = String.valueOf(dataObject.get("title"));

            jsonArraySortBean.setRiskTag(riskTag);
            jsonArraySortBean.setEvent(event);
            jsonArraySortBean.setDate(date);
            jsonArraySortBean.setTitle(title);

            jsonArraySortBean.setRiskTagId(riskTagId);

            jsonArraySortBeanList.add(jsonArraySortBean);
        });

        JSONArray sortOnceArray = JSONObject.parseArray(JSONObject.toJSONString(jsonArraySortBeanList));
        sortOnceArray.sort(Comparator.comparing(obj -> ((JSONObject) obj).getBigDecimal("riskTagId")));

        //1.去掉sortOnceArray这个List中每个对象的“date”字段
        sortOnceArray.forEach(a -> {
            JSONObject object = (JSONObject) a;
            object.remove("date");
        });

        //2.将sortOnceArray这个List中的对象直接放进json中
        String s = JSONObject.toJSONString(sortOnceArray);
        String strip = "{" + StringUtils.strip(s, "[]") + "}";

        JSONObject resultJson = JSONObject.parseObject(strip);

        System.out.println(resultJson);
    }
}
