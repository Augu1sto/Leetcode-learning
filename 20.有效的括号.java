package leetcode.editor.cn;

import java.util.*;

/**
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 

 有效字符串需满足： 

 
 左括号必须用相同类型的右括号闭合。 
 左括号必须以正确的顺序闭合。 
 

 

 示例 1： 

 
输入：s = "()"
输出：true
 

 示例 2： 

 
输入：s = "()[]{}"
输出：true
 

 示例 3： 

 
输入：s = "(]"
输出：false
 

 示例 4： 

 
输入：s = "([)]"
输出：false
 

 示例 5： 

 
输入：s = "{[]}"
输出：true 

 

 提示： 

 
 1 <= s.length <= 10⁴ 
 s 仅由括号 '()[]{}' 组成 
 
 Related Topics 栈 字符串 👍 3228 👎 0

*/
//Java：有效的括号
class ValidParentheses{
    public static void main(String[] args) {
        Solution solution = new ValidParentheses().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            Map<Character, Character> map = new HashMap<>();
            map.put('(', ')');
            map.put('[', ']');
            map.put('{', '}');
            // 栈
            Deque<Character> stack = new LinkedList<>();
            for (int i = 0; i < s.length() ; i++) {
                char ch = s.charAt(i);
                if (map.containsKey(ch)) {
                    stack.push(ch);
                } else {
                    if (i == 0) {
                        return false;
                    }
                    if (stack.isEmpty() || map.get(stack.pop()) != ch) {
                        return false;
                    }
                }
            }
            if (!stack.isEmpty()) {
                return false;
            }
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
