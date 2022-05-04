package leetcode.editor.cn;

/**
我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。 

 

 示例: 

 输入: n = 10
输出: 12
解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。 

 说明: 

 
 1 是丑数。 
 n 不超过1690。 
 

 注意：本题与主站 264 题相同：https://leetcode-cn.com/problems/ugly-number-ii/ 
 Related Topics 哈希表 数学 动态规划 堆（优先队列） 👍 333 👎 0

*/
//Java：丑数
class ChouShuLcof{
    public static void main(String[] args) {
        Solution solution = new ChouShuLcof().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int nthUglyNumber(int n) {
            int[] dp = new int[n+1];
            dp[1] = 1;
            int a = 1, b = 1, c = 1;
            for (int i = 2; i < n+1; i++) {
                dp[i] = Math.min(Math.min(dp[a]*2, dp[b]*3), dp[c]*5);
                if (dp[i] == dp[a]*2) {
                    a++;
                }
                if (dp[i] == dp[b]*3) {
                    b++;
                }
                if (dp[i] == dp[c]*5) {
                    c++;
                }
            }
            return dp[n];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
