package com.example.demo.other;

import java.util.HashMap;
import java.util.Map;

public class ChineseCapital {
    public static void main(String[] args) {
        System.out.println(chineseCapital("10010001"));
    }

    public static String chineseCapital(String num) {
        if (num.length() > 9)
            return "仅支持位数到亿";
        Map<Integer, String> mapNum = new HashMap<>();
        mapNum.put(0, "零");
        mapNum.put(1, "一");
        mapNum.put(2, "贰");
        mapNum.put(3, "叄");
        mapNum.put(4, "肆");
        mapNum.put(5, "伍");
        mapNum.put(6, "陆");
        mapNum.put(7, "柒");
        mapNum.put(8, "捌");
        mapNum.put(9, "玖");
        mapNum.put(-2, "拾");
        mapNum.put(-3, "佰");
        mapNum.put(-4, "仟");
        mapNum.put(-5, "万");
        mapNum.put(-6, "拾万");
        mapNum.put(-7, "佰万");
        mapNum.put(-8, "仟万");
        mapNum.put(-9, "亿");

        StringBuilder stringBuilder = new StringBuilder("");
        int l = num.length() - 1;
        boolean b = false;
        if (num.length() == 1) {
            stringBuilder = stringBuilder.append(mapNum.get(Integer.valueOf(num)));
            return stringBuilder.toString();
        }
        for (int i = 0; i < num.length(); i++) {
            String str = num.substring(i, i + 1);
            if (str.equals("0")) {
                b = true;
            }
            if (i == l) {
                if (!num.substring(i).equals("0")) {
                    if (b)
                        stringBuilder.append("零");
                    stringBuilder = stringBuilder.append(mapNum.get(Integer.valueOf(num.substring(i))));
                }
            } else {
                if (!str.equals("0")) {
                    if (b)
                        stringBuilder.append("零");
                    int dig = -(num.length() - i);
                    if (dig < -5 && dig > -8 && !"0".equals(num.substring(i + 1, i + 2))) {
                        stringBuilder.append(mapNum.get(Integer.valueOf(str))).append(mapNum.get(dig + 4));
                    } else {
                        stringBuilder.append(mapNum.get(Integer.valueOf(str))).append(mapNum.get(dig));
                    }
                    b = false;
                }
            }
        }
        return stringBuilder.toString();
    }
}
