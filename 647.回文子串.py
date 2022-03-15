#
# @lc app=leetcode.cn id=647 lang=python3
#
# [647] 回文子串
#

# @lc code=start
class Solution:
    def __init__(self):
        self.res = 0
    def countSubstrings(self, s: str) -> int:
        for i in range(1, len(s)):
            self.countFromIJ(s,i-1,i-1)
            self.countFromIJ(s,i-1,i)
        self.res += 1 # 加上s[-1]
        return self.res
    
    def countFromIJ(self, s, left, right):
        '''
            从left,right中心扩散
            当s的长度为偶数时，right事实上=left+1
            ..........奇数时，right=left
        '''
        while left>=0 and right<=len(s)-1 and s[left]==s[right]:
            self.res+=1
            left-=1
            right+=1

# @lc code=end

test = Solution().countSubstrings("aaa")

