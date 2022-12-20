# 题目描述

定义栈的数据，请在该类型中实现一个能够找到栈的最小元素的min函数。在该栈中，调用min、push及pop的时间复杂度都是O(1)。

# 解题思路

使用一个辅助栈来保存最小的值，使用一个数据栈来保存数据

# 题解

```java
class MinStack {

        // 保存数据
        Stack<Integer> dataStack = new Stack<>();

        // 保存最小值
        Stack<Integer> minStack = new Stack<>();

        /**
         * initialize your data structure here.
         */
        public MinStack() {

        }

        public void push(int x) {
            dataStack.push(x);
            if (minStack.isEmpty() || x < minStack.peek()) {
                minStack.push(x);
            } else {
                minStack.push(minStack.peek());
            }
        }

        public void pop() {
            dataStack.pop();
            minStack.pop();
        }

        public int top() {
            return dataStack.peek();
        }

        public int min() {
            return minStack.peek();
        }
    }
```
