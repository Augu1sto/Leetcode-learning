package leetcode.editor.cn;

//请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。 
//
// 
//
// 示例 1: 
//
// 输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// s.length <= 40000 
// 
//
// 注意：本题与主站 3 题相同：https://leetcode-cn.com/problems/longest-substring-without-
//repeating-characters/ 
// Related Topics 哈希表 字符串 滑动窗口 👍 386 👎 0

import java.util.HashMap;
import java.util.Map;

//Java：最长不含重复字符的子字符串
public class ZuiChangBuHanZhongFuZiFuDeZiZiFuChuanLcof{
    public static void main(String[] args) {
        Solution solution = new ZuiChangBuHanZhongFuZiFuDeZiZiFuChuanLcof().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            if (s.length()==0) {
                return 0;
            }
            Map<Character, Integer> characterMap = new HashMap<>();
            int i = 0;
            int maxLen = 0;
            for (int j = 0; j < s.length(); j++) {
                char ch = s.charAt(j);
                int k = characterMap.getOrDefault(ch,0)+1;
                characterMap.put(ch,k);
                if (characterMap.size()==j-i+1) {
                    maxLen = Math.max(maxLen, j-i+1);
                }
                while(characterMap.size()<j-i+1) {
                    char chi = s.charAt(i);
                    int ki = characterMap.get(chi)-1;
                    characterMap.put(chi,ki);
                    if (ki == 0) {
                        characterMap.remove(chi);
                    }
                    i++;
                }

            }
            return maxLen;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
