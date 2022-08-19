package com.example.demo.oula;

public class SumeMultiples_001 {
    public static void main(String[] args) {
        System.out.println("小于1000的自然数中所有3或5的倍数之和：" + sumeMultiples());
    }
    private static Integer sumeMultiples() {
        Integer sum = 0;
        for (int i = 3; i <= 1000; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
            }
        }
        return sum;
    }
}
