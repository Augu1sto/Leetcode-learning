#
# @lc app=leetcode.cn id=1155 lang=python3
#
# [1155] 掷骰子的N种方法
#
# https://leetcode-cn.com/problems/number-of-dice-rolls-with-target-sum/description/
#
# algorithms
# Medium (48.62%)
# Likes:    125
# Dislikes: 0
# Total Accepted:    12.6K
# Total Submissions: 25.8K
# Testcase Example:  '1\n6\n3'
#
# 这里有 n 个一样的骰子，每个骰子上都有 k 个面，分别标号为 1 到 k 。
# 
# 给定三个整数 n ,  k 和 target ，返回可能的方式(从总共 k^n 种方式中)滚动骰子的数量，使正面朝上的数字之和等于 target 。
# 
# 答案可能很大，你需要对 10^9 + 7 取模 。
# 
# 
# 
# 示例 1：
# 
# 
# 输入：n = 1, k = 6, target = 3
# 输出：1
# 解释：你扔一个有6张脸的骰子。
# 得到3的和只有一种方法。
# 
# 
# 示例 2：
# 
# 
# 输入：n = 2, k = 6, target = 7
# 输出：6
# 解释：你扔两个骰子，每个骰子有6个面。
# 得到7的和有6种方法1+6 2+5 3+4 4+3 5+2 6+1。
# 
# 
# 示例 3：
# 
# 
# 输入：n = 30, k = 30, target = 500
# 输出：222616187
# 解释：返回的结果必须是对 10^9 + 7 取模。
# 
# 
# 
# 提示：
# 
# 
# 1 <= n, k <= 30
# 1 <= target <= 1000
# 
# 
#

# @lc code=start
class Solution:
    def numRollsToTarget(self, n: int, k: int, target: int) -> int:
        MOD = 1000000007
        dp = [[0]*(target+1) for _ in range(n+1)]
        print(dp)
        dp[0][0] = 1
        for i in range(1,n+1):
            for num in range(1, k+1):
                for j in range(target,num-1, -1):
                    dp[i][j] += dp[i-1][j-num]
                    dp[i][j] %= MOD
            
        return dp[n][target]
# @lc code=end

res = Solution().numRollsToTarget(1,6,3)

