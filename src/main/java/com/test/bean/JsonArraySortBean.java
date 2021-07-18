package com.test.bean;

import java.io.Serializable;

/**
 * @Description
 * @Author xuzhiqiang
 * @Date Created in 2021/4/8 21:08
 * @QQ 975945156
 */

public class JsonArraySortBean implements Serializable {
    private static final long serialVersionUID = -2629843757115811399L;

    private String riskTag;
    private String title;
    private String event;
    private String date;
    private String riskTagId;

    public String getRiskTag() {
        return riskTag;
    }

    public void setRiskTag(String riskTag) {
        this.riskTag = riskTag;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getRiskTagId() {
        return riskTagId;
    }

    public void setRiskTagId(String riskTagId) {
        this.riskTagId = riskTagId;
    }
}
