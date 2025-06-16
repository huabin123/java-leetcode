package com.huabin.acm;

import java.util.*;
import java.io.*;

/**
 * @Author huabin
 * @DateTime 2025-03-03 15:40
 * @Desc
 */
public class Problem11 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) { // 持续读取直到输入结束
            int n = Integer.parseInt(line);
            Map<Integer, Integer> parentMap = new HashMap<>();

            for (int i = 0; i < n; i++) {
                String[] pair = br.readLine().split(" ");
                int child = Integer.parseInt(pair[0]);
                int parent = Integer.parseInt(pair[1]);
                parentMap.put(child, parent);
            }

            List<Integer> path1 = getPath(1, parentMap);
            List<Integer> path2 = getPath(2, parentMap);

            int lca = findLCA(path1, path2);

            // 获取LCA在各自路径中的索引位置
            int index1 = path1.indexOf(lca);
            int index2 = path2.indexOf(lca);

            // 计算从LCA到当前节点的步数（路径长度之差）
            int steps1 = path1.size() - 1 - index1;
            int steps2 = path2.size() - 1 - index2;

            if (steps1 < steps2) {
                System.out.println("You are my younger");
            } else if (steps1 > steps2) {
                System.out.println("You are my elder");
            } else {
                System.out.println("You are my brother");
            }
        }
    }

    private static List<Integer> getPath(int node, Map<Integer, Integer> parentMap) {
        List<Integer> path = new ArrayList<>();
        while (parentMap.containsKey(node)) {
            path.add(node);
            node = parentMap.get(node);
        }
        path.add(node); // 加入根节点
        Collections.reverse(path); // 反转后路径为根→节点
        return path;
    }

    private static int findLCA(List<Integer> path1, List<Integer> path2) {
        int minLen = Math.min(path1.size(), path2.size());
        for (int i = 0; i < minLen; i++) {
            if (!path1.get(i).equals(path2.get(i))) {
                return i == 0 ? path1.get(0) : path1.get(i - 1); // 处理根节点不同的情况
            }
        }
        return path1.get(minLen - 1); // 完全包含时的公共祖先
    }
}


//class Problem11 {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while (in.hasNext()) {
//            int N = in.nextInt();
//            int[] arr = new int[30];
//            while (N-- > 0) {
//                int a = in.nextInt();
//                int b = in.nextInt();
//                arr[a] = b;
//            }
//            int deep1 = 0;
//            int deep2 = 0;
//            int f1 = 1;
//            int f2 = 2;
//            while (arr[f1] != 0) {
//                deep1++;
//                f1 = arr[f1];
//            }
//            while (arr[f2] != 0) {
//                deep2++;
//                f2 = arr[f2];
//            }
//            if (deep1 == deep2) {
//                System.out.println("You are my brother");
//            } else if (deep1 > deep2) {
//                System.out.println("You are my elder");
//            } else {
//                System.out.println("You are my younger");
//            }
//        }
//    }
//}
