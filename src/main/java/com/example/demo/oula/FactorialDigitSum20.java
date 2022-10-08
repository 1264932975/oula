package com.example.demo.oula;

import java.math.BigInteger;
import java.util.Date;

public class FactorialDigitSum20 {
    public static void main(String[] args) {
        System.out.println(ol20());
    }

    public static String ol20() {
        long st = System.currentTimeMillis();
        BigInteger bigInteger = new BigInteger("1");
        for (int i = 1; i <= 100; i++) {
            bigInteger = bigInteger.multiply(new BigInteger(String.valueOf(i)));
        }
        StringBuilder stringBuilder = new StringBuilder(bigInteger.toString());
        int sum = 0;
        for (int i = 0; i < stringBuilder.length(); i++) {
            sum += Integer.valueOf(stringBuilder.substring(i, i + 1));
        }
        long end = System.currentTimeMillis();
        return String.format("运行时间:%s ms\n答案：%s",
                end - st, sum);
    }
}
