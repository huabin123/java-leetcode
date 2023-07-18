package com.huabin.java;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 线程安全的并发因数分解
 */
public class FactorizationExample {
    public static void main(String[] args) {
        long number = 1234567890L; // 要分解的数

        List<Long> factors = factorize(number);
        System.out.println("因数分解结果：" + factors);
    }

    private static List<Long> factorize(long number) {
        List<Long> factors = new CopyOnWriteArrayList<>();

        // 创建线程数组
        Thread[] threads = new Thread[10];
        FactorizationWorker[] workers = new FactorizationWorker[10];

        // 每个线程分解一部分因数
        for (int i = 0; i < 10; i++) {
            long start = i * (number / 10) + 1;
            long end = (i + 1) * (number / 10);

            workers[i] = new FactorizationWorker(start, end, number, factors);
            threads[i] = new Thread(workers[i]);
            threads[i].start();
        }

        // 等待所有线程完成
        try {
            for (int i = 0; i < 10; i++) {
                threads[i].join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 对结果进行排序
        Collections.sort(factors);

        return factors;
    }

    // 因数分解工作线程
    static class FactorizationWorker implements Runnable {
        private long start;
        private long end;
        private long number;
        private List<Long> factors;

        public FactorizationWorker(long start, long end, long number, List<Long> factors) {
            this.start = start;
            this.end = end;
            this.number = number;
            this.factors = factors;
        }

        @Override
        public void run() {
            for (long i = start; i <= end; i++) {
                if (number % i == 0) {
                    factors.add(i);
                }
            }
        }
    }
}
