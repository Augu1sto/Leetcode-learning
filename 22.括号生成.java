package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 

 

 示例 1： 

 
输入：n = 3
输出：["((()))","(()())","(())()","()(())","()()()"]
 

 示例 2： 

 
输入：n = 1
输出：["()"]
 

 

 提示： 

 
 1 <= n <= 8 
 
 Related Topics 字符串 动态规划 回溯 👍 2617 👎 0

*/
//Java：括号生成
class GenerateParentheses{
    public static void main(String[] args) {
        Solution solution = new GenerateParentheses().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<String> ans = new ArrayList<>();
        StringBuilder res = new StringBuilder();
        Deque<Character> stack = new LinkedList<>();
        public List<String> generateParenthesis(int n) {
            if (n == 0) {
                return ans;
            }
            backtracking(n);
            return ans;
        }

        void backtracking(int n) {
            if (n == 0) {
                int i = stack.size();
                int j = i;
                if(!stack.isEmpty()) {
                    while(i>0) {
                        i--;
                        res.append(')'); // 加入）
                    }
                }
                ans.add(new String(res));
                // 回溯
                while(j>0) {
                    res.deleteCharAt(res.length()-1);
                    j--;
                }
                return;
            }
            // 选择一：加入‘)’
            if (!stack.isEmpty()) {
                stack.pop();
                res.append(')');
                backtracking(n);
                res.deleteCharAt(res.length()-1);
                stack.push('(');
            }
            // 选择二：加入‘(’
            stack.push('(');
            res.append('(');
            backtracking(n-1); // 消耗一个(，n-1
            res.deleteCharAt(res.length()-1);
            stack.pop();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
