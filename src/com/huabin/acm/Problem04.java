package com.huabin.acm;

import java.io.*;
import java.util.*;

/**
 * @Author huabin
 * @DateTime 2025-03-03 10:42
 * @Desc
 */
public class Problem04 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {  // 持续读取直到输入结束
            StringTokenizer st = new StringTokenizer(line);
            int N = Integer.parseInt(st.nextToken());
            if (N == 0) break;                      // 终止条件
            int sum = 0;
            for (int i = 0; i < N; i++) {
                sum += Integer.parseInt(st.nextToken());
            }
            System.out.println(sum);
        }
    }
}
