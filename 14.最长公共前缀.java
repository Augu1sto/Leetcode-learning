package leetcode.editor.cn;

//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
// Related Topics 字符串 👍 2091 👎 0

import java.util.Arrays;

//Java：最长公共前缀
class LongestCommonPrefix{
    public static void main(String[] args) {
        Solution solution = new LongestCommonPrefix().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs.length == 0) {
                return "";
            }
            // 按长度排序，可省略这步，在后面加判断
            Arrays.sort(strs,(a,b)->a.length()-b.length());
            int len = strs[0].length();
            int res = 0;
            int flag = 0;
            for (int i = 0; i < len; i++) {
                char ch = strs[0].charAt(i);
                for (String str:strs) {
                    if (str.charAt(i) != ch) {
                        flag = 1;
                        break;
                    }
                }
                if (flag == 1) {
                    break;
                }
                res = i+1;
            }
            return strs[0].substring(0,res);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
