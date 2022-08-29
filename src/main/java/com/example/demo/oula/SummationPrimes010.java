package com.example.demo.oula;

import java.util.Date;

public class SummationPrimes010 {
    public static void main(String[] args) {
        System.out.println(summationPrimes010());
    }

    public static String summationPrimes010() {
        Date st = new Date();
        Long sum = 2l;
        for (int temp = 3; temp < 2000000; temp += 2) {
            int sqrt = (int) Math.sqrt(temp) + 1;
            for (int i = 3; i < sqrt; i += 2) {
                if (temp % i == 0) {//是否被整除
                    sqrt = 0;
                    break;
                }
            }
            if (sqrt>0) {
                sum += temp;
            }
        }
        Date end = new Date();
        return String.format("运行时间:%s ms\n答案：%s",
                end.getTime() - st.getTime(), sum);
    }


}
