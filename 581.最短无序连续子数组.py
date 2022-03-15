#
# @lc app=leetcode.cn id=581 lang=python3
#
# [581] 最短无序连续子数组
#

# @lc code=start
class Solution:
    def findUnsortedSubarray(self, nums: List[int]) -> int:
        i = 0
        j = len(nums)-1
        while i < len(nums)-1 and nums[i]<=nums[i+1]:
            i+=1
        
        # 考虑特殊情况
        if i == len(nums)-1:
            return 0

        while j > 0 and nums[j]>=nums[j-1]:
            j-=1
        
        Max = nums[i]
        Min = nums[j]

        # 在i，j区间内找最大和最小值
        for num in nums[i:j]:
            Max = max(num, Max)
            Min = min(num, Min)


        # 找到左边第一个比Min大的数
        left = 0
        while left < i and nums[left] <= Min:
            left+=1
        # 找到右边第一个比Max小的数
        right = len(nums) - 1
        while right > j  and nums[right] >= Max:
            right-=1
        
        return right-left+1
        


# @lc code=end

