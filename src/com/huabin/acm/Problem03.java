package com.huabin.acm;

import java.io.*;
import java.util.*;

/**
 * @Author huabin
 * @DateTime 2025-03-03 15:45
 * @Desc
 */
public class Problem03 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) { // 持续读取直到输入结束或遇到0 0
            StringTokenizer st = new StringTokenizer(line);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == 0 && b == 0) break;     // 终止条件
            System.out.println(a + b);
        }
    }
}
