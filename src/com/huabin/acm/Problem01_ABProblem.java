package com.huabin.acm;

import java.io.*;
import java.util.*;

/**
 * @Author huabin
 * @DateTime 2025-03-03 08:44
 * @Desc 题目：A + B Problem
 */
public class Problem01_ABProblem {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(line);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            System.out.println(a + b);
        }
    }
}
