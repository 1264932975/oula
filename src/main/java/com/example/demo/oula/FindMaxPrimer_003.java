package com.example.demo.oula;

public class FindMaxPrimer_003 {//最大质因数
    public static void main(String[] args) {
        System.out.println(findMaxPrimer(600851475143L));
    }

    private static long findMaxPrimer(long  n)
    {
        if (n == 1)
            return 1;//排除非质数1
        else
        {
            for (int i = 2; i < n; i++)
                //实际能执行到作为出口的数字为2,3,5,7,13等质数
                // (ps:若能被4整除，必然能被2整除,则在i=2时已弹出，能被6整除，必然能被2和3整除,其余同理)
            {
                if (n%i == 0)
                    return findMaxPrimer(n / i);//对每一个短除后的因数再进行短除
            }
            return n;//递归出口
        }
    }

}
