package com.huabin.java;

/**
 * @Author huabin
 * @DateTime 2023-07-05 10:00
 * @Desc 两个线程之间的轮流打印
 */
public class AlternatePrintingExample {
    private static final Object lock = new Object();
    private static boolean printA = true;

    public static void main(String[] args) {
        Thread threadA = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                synchronized (lock) {
                    while (!printA) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("Thread A: a");
                    printA = false;
                    lock.notifyAll();
                }
            }
        });

        Thread threadB = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                synchronized (lock) {
                    while (printA) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("Thread B: b");
                    printA = true;
                    lock.notifyAll();
                }
            }
        });

        threadA.start();
        threadB.start();

        try {
            threadA.join();
            threadB.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
