遍历一遍（已经是最优解）

用哈希表记录所有元素出现的次数

再遍历一遍

返回第一个出现次数为1次的

---

队列（更复杂）

set

遍历，对于数字a

- set中没有，加入set，入队
- set中有，
  - 队列pop-》e，计数
    - e==a或者循环了一轮（cnt=que.size-1）（找不到a）,出队停止
    - e!=a，再push，cnt++继续出队
- 最后队列的首个元素就是所求的

---

题解里提到另一种用队列的方法，也没有明显高效

自己定义一个队列的数据结构

```java

 Queue<Pair> queue = new LinkedList<Pair>();


    class Pair {
        char ch;
        int pos;

        Pair(char ch, int pos) {
            this.ch = ch;
            this.pos = pos;
        }
    }

```

对于哈希映射中的每一个键值对，键表示一个字符，值表示它的首次出现的索引（如果该字符只出现一次）或者 −1（如果该字符出现多次）。

对字符串进行遍历时，设当前遍历到的字符为 cc，如果 cc 不在哈希映射中，我们就将 cc 与它的索引作为一个二元组放入队尾，否则我们就需要检查队列中的元素是否都满足「只出现一次」的要求，即我们不断地根据哈希映射中存储的值（是否为 -1−1）选择弹出队首的元素，直到队首元素「真的」只出现了一次或者队列为空。

作者：LeetCode-Solution
链接：https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/solution/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-by-3zqv5/



