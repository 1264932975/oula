package com.example.demo.oula;

import java.math.BigInteger;

/**
 * ClassName: FibonacciDigThound25
 *
 * @author shield
 * @date 2022/10/27 下午7:34
 */
public class FibonacciDigThound25 {
    public static void main(String[] args) {
        System.out.println(ol25());
    }

    public static String ol25() {
        long st = System.currentTimeMillis();
        BigInteger a = new BigInteger("1");
        BigInteger b = new BigInteger("1");
        int num = 3;
        BigInteger temp;
        do {
            temp = a.add(b);
            a = b;
            b = temp;
            num++;
        }
        while (a.add(b).toString().length() < 1000);
        return String.format("运行时间:%s ms\n答案：%s",
                System.currentTimeMillis() - st, num);
    }
}
