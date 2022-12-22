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

#### 扩展

**[快排与topK问题](src/com/huabin/lcof/leetcode/editor/cn/notes/面试题30：最小的k个数.md)**


### 归并

#### 归并排序原理

归并排序体现了 “分而治之” 的算法思想，具体为：

* **分：** 不断将数组从中点位置划分开（即二分法），将整个数组的排序问题转化为子数组的排序问题；
* **治：** 划分到子数组长度为 1 时，开始向上合并，不断将 **较短排序数组** 合并为  **较长排序数组** ，直至合并至原数组时完成排序；

> 如下图所示，为数组 **[**7**,**3**,**2**,**6**,**0**,**1**,**5**,**4**]** 的归并排序过程。

![MergeSort1.png](assets/MergeSort-1.png?t=1671683014375)

#### 实现

```java
/**
 * 归并排序
 *
 * @Author rex
 * 2018/9/3
 */
public class MergeSort {
    /**
     * 归并排序
     * @param array
     * @param low
     * @param high
     * @return
     */
    public int[] mergeSort(int[] array, int low, int high) {
        if (low < high) {
            int mid = (low + high) >> 1;
            // 辅助数组
            int[] temp = new int[array.length];
            mergeSort(array, low, mid);
            mergeSort(array, mid + 1, high);
            merge(array, temp, low, mid, high);
        }
        return array;
    }

    /**
     * 归并
     * @param array
     * @param temp
     * @param low
     * @param mid
     * @param high
     */
    public void merge(int[] array, int[] temp, int low, int mid, int high) {

        // 代表左边下标
        int i = low;
        // 代表右边下标
        int j = mid + 1;
        // 代表辅助数组的下标
        int k = 0;
        while (i <= mid && j <= high) {
            if (array[i] < array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            }
        }
        // 如果左边有剩余元素，移入辅助数组
        while (i <= mid) {
            temp[k++] = array[i++];
        }
        // 如果右边有剩余元素，移入辅助数组
        while (j <= high) {
            temp[k++] = array[j++];
        }
        // 临时数组覆盖原数组
        System.arraycopy(temp, 0, array, low, high - low + 1);

    }
}
```


#### 扩展

[数组中的逆序对](src/com/huabin/lcof/leetcode/editor/cn/notes/面试题36：数组中的逆序对.md)






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
