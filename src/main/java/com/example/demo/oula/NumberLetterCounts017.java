package com.example.demo.oula;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class NumberLetterCounts017 {
    public static void main(String[] args) {
        System.out.println(ol17());
    }

    public static String ol17() {
        Date st = new Date();
        StringBuilder stringBuilder = new StringBuilder();
        Map<Integer, String> map = new HashMap<>();
        map.put(0, "");
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");
        map.put(5, "five");
        map.put(6, "six");
        map.put(7, "seven");
        map.put(8, "eight");
        map.put(9, "nine");
        map.put(10, "ten");
        map.put(11, "eleven");
        map.put(12, "twelve");
        map.put(13, "thirteen");
        map.put(14, "fourteen");
        map.put(15, "fifteen");
        map.put(16, "sixteen");
        map.put(17, "seventeen");
        map.put(18, "eighteen");
        map.put(19, "nineteen");
        map.put(20, "twenty");
        map.put(30, "thirty");
        map.put(40, "forty");
        map.put(50, "fifty");
        map.put(60, "sixty");
        map.put(70, "seventy");
        map.put(80, "eighty");
        map.put(90, "ninety");
        map.put(100, "hundred");
        map.put(1000, "onethousand");
        stringBuilder.append(map.get(1000));//加入1000
        for (int i = 1; i < 1000; i++) {//遍历除1000外的数
            boolean b = false;
            int temp = i;
            if (temp / 100 > 0) {//处理百位
                stringBuilder.append(map.get(temp / 100));
                stringBuilder.append(map.get(100));
                if (temp % 100 > 0) {
                    b = true;
                    temp = i % 100;
                }
            }
            if (temp / 1 > 0) {//处理1-99
                if (b) {
                    stringBuilder.append("and");
                }
                if (temp < 100) {


                    if (temp > 20) {
                        stringBuilder.append(map.get(temp / 10 * 10) + map.get(temp % 10));
                    } else {//20以下特殊处理
                        stringBuilder.append(map.get(temp));
                    }
                }
            }
        }
//        System.out.println(stringBuilder);
//        System.out.println(stringBuilder.length());
        Date end = new Date();
        return String.format("共用时 %d ms\n答案为：%s", end.getTime() - st.getTime(), stringBuilder.length());
    }
}
