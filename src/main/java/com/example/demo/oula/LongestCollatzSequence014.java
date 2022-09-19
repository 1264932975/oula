package com.example.demo.oula;

import java.util.Date;

public class LongestCollatzSequence014 {
    public static void main(String[] args) {
        System.out.println(ol14());
    }

    public static String ol14() {
        Date st = new Date();
        int temp;
        int max = 0;
        int maxId = 0;
        for (int i = 1; i < 1000000; i++) {
            long j = i;
            temp = 0;
            while (j > 1) {
                if (j % 2 == 0) {
                    j = j / 2;
                } else {
                    j = j * 3 + 1;
                }
                temp++;
            }
            if (temp > max) {
                max = temp;
                maxId = i;
            }
        }
        Date end = new Date();
        return String.format("共用时 %d ms\n答案为：%s", end.getTime() - st.getTime(), maxId);
    }
}
