package com.huabin.topk;

import com.huabin.common.ArrUtil;

import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class Q003_FindLargestNumbers {

    public static void main(String[] args) {
//        int[] nums = new int[100000000];
//        for (int i = 0; i < 100000000; i++) {
//            System.out.println(Math.random());
//            nums[i] = (int) (Math.random() * 100000000);
//        }
        int[] nums = ArrUtil.genRandomArr(100000000, 100000000);


//        int[] nums = IntStream.rangeClosed(1, 100000000).toArray();

        int K = 10000;

        int largestNum = findLargestNumber(nums);
        System.out.println("Largest number: " + largestNum);

        int kthLargest = findKthLargestNumber(nums, K);
        System.out.println("Kth largest number (K = " + K + "): " + kthLargest);

    }

    // ---- 解法一：使用java的优先级队列 -----
    private static int findLargestNumber(int[] numbers) {
        int max = Integer.MIN_VALUE;
        for (int num : numbers) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    private static int findKthLargestNumber(int[] numbers, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(K + 1);

        for (int num : numbers) {
            pq.offer(num);
            if (pq.size() > K) {
                pq.poll();
            }
        }

        return pq.peek();
    }

    // ---- 解法二：不使用类库 -----




}
