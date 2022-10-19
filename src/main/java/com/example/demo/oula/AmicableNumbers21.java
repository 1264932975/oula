package com.example.demo.oula;

import java.util.HashMap;
import java.util.Map;


public class AmicableNumbers21 {
    public static void main(String[] args) {
        System.out.println(ol21());
    }

    /**
     * @return java.lang.String
     * @parameters []
     * @author shield
     * @date 2022/10/17 下午5:42
     * @name ol21
     */
    public static String ol21() {
        long st = System.currentTimeMillis();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i < 10000; i++) {//计算所有亲和数
            int temp = i / 2 + 1;
            int sum = 0;
            for (int j = 1; j < temp; j++) {
                if (i % j == 0) {
                    sum += j;
                }
            }
            map.put(i, sum);
        }
        int sum = 0;
        for (int integer : map.keySet()) {
            if (map.containsKey(map.get(integer))) {
                if (integer == map.get(map.get(integer)) && integer != map.get(integer)) {
                    sum += integer;//亲和数累加
                }
            }
        }
        long end = System.currentTimeMillis();
        return String.format("运行时间:%s ms\n答案：%s",
                end - st, sum);
    }
}
