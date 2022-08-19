package com.example.demo.oula;

import java.util.Date;

public class LargestPalindromeProduct004 {

    public static void main(String[] args) {
        System.out.println(largestPalindromeProduct());
    }

    public static String largestPalindromeProduct() {
        Date st = new Date();
        int temp = 0;
        for (int i = 999; i > 0; i--) {
            for (int j = 999; j > 0; j--) {
                int f = i * j;
                if (f > temp) {
                    String e = String.valueOf(f);
                    String k = new StringBuffer(e).reverse().toString();
                    if (e.equals(k)) {
                        temp = f;
                    }
                }
            }
        }
        Date en = new Date();
        String str = String.format("共用时 %d ms\n答案为：%s", en.getTime() - st.getTime(), temp);
        return str;

    }
}
