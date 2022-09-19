package com.example.demo.oula;

import java.math.BigInteger;
import java.util.Date;

public class PowerDigitSum016 {
    public static void main(String[] args) {
        System.out.println(ol16());
    }

    public static String ol16() {
        Date st = new Date();
        BigInteger bigInteger = new BigInteger("2");
        for (int i = 1; i < 1000; i++) {
            bigInteger = bigInteger.multiply(new BigInteger("2"));
        }
        String str = bigInteger.toString();
        long sum=0;
        for (int i = 0; i < str.length(); i++) {
            int x = Integer.valueOf(str.substring(i, i + 1));
            sum+=x;
        }
        Date end = new Date();
        return String.format("共用时 %d ms\n答案为：%s", end.getTime() - st.getTime(), sum);
    }
}
