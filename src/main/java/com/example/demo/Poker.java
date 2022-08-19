package com.example.demo;


import java.util.*;

public class Poker {

    private static final int CARDSNUM = 13;
    private static List<String> list = new ArrayList<>();
    private static String[][] people = new String[8][CARDSNUM];

//    一副纸牌有52张，4种花色，每种花色13张。
//     m / 13： =0: 红心，=1: 方块，=2: 梅花，=3: 黑桃
//  　　m % 13:  =0:2，=1:3，=2:4 ....  =8:10，=9:J，=10:Q，=11: K，=12:A
//    如：m=15  m/13=1,m%13=2   m 为方片4

    public static void main(String[] args) {
        init();
        genarate();
        show();
    }

    private static void show() {//展示
        for (int i = 0; i < 8; i++) {
            System.out.println("用户" + (i + 1) + "的牌：" + Arrays.toString(people[i]));
            HashSet<String> strings = new HashSet<>();
            for (String s : people[i]) {
                strings.add(s);
            }
            if (strings.size() == people[i].length) {
                System.out.println("用户" + (i + 1) + "用的是同一副牌--true");
            } else {
                System.out.println("用户" + (i + 1) + "用的不是同一副牌-fals");
            }
        }
    }

    private static void genarate() {//发牌
        int i = 0;
        for (int j = 0; j < CARDSNUM; j++) {
            for (int k = 0; k < 8; k++) {
                people[k][j] = list.get(i++);
            }
        }
    }

    private static void init() {//初始化list
        String[] flowers = {"方块", "梅花", "黑桃", "红心"};
        String[] pointers = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};

        //初始化扑克
        for (int i = 0; i < flowers.length; i++) {
            for (int j = 0; j < pointers.length; j++) {
//生成一张扑克对象
                String p = flowers[i] + pointers[j];
                list.add(p);
                list.add(p);
            }
        }
        Collections.shuffle(list);//洗牌

    }


}
