package com.test.bean;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;

@Data
public class Model implements Comparable<Model> {

    private String riskTag;
    private String event;
    @JSONField(deserialize = false)
    private String title;
    @JSONField(format = "yyyy-MM-dd")
    private Date date;
    @JSONField(serialize = false)
    private long secondLevelCount;


    @Override
    public int compareTo(Model o) {
        if (this.getFirstLevel() != o.getFirstLevel()) {
            // 第一层 根据riskTag升序
            return this.getFirstLevel()-o.getFirstLevel();
        }
        if (this.getSecondLevelCount() != o.getSecondLevelCount()) {
            // 第二层 根据数量倒叙
            return (int)(o.getSecondLevelCount() - this.getSecondLevelCount());
        }
        // 第三层
        return o.getDate().compareTo(this.getDate());
    }

    private int getFirstLevel() {
        switch (riskTag) {
            case "风险":
                return 1;
            case "警示":
                return 2;
            case "提示":
                return 3;
            case "利好":
                return 4;
        }
        return 0;
    }
}
