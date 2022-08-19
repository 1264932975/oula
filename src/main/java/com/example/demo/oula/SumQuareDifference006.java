package com.example.demo.oula;

import java.util.Date;

public class SumQuareDifference006 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        System.out.println(sumQuareDifference());
    }

    public static String sumQuareDifference() {
        Date st = new Date();
        Integer sumque = 0;
        Integer quesum = 0;
        for (int i = 1; i <= 100; i++) {
            sumque += i;
            quesum += (int) Math.pow(i, 2);
        }
        sumque = (int) Math.pow(sumque, 2);
        Date end = new Date();
        return String.format("运行时间:%s ms\n答案：\n平方和：%d\n和平方:%d\n差值:%d",
                end.getTime() - st.getTime(), sumque, quesum, quesum - sumque);
    }
}
