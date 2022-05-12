package leetcode.editor.cn;

/**
请实现一个函数用来匹配包含'. '和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。在本题中，匹配是指
字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。 

 示例 1: 

 输入:
s = "aa"
p = "a"
输出: false
解释: "a" 无法匹配 "aa" 整个字符串。
 

 示例 2: 

 输入:
s = "aa"
p = "a*"
输出: true
解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 

 示例 3: 

 输入:
s = "ab"
p = ".*"
输出: true
解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 

 示例 4: 

 输入:
s = "aab"
p = "c*a*b"
输出: true
解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 

 示例 5: 

 输入:
s = "mississippi"
p = "mis*is*p*."
输出: false 

 
 s 可能为空，且只包含从 a-z 的小写字母。 
 p 可能为空，且只包含从 a-z 的小写字母以及字符 . 和 *，无连续的 '*'。 
 

 注意：本题与主站 10 题相同：https://leetcode-cn.com/problems/regular-expression-matching/ 
 Related Topics 递归 字符串 动态规划 👍 373 👎 0

*/
//Java：正则表达式匹配
class ZhengZeBiaoDaShiPiPeiLcof{
    public static void main(String[] args) {
        Solution solution = new ZhengZeBiaoDaShiPiPeiLcof().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isMatch(String s, String p) {
            boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
//            初始化
            dp[0][0] = true;
            for (int j = 2; j <= p.length(); j+=2) {
                dp[0][j] = (dp[0][j-2] && p.charAt(j-1)=='*');
            }
//            状态转移
            for (int i = 1; i <= s.length() ; i++) {
                dp[i][0] = false;
                for (int j = 1; j <= p.length(); j++) {
                    dp[i][j] = p.charAt(j-1)=='*' ?
                            dp[i][j-2] || (s.charAt(i-1)==p.charAt(j-2)&&dp[i-1][j]) || (p.charAt(j-2)=='.'&&dp[i-1][j]) :
                            (p.charAt(j-1)=='.'&&dp[i-1][j-1]) || (p.charAt(j-1)==s.charAt(i-1)&&dp[i-1][j-1]);
                }
            }
            return dp[s.length()][p.length()];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
