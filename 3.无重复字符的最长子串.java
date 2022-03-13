package leetcode.editor.cn;

//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
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
// 0 <= s.length <= 5 * 10⁴ 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 字符串 滑动窗口 👍 7112 👎 0

import com.sun.source.tree.WhileLoopTree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

//Java：无重复字符的最长子串
class LongestSubstringWithoutRepeatingCharacters{
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            Map<Character, Integer> map = new HashMap<>();
            int maxLen = 0;
            int starIndex = 0;
            for (int i = 0; i < s.length(); i++) {
                int k = map.getOrDefault(s.charAt(i),0)+1;
                map.put(s.charAt(i),k);
                if (i-starIndex+1 == map.size()) {
                    maxLen = Math.max(maxLen,i-starIndex+1);
                }
                // 有重复的
                while (i-starIndex+1>map.size()) {
                    // 获取startIndex处的字符，减一
                    int t = map.get(s.charAt(starIndex)) - 1;
                    if (t == 0) {
                        // 如果t=0，说明减没了，直接移除改节点
                        map.remove(s.charAt(starIndex));
                        starIndex++;
                        break;
                    }
                    map.put(s.charAt(starIndex),t);
                    starIndex++;
                }
            }
            return maxLen;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
