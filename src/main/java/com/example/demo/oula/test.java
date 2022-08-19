package com.example.demo.oula;

import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("1");
        list.add("1");
        System.out.println(list.toString());
        list.remove(1);
        System.out.println(list.toString());


    }
}
