# README leetcode总结

|      | title                                                        | code                                                         | note                                                         | keyword                                         | remark                                                       |
| ---- | ------------------------------------------------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ | ----------------------------------------------- | ------------------------------------------------------------ |
|      | [爬楼梯](doc/content/ClimbingStairs.md)                      | [爬楼梯](ClimbingStairs.java)                                |                                                              | DP<br />dp[i]：第i集有多少种                    | 用递归会超时。可以用两个变量交替更新。                       |
|      | [使用最小花费爬楼梯.md](doc/content/MinCostClimbingStairs.md) | [使用最小花费爬楼梯](MinCostClimbingStairs.java)             |                                                              | DP                                              | 注意爬到顶的时候，i<=cost.length                             |
|      | [不同路径.md](doc/content/UniquePaths.md)                    | [不同路径](UniquePaths.java)                                 |                                                              | DP                                              |                                                              |
|      | [不同路径ii.md](doc/content/UniquePathsIi.md)                | [不同路径ii](UniquePathsIi.java)                             |                                                              | DP<br />有障碍物                                | 有障碍物的格子不可达，置0<br />注意初始化条件，dp/[0][0]单独进行，dp/[0][j]=dp/[0][j-1] |
|      | [七进制.md](doc/content/Base7.md)                            | [七进制](Base7.java)                                         |                                                              | 数学<br />StringBuilder                         |                                                              |
| ⭐    | [IntegerBreak.md](doc/content/IntegerBreak.md)               | [整数划分](IntegerBreak.java)                                |                                                              | DP；数学                                        | 状态转移方程！i,j                                            |
| ⭐    | [UniqueBinarySearchTrees.md](doc/content/UniqueBinarySearchTrees.md) | [不同的二叉搜索树](UniqueBinarySearchTrees.java)             |                                                              | DP;二叉树<br />每种根节点，左子树和右子树的种数 | 做出来了，但耗时有点长                                       |
| ⭐    | [PartitionEqualSubsetSum.md](doc/content/PartitionEqualSubsetSum.md) | [分割等和子集](PartitionEqualSubsetSum.java)                 |                                                              | 0-1背包<br />从大到小dp                         | 如果题目给的价值有负数，那么非0下标就要初始化为负无穷        |
| ⭐⭐   | [LastStoneWeightIi.md](doc/content/LastStoneWeightIi.md)     | [最后一块石头的重量Ⅱ](LastStoneWeightIi.java)                |                                                              | 0-1背包                                         | 问题转化为：把一堆石头分成两堆,求两堆石头重量差最小值<br />target=sum/2<br />res = sum - 2*dp |
| ⭐⭐   | [TargetSum.md](doc/content/TargetSum.md)                     | [目标和](TargetSum.java)                                     |                                                              | 0-1背包<br />正负数分组                         | 记得一开始判断是否存在                                       |
| ⭐    | [OnesAndZeroes.md](doc/content/OnesAndZeroes.md)             | [一和零](OnesAndZeros.java)                                  |                                                              | 0-1背包<br />二维的                             | 倒是自己做对了；注意                                         |
|      | [CoinChange.md](doc/content/CoinChange.md)                   | [零钱兑换](CoinChange.java)                                  |                                                              | 完全背包                                        | maxVal = amount+1                                            |
|      | [CoinChange2.md](doc/content/CoinChange2.md)                 | [零钱兑换2](CoinChange2.java)                                |                                                              | 完全背包组合问题                                |                                                              |
| ⭐    | [ValidateBinarySearchTree.md](doc/content/ValidateBinarySearchTree.md) | [验证二叉搜索树](ValidateBinarySearchTree.java)              |                                                              | 中序遍历                                        | 设置pre值为MIN_VALUE                                         |
| ⭐⭐⭐  | [2055.蜡烛之间的盘子.md](doc/content/2055.蜡烛之间的盘子.md) | [2055.蜡烛之间的盘子.md](2055.蜡烛之间的盘子.java)           | [2055.蜡烛之间的盘子.md](doc/note/2055.蜡烛之间的盘子.md)    | 前缀和<br />正序遍历+倒序遍历                   | 搞清楚遍历方向                                               |
| ⭐⭐   | [377.组合总和 Ⅳ.md](doc/content/377.组合总和 Ⅳ.md)           | [377.组合总和 Ⅳ](377.组合总和 Ⅳ.java)                        |                                                              | 排列背包组合问题                                | 附加思考存在负数的情况                                       |
| ⭐    | [279.完全平方数.md](doc/content/279.完全平方数.md)           | [279.完全平方数](279.完全平方数.java)                        |                                                              | 完全背包最值问题                                | 最小值一开始要赋值为n+1                                      |
| ⭐⭐   | [1155.掷骰子的N种方法.md](doc/content/1155.掷骰子的N种方法.md) | [1155.掷骰子的N种方法](1155.掷骰子的N种方法.java)            |                                                              | 分组背包问题                                    | 外循环分组，内循环0-1背包                                    |
|      | [剑指 Offer 10- I.斐波那契数列.md](doc/content/剑指 Offer 10- I.斐波那契数列.md) | [剑指 Offer 10- I.斐波那契数列](剑指 Offer 10- I.斐波那契数列.java) |                                                              |                                                 | 注意不要用递归会超时                                         |
| ⭐    | [剑指 Offer 63.股票的最大利润.md](doc/content/剑指 Offer 63.股票的最大利润.md) | [剑指 Offer 63.股票的最大利润](剑指 Offer 63.股票的最大利润.java) | [剑指 Offer 63.股票的最大利润.md](doc/note/剑指 Offer 63.股票的最大利润.md) |                                                 |                                                              |
| ⭐    | [剑指 Offer 42.连续子数组的最大和.md](doc/content/剑指 Offer 42.连续子数组的最大和.md) | [剑指 Offer 42.连续子数组的最大和](剑指 Offer 42.连续子数组的最大和.java) | [剑指 Offer 42.连续子数组的最大和.md](doc/note/剑指 Offer 42.连续子数组的最大和.md) |                                                 | maxi = max (i, maxi+i)<br />maxSum = max(maxi)               |
| 同上 | [53. 最大子数组和 (leetcode-cn.com)](https://leetcode-cn.com/problems/maximum-subarray/description/) |                                                              | [53. 最大子数组和 (gitee.io)](https://augu1sto.gitee.io/0d8a87a8eab4/#53-最大子数组和) |                                                 | 同上，另有分治的做法                                         |
| ⭐⭐   | [1109.航班预订统计.md](doc/content/1109.航班预订统计.md)     | [1109.航班预订统计](1109.航班预订统计.java)                  | [1109.航班预订统计.md](doc/note/1109.航班预订统计.md)        | 差分数组<br />区间求和                          |                                                              |
| ⭐⭐⭐  | [798.得分最高的最小轮调.md](doc/content/798.得分最高的最小轮调.md) | [798.得分最高的最小轮调](798.得分最高的最小轮调.java)        | [798.得分最高的最小轮调.md](doc/note/798.得分最高的最小轮调.md) | 差分数组<br />上下界                            | 下标为：<br />（i-k+n）%n                                    |
|      | [剑指 Offer 47.礼物的最大价值.md](doc/content/剑指 Offer 47.礼物的最大价值.md) | [剑指 Offer 47.礼物的最大价值](剑指 Offer 47.礼物的最大价值.java) |                                                              | DP                                              |                                                              |
| ⭐    | [剑指 Offer 46.把数字翻译成字符串.md](doc/content/剑指 Offer 46.把数字翻译成字符串.md) | [剑指 Offer 46.把数字翻译成字符串](剑指 Offer 46.把数字翻译成字符串.java) | [剑指 Offer 46.把数字翻译成字符串.md](doc/note/剑指 Offer 46.把数字翻译成字符串.md) | DP                                              | 注意dpi和dpi-1以及dpi-2的关系                                |
| ⭐    | [剑指 Offer 48.最长不含重复字符的子字符串.md](doc/content/剑指 Offer 48.最长不含重复字符的子字符串.md) | [剑指 Offer 48.最长不含重复字符的子字符串](剑指 Offer 48.最长不含重复字符的子字符串.java) | [剑指 Offer 48.最长不含重复字符的子字符串.md](doc/note/剑指 Offer 48.最长不含重复字符的子字符串.md) | DP<br />滑动窗口                                | DP更快，统计每个字符最后出现的位置                           |
|      | [数组的中心索引](https://leetcode-cn.com/leetbook/read/array-and-string/yf47s/) |                                                              | [2. 寻找数组的中心索引 (gitee.io)](https://augu1sto.gitee.io/0d8a87a8eab4/#寻找数组的中心索引) | 前缀和                                          |                                                              |
| ⭐    | [对角线遍历](https://leetcode-cn.com/leetbook/read/array-and-string/cuxq3/) |                                                              | [3. 对角线遍历 (gitee.io)](https://augu1sto.gitee.io/0d8a87a8eab4/#对角线遍历) |                                                 | 记录左上和右下的行为，进行推导；偶数右上，奇数左下           |
| ⭐⭐   | [31. 下一个排列](https://leetcode-cn.com/problems/next-permutation) |                                                              | [4. 31. 下一个排列 (gitee.io)](https://augu1sto.gitee.io/0d8a87a8eab4/#31-下一个排列) |                                                 | 找a[i-1]，从后往前数，它是第一个满足非降序即a[i-1]<a[i]的；再进行调整 |
| ⭐    | [34. 在排序数组中查找元素的第一个和最后一个位置 (leetcode-cn.com)](https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/) |                                                              | [5. 34. 在排序数组中查找元素的第一个和最后一个位置 (gitee.io)](https://augu1sto.gitee.io/0d8a87a8eab4/#34-在排序数组中查找元素的第一个和最后一个位置) | 二分                                            | 将问题转化为 找 `target-1`和`target`的最右侧值a和b（即第一个大于它们的数） |
| ⭐    | [39. 组合总和 (leetcode-cn.com)](https://leetcode-cn.com/problems/combination-sum/) |                                                              | [39. 组合总和 (gitee.io)](https://augu1sto.gitee.io/78b6fa9cea22/#39-组合总和) | 回溯组合问题<br />可重复选取                    | 先排序，则sum==target的时候就可以中断直接返回<br />可重复，所以递归的时候是i，不是i+1 |
|      | [77. 组合 (leetcode-cn.com)](https://leetcode-cn.com/problems/combinations/) |                                                              | [2.1. 77. 组合 (gitee.io)](https://augu1sto.gitee.io/78b6fa9cea22/#77-组合) | 回溯组合问题<br />不重复                        | 通过设置startIndex（即t），决定每次横向遍历时的起始坐标，进行剪枝<br />剩下的数：= n - 集合中还差的数的个数（k-comb.size()） +1 |
| ⭐    | [216. 组合总和 III (leetcode-cn.com)](https://leetcode-cn.com/problems/combination-sum-iii/description/) |                                                              | [216. 组合总和 III (gitee.io)](https://augu1sto.gitee.io/78b6fa9cea22/#216-组合总和-iii) | 回溯组合问题<br />不重复                        | 同上，注意判断终止条件                                       |
| ⭐    | [17. 电话号码的字母组合 (leetcode-cn.com)](https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/description/) |                                                              | [17. 电话号码的字母组合 (gitee.io)](https://augu1sto.gitee.io/78b6fa9cea22/#⭐17-电话号码的字母组合) | 回溯组合问题                                    | 用StringBuilder进行拼接<br />String[]数组来索引              |
| ⭐    | [40. 组合总和 II (leetcode-cn.com)](https://leetcode-cn.com/problems/combination-sum-ii/description/) |                                                              | [40. 组合总和 II (gitee.io)](https://augu1sto.gitee.io/78b6fa9cea22/#40-组合总和-ii) | 回溯组合问题<br />有重复元素但组合不重复        | 排序<br />需要去重：如果下一个数和当前数相等，跳过continue   |
| ⭐⭐⭐  | [42. 接雨水 (leetcode-cn.com)](https://leetcode-cn.com/problems/trapping-rain-water/description/) |                                                              | [40. 组合总和 II (gitee.io)](https://augu1sto.gitee.io/0d8a87a8eab4/#40-组合总和-ii) | DP                                              | 从左往右遍历：left[i]：i左边最大的值（包括i）；<br />从右往左遍历：right[i]：i右边最大的值（包括i）<br />i点能接的雨水就=min(left[i],right[i])-height[i]<br />(其它做法见solution) |
| ⭐    | [48. 旋转图像 (leetcode-cn.com)](https://leetcode-cn.com/problems/rotate-image/description/) |                                                              | [48. 旋转图像 (gitee.io)](https://augu1sto.gitee.io/0d8a87a8eab4/#48-旋转图像) | 旋转-》翻转                                     |                                                              |
| ⭐⭐   | [55. 跳跃游戏 (leetcode-cn.com)](https://leetcode-cn.com/problems/jump-game/description/) |                                                              | [55. 跳跃游戏 (gitee.io)](https://augu1sto.gitee.io/0d8a87a8eab4/#55-跳跃游戏) | 贪心                                            | 设置maxF作为数组最远可以到的地方，随着遍历更新               |
| ⭐    | [56. 合并区间 (leetcode-cn.com)](https://leetcode-cn.com/problems/merge-intervals/description/) |                                                              | [56. 合并区间 (gitee.io)](https://augu1sto.gitee.io/0d8a87a8eab4/#56-合并区间) |                                                 | 先排序<br />最后注意类型转换                                 |
| ⭐    | [59. 螺旋矩阵 II (leetcode-cn.com)](https://leetcode-cn.com/problems/spiral-matrix-ii/description/) |                                                              | [59. 螺旋矩阵 II (gitee.io)](https://augu1sto.gitee.io/0d8a87a8eab4/#59-螺旋矩阵-ii) | 模拟                                            | 定义→↓←↑的操作，注意每个操作的转折点<br />或者参考[solution](https://leetcode-cn.com/problems/spiral-matrix-ii/solution/luo-xuan-ju-zhen-ii-by-leetcode-solution-f7fp/835205)的写法 |
| ⭐⭐   | [79. 单词搜索 (leetcode-cn.com)](https://leetcode-cn.com/problems/word-search/description/) | [单词搜索](WordSearch.java)                                  | [79. 单词搜索 (gitee.io)](https://augu1sto.gitee.io/0d8a87a8eab4/#79-单词搜索) | visited判断是否访问过<br />回溯                 | 注意先判断是否遍历结束，再判断其他条件                       |
| ⭐⭐   | [84. 柱状图中最大的矩形 (leetcode-cn.com)](https://leetcode-cn.com/problems/largest-rectangle-in-histogram/description/) |                                                              | [84. 柱状图中最大的矩形 (gitee.io)](https://augu1sto.gitee.io/0d8a87a8eab4/#84-柱状图中最大的矩形) | 单调栈                                          | 公式都列出来了。。但是别用DP了，单调栈吧，DP条件太细了。。   |
|      | [589.N 叉树的前序遍历.md](doc/content/589.N 叉树的前序遍历.md) | [589.N 叉树的前序遍历.](589.N 叉树的前序遍历.java)           | [589.N 叉树的前序遍历.md](doc/note/589.N 叉树的前序遍历.md)  | 二叉树变体                                      | 递归更快<br />迭代的话用栈，按中右左的顺序压栈               |
| ⭐    | [DailyTemperatures.md](doc/content/DailyTemperatures.md)     | [DailyTemperatures](DailyTemperatures.java)                  |                                                              | 单调栈                                          |                                                              |
| ⭐    | [496.下一个更大元素 I.md](doc/content/496.下一个更大元素 I.md) | [496.下一个更大元素 I.](496.下一个更大元素 I.java)           |                                                              | 单调栈                                          | 先遍历nums2找nums2的下一个元素，用哈希表记录                 |
| ⭐    | [503.下一个更大元素 II.md](doc/content/503.下一个更大元素 II.md) | [503.下一个更大元素 II.](503.下一个更大元素 II.java)         |                                                              | 单调栈                                          | i<2n; j=i%n                                                  |
|      | [14.最长公共前缀.md](doc/content/14.最长公共前缀.md)         | [14.最长公共前缀](14.最长公共前缀.java)                      |                                                              |                                                 | 乖乖遍历就好                                                 |
|      | [剑指 offer 06. 从尾到头打印链表 (leetcode-cn.com)](doc/content/CongWeiDaoTouDaYinLianBiaoLcof.md) | [从尾到头打印链表](CongWeiDaoTouDaYinLianBiaoLcof.java)      | [1.5. 链表的递归遍历 (gitee.io)](https://augu1sto.gitee.io/ca5d5f76ba80/#链表的递归遍历) | 链表                                            | 栈/递归                                                      |
|      | [203. 移除链表元素 (leetcode-cn.com)](https://leetcode-cn.com/problems/remove-linked-list-elements/description/) |                                                              | [2. 基础操作：203. 移除链表元素 (gitee.io)](https://augu1sto.gitee.io/ca5d5f76ba80/#基础操作：203-移除链表元素) | 链表                                            | 要用前置结点pre<br />设置虚拟头节点                          |
|      | [设计链表 (leetcode-cn.com)](https://leetcode-cn.com/problems/design-linked-list/description/) |                                                              | [3. 基础操作：707.设计链表 (gitee.io)](https://augu1sto.gitee.io/ca5d5f76ba80/#基础操作：707-设计链表) | 链表                                            | 长度+伪头                                                    |
| ⭐    | [2. 两数相加 (leetcode-cn.com)](https://leetcode-cn.com/problems/add-two-numbers/description/) |                                                              | [4. 2. 两数相加 (gitee.io)](https://augu1sto.gitee.io/ca5d5f76ba80/#2-两数相加) | 链表                                            | 记录进位<br />不能忘了最后如果有一位1的话要新建节点          |
| ⭐    | [19. 删除链表的倒数第 N 个结点 (leetcode-cn.com)](https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/description/) |                                                              | [5. 19. 删除链表的倒数第 N 个结点 (gitee.io)](https://augu1sto.gitee.io/ca5d5f76ba80/#19-删除链表的倒数第-n-个结点) | 快慢指针<br />链表                              |                                                              |
| ⭐⭐⭐  | [23. 合并K个升序链表 (leetcode-cn.com)](https://leetcode-cn.com/problems/merge-k-sorted-lists/description/) |                                                              | [6. 23. 合并K个升序链表 (gitee.io)](https://augu1sto.gitee.io/ca5d5f76ba80/#23-合并k个升序链表) | 分治/优先队列<br />链表                         |                                                              |
|      | [141. 环形链表 (leetcode-cn.com)](https://leetcode-cn.com/problems/linked-list-cycle/description/) |                                                              | [7. 141. 环形链表 (gitee.io)](https://augu1sto.gitee.io/ca5d5f76ba80/#141-环形链表) | 快慢指针<br />链表                              | 都从头开始，一个挪1，一个挪2，相遇则true                     |
| ⭐    | [142. 环形链表 II (leetcode-cn.com)](https://leetcode-cn.com/problems/linked-list-cycle-ii/description/) |                                                              | [8. 142. 环形链表 II (gitee.io)](https://augu1sto.gitee.io/ca5d5f76ba80/#142-环形链表-ii) | 快慢指针<br />链表                              | 推公式；相遇时，新设一个newp从head开始，和slowp同速移动，直到相遇 |
|      | [回转寿司](https://www.nowcoder.com/questionTerminal/5a2a527f68b6434ba0b4faadcdc97812?orderByHotValue=0&page=1&onlyReference=false) | [KaitenSushi](KaitenSushi.java)                              |                                                              | 动态规划<br />DP                                | 两种情况：<br />- 不位于交界处，找最大子数组和<br />- 位于交界处，用总和-最小子数组和<br />取两者中最大的即可 |
|      | [590.N 叉树的后序遍历.md](doc/content/590.N 叉树的后序遍历.md) | [590.N 叉树的后序遍历.](N 叉树的后序遍历.java)               |                                                              | 二叉树                                          |                                                              |
|      | [2049.统计最高分的节点数目.md](doc/content/2049.统计最高分的节点数目.md) | [2049.统计最高分的节点数目](2049.统计最高分的节点数目.java)  |                                                              |                                                 | 数据结构。。（待优化）<br />long类型                         |
| ⭐⭐   | [236. 二叉树的最近公共祖先 (leetcode-cn.com)](https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/description/) |                                                              | [236. 二叉树的最近公共祖先 (gitee.io)](https://augu1sto.gitee.io/e55c8c160eac/#236-二叉树的最近公共祖先) | 分成左子树和右子树遍历                          | 自底向上查找 --> 二叉树回溯 --> 后序遍历(最先处理的是叶子节点) |
|      | [393.UTF-8 编码验证.md](doc/content/393.UTF-8 编码验证.md)   | [393.UTF-8 编码验证](393.UTF-8 编码验证.java)                |                                                              | 位运算                                          | 注意细节                                                     |
| ⭐    | [215.数组中的第K个最大元素.md](doc/content/215.数组中的第K个最大元素.md) | [215.数组中的第K个最大元素.](215.数组中的第K个最大元素.java) | [215.数组中的第K个最大元素.md](doc/note/215.数组中的第K个最大元素.md) | 随机基准数优化<br />排序                        | 快速排序                                                     |
| ⭐    | [206.反转链表.md](doc/content/206.反转链表.md)               | [206.反转链表.](206.反转链表.java)                           | [206.反转链表.md](doc/note/206.反转链表.md)                  | 链表                                            | 递归方法的理解！                                             |
| ⭐⭐   | [124.二叉树中的最大路径和.md](doc/content/124.二叉树中的最大路径和.md) | [124.二叉树中的最大路径和.](124.二叉树中的最大路径和.java)   | [124.二叉树中的最大路径和.md](doc/note/124.二叉树中的最大路径和.md) | 递归<br />DP<br />二叉树                        | 类比最大连续子数组和，自己耗时略长，有空看看官方的           |
| ⭐⭐   | [450.删除二叉搜索树中的节点.md](doc/content/450.删除二叉搜索树中的节点.md) | [450.删除二叉搜索树中的节点.](450.删除二叉搜索树中的节点.java) | [16. 450. 删除二叉搜索树中的节点 (gitee.io)](https://augu1sto.gitee.io/e55c8c160eac/#450-删除二叉搜索树中的节点) | 二叉树                                          | 先找，找到后分情况：叶子/只有左/只有右直接处理，否则：<br />找到右子树最左边的节点，用它的值替换要删除的节点的值，再删了它 |
| ⭐⭐⭐  | [146.LRU 缓存.md](doc/content/146.LRU 缓存.md)               | [146.LRU 缓存.](146.LRU 缓存.java)                           | [源于 LinkedHashMap源码 - LRU 缓存 - 力扣](https://leetcode-cn.com/problems/lru-cache/solution/yuan-yu-linkedhashmapyuan-ma-by-jeromememory/) | 双向链表/<br />LinkedHashMap                    | 数据结构！                                                   |
|      | [3.无重复字符的最长子串.md](doc/content/3.无重复字符的最长子串.md) | [3.无重复字符的最长子串](3.无重复字符的最长子串.java)        | [无重复字符的最长字串](https://augu1sto.gitee.io/8520ff749f4c/#3-无重复字符的最长字串) | 滑动窗口<br />字符串                            |                                                              |
| ⭐⭐   | [207.课程表.md](doc/content/207.课程表.md)                   | [207.课程表](207.课程表.java)                                | [207.课程表.md](doc/note/207.课程表.md)                      | 图                                              | 经典图题，多看看dfs,bfs                                      |
|      | [剑指 Offer 30.包含min函数的栈.md](doc/content/剑指 Offer 30.包含min函数的栈.md) | [最小栈](包含min函数的栈.java)                               |                                                              |                                                 |                                                              |
| ⭐⭐   | [LongestMountainInArray.md](doc/content/LongestMountainInArray.md) | [845.数组中的最长山脉](845.数组中的最长山脉.java)            | [LongestMountainInArray.md](doc/note/LongestMountainInArray.md) |                                                 |                                                              |
| ⭐⭐   | [FindGoodDaysToRobTheBank.md](doc/content/FindGoodDaysToRobTheBank.md) | [2100.适合打劫银行的日子](2100.适合打劫银行的日子.java)      | [FindGoodDaysToRobTheBank.md](doc/note/FindGoodDaysToRobTheBank.md) |                                                 |                                                              |
|      | [2131.连接两字母单词得到的最长回文串.md](doc\content\2131.连接两字母单词得到的最长回文串.md) | [2131.连接两字母单词得到的最长回文串.](2131.连接两字母单词得到的最长回文串.java) | [2131.连接两字母单词得到的最长回文串.md](doc\note\2131.连接两字母单词得到的最长回文串.md) | 字符串                                          | 实操有点慢了，注意字符串拼接字符的方法                       |
|      | [2165.重排数字的最小值.md](doc\content\2165.重排数字的最小值.md) | [2165.重排数字的最小值](2165.重排数字的最小值.java)          | [2165.重排数字的最小值.md](doc\note\2165.重排数字的最小值.md) | 数组                                            | 注意java数组排序                                             |
|      | [599.两个列表的最小索引总和.md](doc\content\599.两个列表的最小索引总和.md) | [599.两个列表的最小索引总和](599.两个列表的最小索引总和.java) |                                                              | 数组                                            | 注意细节                                                     |

