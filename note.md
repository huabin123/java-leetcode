# 总结的通用代码

# 数组

## 二分法通用代码（判断一个数在有序数组中是否存在）

```java
public int search(int[] nums, int target) {
    int low = 0, high = nums.length - 1;
    while (low <= high) {
        int mid = (high - low) / 2 + low;
        int num = nums[mid];
        if (num == target) {
            return mid;
        } else if (num > target) {
            high = mid - 1;
        } else {
            low = mid + 1;
        }
    }
    return -1;
}
```

# 链表

## 节点以及造数据

```java
public static class Node{
        public int value;
        public Node next;

        public Node(int data){
            value = data;
        }
    }

```

# 树

## 树的三种遍历

### 前序遍历

### 中序遍历

```java
// 打印中序遍历
void dfs(Node root) {
    if(root == null) return;
    dfs(root.left); // 左
    System.out.println(root.val); // 根
    dfs(root.right); // 右
}
```

### 后序遍历
