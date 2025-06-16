package com.huabin.common;

import java.util.Random;

/**
 * @Author huabin
 * @DateTime 2025-02-28 15:54
 * @Desc 跳表
 */
class SkipNode {
    int val;
    SkipNode[] forward; // 多层指针数组

    public SkipNode(int val, int level) {
        this.val = val;
        this.forward = new SkipNode[level];
    }
}

public class SkipList {
    private static final int MAX_LEVEL = 16;   // 最大层数
    private int level = 1;                     // 当前有效层数
    private SkipNode head = new SkipNode(-1, MAX_LEVEL); // 头节点
    private Random rand = new Random();

    // 随机生成节点层数（概率50%逐层递减）
    private int randomLevel() {
        int lvl = 1;
        while (lvl < MAX_LEVEL && rand.nextDouble() < 0.5) {
            lvl++;
        }
        return lvl;
    }

    // 查找元素是否存在
    public boolean search(int target) {
        SkipNode curr = head;
        for (int i = level - 1; i >= 0; i--) {
            while (curr.forward[i] != null && curr.forward[i].val < target) {
                curr = curr.forward[i];
            }
        }
        curr = curr.forward[0];
        return curr != null && curr.val == target;
    }

    // 插入元素
    public void add(int num) {
        SkipNode[] update = new SkipNode[MAX_LEVEL];
        SkipNode curr = head;
        for (int i = level - 1; i >= 0; i--) {
            while (curr.forward[i] != null && curr.forward[i].val < num) {
                curr = curr.forward[i];
            }
            update[i] = curr;
        }

        int newLevel = randomLevel();
        if (newLevel > level) {
            for (int i = level; i < newLevel; i++) {
                update[i] = head;
            }
            level = newLevel;
        }

        SkipNode newNode = new SkipNode(num, newLevel);
        for (int i = 0; i < newLevel; i++) {
            newNode.forward[i] = update[i].forward[i];
            update[i].forward[i] = newNode;
        }
    }

    // 删除元素
    public boolean erase(int num) {
        SkipNode[] update = new SkipNode[MAX_LEVEL];
        SkipNode curr = head;
        for (int i = level - 1; i >= 0; i--) {
            while (curr.forward[i] != null && curr.forward[i].val < num) {
                curr = curr.forward[i];
            }
            update[i] = curr;
        }
        curr = curr.forward[0];
        if (curr == null || curr.val != num) {
            return false;
        }

        for (int i = 0; i < level; i++) {
            if (update[i].forward[i] != curr) break;
            update[i].forward[i] = curr.forward[i];
        }
        while (level > 1 && head.forward[level - 1] == null) {
            level--;
        }
        return true;
    }

    public static void main(String[] args) {
        SkipList list = new SkipList();
        list.add(3);
        list.add(1);
        list.add(2);
        System.out.println(list.search(2)); // true
        list.erase(2);
        System.out.println(list.search(2)); // false
    }
}
