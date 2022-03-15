#
# @lc app=leetcode.cn id=287 lang=python3
#
# [287] 寻找重复数
#

# @lc code=start

from typing import List
class Solution:
    def findDuplicate(self, nums: List[int]) -> int:
        maxBit = 1
        n = len(nums) - 1
        while (n>>maxBit) != 0:
            maxBit+=1
        ans = 0
        for bit in range(maxBit):
            # 计算每一位的和
            sum_n = 0
            sum_num = 1 if nums[0]&(1<<bit)!= 0 else 0 # 初始时加上第一个数
            for i in range(1,n+1):
                if i&(1<<bit) != 0:
                    sum_n += 1
                if nums[i]&(1<<bit) != 0:
                    sum_num += 1
            # sum_num-sum_n 就是第i位为0/1的数
            if sum_num>sum_n:
                ans |= 1<<bit
        return ans

# @lc code=end

res = Solution().findDuplicate([2,1,1])
print(res)

