package com.huabin.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author huabin
 * @DateTime 2025-03-03 13:59
 * @Desc
 */
public class Problem10 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while (true) {
            line = br.readLine().trim();
            if (line.isEmpty()) continue;
            String[] parts = line.split("\\s+");
            int M = Integer.parseInt(parts[0]);
            int K = Integer.parseInt(parts[1]);
            if (M == 0 && K == 0) break;

            int days = M;
            int current = M;
            while (true) {
                int add = current / K;
                if (add == 0) break;
                days += add;
                current = add + (current % K);
            }
            System.out.println(days);
        }
    }
}
