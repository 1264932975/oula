package com.example.demo.oula;

public class SumEven_002 {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        int n = 4000000;
        int temp = 3;
        int sum = 2;
        while (temp < n) {
            a = b;
            b = temp;
            if (temp % 2 == 0)//是否2的倍数
                sum += temp;
            temp = a + b;
        }
        System.out.println(sum);
    }
}
