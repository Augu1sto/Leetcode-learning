package leetcode.editor.cn;

import java.util.*;

/**
输入一个字符串，打印出该字符串中字符的所有排列。 

 

 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。 

 

 示例: 

 输入：s = "abc"
输出：["abc","acb","bac","bca","cab","cba"]
 

 

 限制： 

 1 <= s 的长度 <= 8 
 Related Topics 字符串 回溯 👍 536 👎 0

*/
//Java：字符串的排列
class ZiFuChuanDePaiLieLcof{
    public static void main(String[] args) {
        Solution solution = new ZiFuChuanDePaiLieLcof().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        boolean[] visited; // 第i个字母是否出现过
        Set<String> res = new HashSet<>(); // 去重
        StringBuilder st = new StringBuilder();

        public String[] permutation(String s) {
            char[] chars = s.toCharArray();
//            Arrays.sort(chars);
            int len = chars.length;
            visited = new boolean[len];
            backtracking(chars, 0);
            return res.toArray(new String[res.size()]);
        }

        void backtracking(char[] chars, int i) {
            if ( st.length() == chars.length) {
                res.add(st.toString());
                return;
            }
            for (int j = 0; j < chars.length ; j++) {
                // 排除重复元素
                if ( visited[j] ) {
                    continue;
                }
                st.append(chars[j]);
                visited[j] = true;
                backtracking(chars, j);
                visited[j] = false;
                st.deleteCharAt(st.length()-1);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
