# README leetcode总结

|      | title                                                        | code                                             | note                                                       | keyword              | tag  | remark                                                       |
| ---- | ------------------------------------------------------------ | ------------------------------------------------ | ---------------------------------------------------------- | -------------------- | ---- | ------------------------------------------------------------ |
|      | [ClimbingStairs](doc\content\ClimbingStairs.md)              | [爬楼梯](ClimbingStairs.java)                    | [爬楼梯](https://programmercarl.com/0070.爬楼梯.html#思路) | dp[i]：第i集有多少种 | DP   | 用递归会超时。可以用两个变量交替更新。                       |
|      | [MinCostClimbingStairs.md](doc\content\MinCostClimbingStairs.md) | [使用最小花费爬楼梯](MinCostClimbingStairs.java) |                                                            |                      | DP   | 注意爬到顶的时候，i<=cost.length                             |
|      | [UniquePaths.md](doc\content\UniquePaths.md)                 | [不同路径](UniquePaths.java)                     |                                                            |                      | DP   |                                                              |
|      | [UniquePathsIi.md](doc\content\UniquePathsIi.md)             | [不同路径ii](UniquePathsIi.md)                   |                                                            | 有障碍物             | DP   | 有障碍物的格子不可达，置0<br />注意初始化条件，dp\[0][0]单独进行，dp\[0][j]=dp\[0][j-1] |

