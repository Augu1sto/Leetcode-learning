#
# @lc app=leetcode.cn id=560 lang=python3
#
# [560] 和为 K 的子数组
#

# @lc code=start
class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        cnt = 0
        preSum = 0
        myMap = {}
        myMap[0] = 1
        for num in nums:
            preSum += num
            if preSum - k in myMap:
                cnt += myMap[preSum-k]
            if preSum not in myMap:
                myMap[preSum] = 1
            else:
                myMap[preSum] += 1

        return cnt

# @lc code=end

