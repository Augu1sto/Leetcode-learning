#
# @lc app=leetcode.cn id=5 lang=python3
#
# [5] 最长回文子串
#
# https://leetcode-cn.com/problems/longest-palindromic-substring/description/
#
# algorithms
# Medium (36.31%)
# Likes:    4866
# Dislikes: 0
# Total Accepted:    924.7K
# Total Submissions: 2.5M
# Testcase Example:  '"babad"'
#
# 给你一个字符串 s，找到 s 中最长的回文子串。
#
#
#
# 示例 1：
#
#
# 输入：s = "babad"
# 输出："bab"
# 解释："aba" 同样是符合题意的答案。
#
#
# 示例 2：
#
#
# 输入：s = "cbbd"
# 输出："bb"
#
#
#
#
# 提示：
#
#
# 1 <= s.length <= 1000
# s 仅由数字和英文字母组成
#
#
#

# @lc code=start

class Solution:
    def longestPalindrome(self, s: str) -> str:
        res = ""
        for i in range(len(s)):
            s1 = self.findPalindrome(s , i, i)
            s2 = self.findPalindrome(s, i, i+1)
            res = res if len(res)>len(s1) else s1
            res = res if len(res)>len(s2) else s2
        return res


    def findPalindrome(self, s, l, r):
        '''
            寻找以l为中心扩散的最长回文子串；
            偶串的情况：r=l+1
            奇串的情况：r=l
        '''
        while l>=0 and r<len(s) and s[l]==s[r]:
            l-=1
            r+=1
        return s[l+1:r]
        
# @lc code=end
