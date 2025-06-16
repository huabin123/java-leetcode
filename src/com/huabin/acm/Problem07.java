package com.huabin.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author huabin
 * @DateTime 2025-03-03 11:08
 * @Desc
 */
public class Problem07 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) continue;
            int n = Integer.parseInt(line);
            if (n == 0) break;

            String[] parts = br.readLine().trim().split("\\s+");
            int sum = 0;
            for (String part : parts) {
                sum += Integer.parseInt(part);
            }
            int avg = sum / n;

            int moves = 0;
            for (String part : parts) {
                int h = Integer.parseInt(part);
                if (h > avg) {
                    moves += h - avg;
                }
            }

            System.out.println(moves);
            System.out.println(); // 每组输出后追加空行
        }
    }
}

/*
测试案例：
输入：
6
5 2 4 1 7 5
2
3 9
0

输出：
5

3

*/

