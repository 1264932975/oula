package com.example.demo.oula;

import java.util.ArrayList;
import java.util.List;

public class NonAbundantSums23 {

    public static void main(String[] args) {
        System.out.println(ol23());
    }

    public static String ol23() {
        long st = System.currentTimeMillis();
        int max = 28124;
        int[] b = new int[max];//经过测试使用boolean比int慢
        int[] c = new int[max];
        for (int i = 2; i < max; i++) {//计算是否盈数并记录
            if (funByOl23(i) > i) b[i] = 1;
        }
        for (int i = 2; i < max; i++)//记录所有可被两个盈数相加的数
            for (int j = 2; j < max - i; j++)
                if (c[i + j] != 2)
                    c[i + j] = b[i] + b[j];
        int sum = 0;
        for (int i = 1; i < max; i++)
            if (c[i] != 2)
                sum += i;
        long end = System.currentTimeMillis();
        return String.format("运行时间:%s ms\n答案：%s",
                end - st, sum);
    }

    private static int funByOl23(int a) {
        int sum = 0;
        for (int i = 1; i < a / 2 + 1; i++) {
            if (a % i == 0)
                sum += i;
        }
        return sum;
    }
}
