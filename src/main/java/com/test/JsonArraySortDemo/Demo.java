package com.test.JsonArraySortDemo;

import com.alibaba.fastjson.JSON;
import com.test.bean.Model;
import org.codehaus.stax2.ri.typed.StringBase64Decoder;
import org.junit.Test;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Demo {
    @Test
    public void test() throws IOException {

        FileInputStream fis = new FileInputStream("D:\\javaDoc\\sort.txt");

        BufferedReader br = new BufferedReader(new InputStreamReader(fis));

        StringBuilder sb = new StringBuilder();

        String line;

        while ((line = br.readLine()) != null) {
            sb.append(line);
        }

        String data = JSON.parseObject(sb.toString()).getString("data");

        List<Model> models = JSON.parseArray(data, Model.class);


        Map<String, List<Model>> listMap = models.stream().collect(Collectors.groupingBy(Model::getRiskTag));

        Map<String,Map<String,Long>> map = new HashMap<>();

        listMap.forEach((riskTag,list)->{
            Map<String, Long> collect = list.stream().collect(Collectors.groupingBy(Model::getEvent, Collectors.counting()));
            map.put(riskTag,collect);
        });

        models.forEach(model -> model.setSecondLevelCount(map.get(model.getRiskTag()).get(model.getEvent())));

        models.sort(Model::compareTo);

        System.out.println(JSON.toJSONString(models));
    }
}
