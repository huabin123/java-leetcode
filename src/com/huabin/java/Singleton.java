package com.huabin.java;

/**
 * @Author huabin
 * @DateTime 2023-07-05 10:50
 * @Desc 双重检查锁实现单例
 */
public class Singleton {
    // 不加volatile会有什么问题？重排序问题： 在实例化对象的过程中，创建对象的步骤可能会被重排序，导致先分配内存并赋值给instance，然后才进行实例初始化的步骤。这样，在其他线程访问到instance时，可能会得到一个尚未初始化完全的实例。
    // 可见性问题：在没有volatile修饰的情况下，线程之间对instance的写入和读取操作可能存在可见性问题。一个线程对instance的写入操作可能对其他线程不可见，从而导致其他线程无法获取到正确的实例。
    private volatile static Singleton instance;

    private Singleton() {
        // 私有构造函数
    }

    public static Singleton getInstance() {
        if (instance == null) { // 第一次检查，避免不必要的同步
            synchronized (Singleton.class) {
                if (instance == null) { // 第二次检查，确保只创建一个实例
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}

