package com.test.seekDate;

import com.alibaba.fastjson.JSON;
import com.test.bean.SeekDate;
import org.apache.commons.lang.time.DateFormatUtils;
import org.junit.Test;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @Description
 * @Author xuzhiqiang
 * @Date Created in 2021/4/19 20:07
 * @QQ 975945156
 */

public class Demo {

    @Test
    public void test() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("D:\\javaDoc\\date.txt");

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
        StringBuilder stringBuilder = new StringBuilder();

        String line;

        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line);
        }

        String dataStr = JSON.parseObject(JSON.parseObject(stringBuilder.toString()).getString("data")).getString("Date List");

        List<SeekDate> seekDates = JSON.parseArray(dataStr, SeekDate.class);

        String dateSundayS1 = getFormatDate(seekDates.get(0).getDate(), "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd");
        Date dateSundayD1 = getDateFromString(dateSundayS1, "yyyy-MM-dd");
        String dateSaturdayS1 = getAnyDaysAgo(dateSundayS1, "yyyy-MM-dd", 6);
        Date dateSaturdayD1 = getDateFromString(dateSaturdayS1, "yyyy-MM-dd");

        String startS = "20210116";
        Date startD = getDateFromString(startS, "yyyyMMdd");
        String endS = "20210416";
        Date endD = getDateFromString(endS, "yyyyMMdd");

        if (endD.after(dateSundayD1) && endD.before(dateSaturdayD1)) {
            System.out.println("没有信息遗漏");
        }
    }

    public static String getAnyDaysAgo(String end, String toFormatStr, int daysAgo) {
        String start;
        try {
            Date dEnd = getDateFromString(end, toFormatStr);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(dEnd);
            calendar.add(Calendar.DATE, daysAgo);
            Date dStart = calendar.getTime();
            SimpleDateFormat sdf = new SimpleDateFormat(toFormatStr);
            start = sdf.format(dStart);
        } catch (Exception e) {
            return "";
        }
        return start;
    }

    public static Date getDateFromString(String dateStr, String toFormatStr) {
        try {
            SimpleDateFormat df = new SimpleDateFormat(toFormatStr);
            df.setLenient(false);// 强制匹配
            return df.parse(dateStr);
        } catch (Exception e) {
            return null;
        }
    }

    public static String getFormatDate(String dateStr, String fromFormatStr, String toFormatStr) {
        Date date = getDateFromString(dateStr, fromFormatStr);
        return getStringFromDate(date, toFormatStr);
    }

    public static String getStringFromDate(Date date, String formatStr) {
        try {
            return DateFormatUtils.format(date, formatStr);
        } catch (Exception e) {
            return "";
        }
    }

}
