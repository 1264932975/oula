package com.example.demo.oula;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class MaximumPathSum018 {
    public static void main(String[] args) {
        System.out.println(ol18());
    }

    private static int max;

    public static String ol18() {
        Date st=new Date();
        int[][] num = initOl18();
        max = 0;
        sum(0, 0, 0, num);
        Date end=new Date();
        return String.format("共用时 %d ms\n答案为：%s", end.getTime() - st.getTime(), max);
    }

    private static void sum(int i, int j, int sum, int[][] num) {
        if (i == 15 || j == 15)
            return;
        sum += num[i][j];
        if (sum > max) {
            max = sum;
        }
        sum(i + 1, j, sum, num);
        sum(i + 1, j + 1, sum, num);
    }

    private static int[][] initOl18() {
        String str = "75 " +
                "95 64 " +
                "17 47 82 " +
                "18 35 87 10 " +
                "20 04 82 47 65 " +
                "19 01 23 75 03 34 " +
                "88 02 77 73 07 63 67 " +
                "99 65 04 28 06 16 70 92 " +
                "41 41 26 56 83 40 80 70 33 " +
                "41 48 72 33 47 32 37 16 94 29 " +
                "53 71 44 65 25 43 91 52 97 51 14 " +
                "70 11 33 28 77 73 17 78 39 68 17 57 " +
                "91 71 52 38 17 14 91 43 58 50 27 29 48 " +
                "63 66 04 68 89 53 67 30 73 16 69 87 40 31 " +
                "04 62 98 27 23 09 70 98 73 93 38 53 60 04 23";
        List<String> list = Arrays.asList(str.split(" "));
        int[][] num = new int[15][15];
        int temp = 0;
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j <= i; j++) {
                num[i][j] = Integer.valueOf(list.get(temp));
                temp++;
            }
        }
        return num;
    }

}
