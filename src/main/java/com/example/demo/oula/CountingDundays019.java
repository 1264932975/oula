package com.example.demo.oula;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CountingDundays019 {
    public static void main(String[] args) {
        System.out.println(ol19());

    }

    public static String ol19() {
        Date st = new Date();
        int count = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date begin = null;
        Date end = null;
        try {
            begin = sdf.parse("1901-1-1");
            end = sdf.parse("2000-12-1");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(begin);
        while (calendar.getTime().getTime() <= end.getTime()) {
            if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)//循环每月的1号判断是否是周一
                count++;
            calendar.add(Calendar.MONTH, 1);
        }
        Date en = new Date();
        return String.format("共用时 %d ms\n答案为：%s", en.getTime() - st.getTime(), count);
    }
}
