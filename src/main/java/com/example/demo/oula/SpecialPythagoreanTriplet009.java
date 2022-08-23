package com.example.demo.oula;

import java.util.Date;

public class SpecialPythagoreanTriplet009 {
    public static void main(String[] args) {
        System.out.println(specialPythagoreanTriplet());
    }

    public static String specialPythagoreanTriplet() {
        Date st = new Date();
        int cout = 0, a = 0, b = 0, c;
        for (c = 3; c < 1000; c++) {
            for (b = 2; b < c && b<1000-c; b++) {
                for (a = 1; a < b ; a++) {
                    if ((a + b + c == 1000) && (a * a + b * b == c * c)) {
                        cout = a * b * c;
                        Date end = new Date();
                        return String.format("运行时间:%s ms\n答案：\na：%d\nb：%d\nc：%d\n乘积：%d",
                                end.getTime() - st.getTime(), a, b, c, cout);
                    }
                }
            }
        }
        return null;
    }
}

