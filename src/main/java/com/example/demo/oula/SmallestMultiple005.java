package com.example.demo.oula;

import java.util.Date;

public class SmallestMultiple005 {


    public static void main(String[] args) {
        System.out.println(smallestMultiple());
    }

    public static String smallestMultiple() {

        Date st = new Date();
        int temp = 0;
        int x = 0;
        do {
            temp += 380;
            for (int i = 20; i > 0; i--) {
                if (temp % i != 0) {
                    x = 0;
                    break;
                } else {
                    x++;
                }
            }
        } while (x != 20);

        Date end = new Date();
        return String.format("共用时 %d ms\n答案为：%s", end.getTime() - st.getTime(), temp);
    }
}
