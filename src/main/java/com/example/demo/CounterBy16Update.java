package com.example.demo;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CounterBy16Update {
    public static void main(String[] args) {
        runMain();

    }


    public static void runMain() {
        try {
            Stack<String> st = doubleStack();
            System.out.println("计算结果为" + encodeHEX(PolandNotation(st)));
        } catch (Exception e) {
            System.err.println("或因输入异常导致的错误原因：" + e + "\n请检查算式是否正确\n若遇到技术原因请联系开发人员： 13161918916");
        }
    }

    //中缀转后缀
    public static Stack<String> doubleStack() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("欢迎使用------当前仅支持16进制算式计算  \n支持算数运算（+-*/)和逻辑运算 &|^（ps：逻辑运算为二进制处理结果 如2^3=1）");
        System.out.println("请输入算式，例如：(2+2*(1+2)^2)*3/2 ：");
//        StringBuffer stringBuffer = new StringBuffer("2f+3e*(7d-A)+8/4===");
        StringBuffer stringBuffer = new StringBuffer(scanner.next() + "=");


        int a = 0, b = 0;
        Stack<String> st1 = new Stack<>();//结果栈
        Stack<String> st2 = new Stack<>();//符号栈
        for (int i = 0; i < stringBuffer.length(); i++) {
            if (stringBuffer.charAt(i) == '=' ||
                    stringBuffer.charAt(i) == '+' || stringBuffer.charAt(i) == '%' ||
                    stringBuffer.charAt(i) == '-' || stringBuffer.charAt(i) == '*' ||
                    stringBuffer.charAt(i) == '/' || stringBuffer.charAt(i) == '(' ||
                    stringBuffer.charAt(i) == ')' || stringBuffer.charAt(i) == '&' ||
                    stringBuffer.charAt(i) == '|' || stringBuffer.charAt(i) == '^'
            ) {
                b = i;
                //数字入栈
                if (b - 1 == a) {
                    char temp = stringBuffer.charAt(a);
                    if (temp != '\0') {
                        st1.push(decodeHEX(String.valueOf(temp)));
                    }
                } else {
                    String temp = stringBuffer.substring(a, b);
                    if (!temp.isEmpty()) {
                        st1.push(decodeHEX(temp));
                    }
                }

                //操作符入栈
                String op = String.valueOf(stringBuffer.charAt(i));
                if ("=".equals(op) && "=".equals(st2.peek())) {
                    break;
                } else if (st2.isEmpty() || "(".equals(st2.peek()) || "(".equals(op) || comparePri(op, st2.peek())) {
                    st2.push(op);
                } else if (")".equals(op)) {
                    while (!"(".equals(st2.peek())) {
                        st1.push(st2.pop());
                    }
                    if ("(".equals(st2.peek())) {
                        st2.pop();
                    }

                } else {

                    while (!(st2.isEmpty() || "(".equals(st2.peek()) || "(".equals(op) || comparePri(op, st2.peek()))) {
                        st1.push(st2.pop());
                    }
                    st2.push(op);

                }


                a = b + 1;
            }
        }
        System.out.println("您的输入为：" + stringBuffer);
        System.out.println("转换后的后缀表达式为：" + st1);
//        System.out.println(st1.get(2) + "---" + st1.size());
        return st1;

    }


    //逆波兰式计算
    public static int PolandNotation(Stack<String> st) {


        Stack<String> stack = new Stack<>();
        //遍历list
        for (String itme : st) {
            //使用正则表达式取出
            if (itme.matches("\\d+")) {//匹配的是多位数
                stack.push(itme);
            } else {
                //pop出两个数进行运算
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if (itme.equals("+")) {
                    res = num1 + num2;
                } else if (itme.equals("-")) {
                    res = num1 - num2;
                } else if (itme.equals("*")) {
                    res = num1 * num2;
                } else if (itme.equals("/")) {
                    res = num1 / num2;
                } else if (itme.equals("|")) {
                    res = num1 | num2;
                } else if (itme.equals("&")) {
                    res = num1 & num2;
                } else if (itme.equals("^")) {
                    res = num1 ^ num2;
                } else if (itme.equals("%")) {
                    res = num1 % num2;
                } else {
                    throw new RuntimeException("运算符错误");
                }
                stack.push(String.valueOf(res));
            }
        }

        return Integer.parseInt(stack.pop());

    }


    private static Pattern p1 = Pattern.compile("(^[0-9]{1,9}[.][0-9]{1,2}$)|(^[0-9]{1,11}$)");

    private static String encodeHEX(Integer numb) {


        String hex = Integer.toHexString(numb);

        return hex;


    }


    private static String decodeHEX(String hexs) {

        BigInteger bigint = new BigInteger(hexs, 16);

        return bigint.toString();

    }


    private static boolean comparePri(String symbol, String top) {
        if ("(".equals(top)) {
            return true;
        }
        // 比较优先级
        switch (symbol) {
            case "(": // 优先级最高
                return true;


            case "*":
            case "%":
            case "/": {
                if ("+".equals(top) || "-".equals(top)) // 优先级比+和-高
                    return true;
                else
                    return false;
            }
            case "^": {
                if ("*".equals(top) || "/".equals(top)|| "%".equals(top)) //优先级比* /高
                    return true;
                else
                    return false;
            }
            case "+":
            case "-": {
                if ("&".equals(top) || "|".equals(top) || "^".equals(top))
                    return true;
                else
                    return false;
            }
            case "&":
            case "|":
            case "/^":
            case ")": // 优先级最低
            case "=": // 结束符
                return false;
            default:
                break;
        }
        return true;
    }

    private static boolean isNumber(String num) {
        Matcher m1 = p1.matcher("123");
        return m1.matches();
    }

}
