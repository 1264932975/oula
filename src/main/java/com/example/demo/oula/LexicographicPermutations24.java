package com.example.demo.oula;

/**
 * ClassName: LexicographicPermutations24
 *
 * @author shield
 * @date 2022/10/25 上午9:24
 */
public class LexicographicPermutations24 {
    public static void main(String[] args) {
        System.out.println(ol24());
    }


    public static String ol24() {
        long st = System.currentTimeMillis();
        int MAX = 1000000;
        int[] tempn = new int[9];//有多少种选择（多少的阶乘）
        int[] num = new int[10];//0-9
        int[] ans = new int[10];//存储数字
        int NUM = 1;
        num[0] = 0;
        for (int i = 1; i < 10; i++) {//初始化
            NUM *= i;
            tempn[i - 1] = NUM;
            num[i] = i;
        }
        int n;
        for (int i = 8; i >= 0; i--) {
            n = MAX / tempn[i];//当前位数的阶是否大于一百万,一百万位于9的阶乘*2,3之间,意味着首位是2,以此类推
            int k = 0;
            int m = 8 - i;
            while (n > 0) {
                n--;
                k++;
                while (num[k] == -1)//当前位已使用则向后取一位
                    k++;
            }
            ans[m] = num[k];//使用当前位
            num[k] = -1;//已使用标记
            MAX %= tempn[i];//取余数，减少一个阶乘值,如，第三位8！
        }
        for (int i = 0; i < 10; i++) {
            if (num[i] != -1) {
                ans[8] = num[i];//补足最后一位
                break;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int a : ans) {
            stringBuilder.append(a);
        }
        return String.format("运行时间:%s ms\n答案：%s",
                System.currentTimeMillis() - st, stringBuilder);
    }
}
