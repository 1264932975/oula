package com.example.demo.oula;

import java.math.BigInteger;
import java.util.Date;

public class LatticePaths015 {
    private static final int ol15Max = 20;
    private static long[][] ol15Dp = new long[22][22];
    public static long runOl15(int n, int m) {
        long k = 0;
        if (ol15Dp[n][m] != 0) {//使用已有递归结果，避免冗余的递归步骤
            return ol15Dp[n][m];
        }
        if (m == ol15Max || n == ol15Max) {//初始化边界
            return ol15Dp[n][m] = 1;
        }
        if (n < ol15Max) {//横向移动
            k += runOl15(n + 1, m);
        }
        if (m < ol15Max) {//纵向移动
            k += runOl15(n, m + 1);
        }
        ol15Dp[n][m] = k;//存储已递归结果
        return k;
    }
    public static String ol15() {
        Date st = new Date();
        long num = runOl15(0, 0);
        Date end = new Date();
        return String.format("共用时 %d ms\n答案为：%s", end.getTime() - st.getTime(), num);
    }

    public static void main(String[] args) {
        System.out.println(ol15());
    }
}
