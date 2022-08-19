package com.example.demo.oula;

import javax.xml.crypto.Data;
import java.util.Date;

public class St11Prime007 {
    public static void main(String[] args) {
        System.out.println(st11Prime007());

    }

    public static String st11Prime007() {
        Date st = new Date();
        int num = 6;
        int temp = 15;
        while (num != 10001) {
            temp += 2;//双数都能被2整除，一次跳过两个数
            boolean b = true;
            for (int i = 3; i*i <= temp ; i += 2) {
                if (temp / i != 0 && temp % i == 0) {//是否被整除
                    b = false;
                    break;
                }
            }
            if (b) {
                num++;
            }
        }
        Date end = new Date();
        return String.format("运行时间:%s ms\n答案：%s",
                end.getTime() - st.getTime(), temp);
    }
}
