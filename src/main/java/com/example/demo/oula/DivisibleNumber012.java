package com.example.demo.oula;

import java.util.Date;

public class DivisibleNumber012 {
    public static void main(String[] args) {
        System.out.println(ol12());
    }

    public static String ol12() {
        Date st = new Date();
        int temp;
        int x = 0;
        int sum = 0;
        do {
            temp = 1;
            x++;
            sum += x;
            for (int i = 2; i < Math.sqrt(sum); i++) {
                if (sum % i == 0) {
                    temp += 2;
                }
            }
        } while (temp < 500);
        Date end = new Date();
        return String.format("运行时间:%s ms\n答案：%s",
                end.getTime() - st.getTime(), sum);
    }
}
