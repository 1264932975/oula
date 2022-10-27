package com.example.demo.oula;

import org.springframework.util.StringUtils;

import java.io.*;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName: NamesScore22
 *
 * @author shield
 * @date 2022/10/19 上午10:57
 */
public class NamesScore22 {
    public static void main(String[] args) throws IOException {
        System.out.println(ol22());
    }

    public static String ol22() throws IOException {
        long st = System.currentTimeMillis();
        File file = new File("/home/shield/Desktop/name.txt");
        StringBuffer sBuffer = new StringBuffer();
        FileInputStream fileIo;
        try {
            fileIo = new FileInputStream(file);
            int n;
            do {
                n = fileIo.read();//读取文件的一个字节(8个二进制位),并将其由二进制转成十进制的整数返回
                char by = (char) n; //转成字符
                if (n != -1)
                    sBuffer.append(by);
            } while (n != -1);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        fileIo.close();
        int sum = 0;
        if (sBuffer.length() > 0) {
            String[] split = sBuffer.toString().replace("\"", "").split(",");
            Arrays.sort(split);
            for (int i = 0; i < split.length; i++) {
                char[] chars = split[i].toCharArray();
                int x = 0;
                for (char c : chars) {
                    if (c >= 'A' && c <= 'Z') {
                        x += c - 'A' + 1;
                    }
                }
                sum += x * (i + 1);
            }
        }
        long end = System.currentTimeMillis();

        return String.format("运行时间:%s ms\n答案：%s",
                end - st, sum);
    }
}
