# 必须掌握的基石算法总结

# 数组

## 排序

### 快排

#### 快速排序原理：

快速排序算法有两个核心点，分别为 “哨兵划分” 和 “递归” 。

**哨兵划分操作：** 以数组某个元素（一般选取首元素）为 **基准数** ，将所有小于基准数的元素移动至其左边，大于基准数的元素移动至其右边。

**递归：** 对 **左子数组** 和 **右子数组** 递归执行  **哨兵划分** ，直至子数组长度为 1 时终止递归，即可完成对整个数组的排序。

> 如下图所示，为示例数组 `[2,4,1,0,3,5]` 的快速排序流程。观察发现，快速排序和 **二分法** 的原理类似，都是以 **lo**g 时间复杂度实现搜索区间缩小。

![QuickSort1.png](assets/QuickSort-1.png?t=1671604780333)

#### 代码实现

```java
class Solution {
        public void sort(int[] arr) {
            quickSort(arr, 0, arr.length - 1);
        }

        private void quickSort(int[] arr, int l, int r) {
            // 子数组长度为1时终止递归
            if (l >= r) {
                return;
            }
            // 哨兵划分操作（以arr[l]作为基准数）
            int i = l, j = r;
            while (i < j) {
                while (i < j && arr[j] >= arr[l]) {
                    j--;
                }
                while (i < j && arr[i] <= arr[l]) {
                    i++;
                }
                swap(arr, i, j);  // 这里不交换会一直循环
            }
            swap(arr, i, l);
            // 递归左（右）子数组执行哨兵划分
            quickSort(arr, l, i - 1);
            quickSort(arr, i + 1, r);
        }

        private void swap(int[] arr, int i, int j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }
```

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

**前序遍历**

**中序遍历**

```java
// 打印中序遍历
void dfs(Node root) {
    if(root == null) return;
    dfs(root.left); // 左
    System.out.println(root.val); // 根
    dfs(root.right); // 右
}
```

**后序遍历**


# 动态规划概念

dynamic programming，可以简单的理解为对传统递归的一种优化。

这里programming不是编程的意思，而是决策。但这种决策不是一下就出来的，而是一步步(multistage)积累出来。换句话说我们需要一个决策，但这个决策太大了，我们做不了，所以需要把他递归到我们可以简单做出决策的状态，然后从这些状态开始，慢慢的“动态地”演进到最终的决策。

例如：跳台阶，连续子数组最大和都是动态规划的问题。
