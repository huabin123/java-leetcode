package com.huabin.acm;

import java.io.*;
import java.util.*;

/**
 * @Author huabin
 * @DateTime 2025-03-03 09:39
 * @Desc
 */
public class Problem02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {  // 持续读取直到输入结束
            int N = Integer.parseInt(line.trim()); // 解析当前组的行数
            for (int i = 0; i < N; i++) {
                String abLine = br.readLine();
                StringTokenizer st = new StringTokenizer(abLine);
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                System.out.println(a + b);
            }
        }
    }
}

