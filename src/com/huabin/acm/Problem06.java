package com.huabin.acm;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @Author huabin
 * @DateTime 2025-03-03 10:41
 * @Desc
 */
public class Problem06 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {        // 持续读取每个测试组
            int n = Integer.parseInt(line.trim());      // 当前测试组的数据行数
            for (int i = 0; i < n; i++) {
                String dataLine = br.readLine();
                StringTokenizer st = new StringTokenizer(dataLine);
                int m = Integer.parseInt(st.nextToken());

                int sum = 0;
                for (int j = 0; j < m; j++) {
                    sum += Integer.parseInt(st.nextToken());
                }

                System.out.println(sum);    // 输出当前行的和
                if (i == n - 1) {
                    break;
                }
                System.out.println();       // 强制追加空行
            }
        }
    }
}
