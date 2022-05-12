package leetcode.editor.cn;

/**
给定一个正整数，检查它的二进制表示是否总是 0、1 交替出现：换句话说，就是二进制表示中相邻两位的数字永不相同。 

 

 示例 1： 

 
输入：n = 5
输出：true
解释：5 的二进制表示是：101
 

 示例 2： 

 
输入：n = 7
输出：false
解释：7 的二进制表示是：111. 

 示例 3： 

 
输入：n = 11
输出：false
解释：11 的二进制表示是：1011. 

 

 提示： 

 
 1 <= n <= 2³¹ - 1 
 
 Related Topics 位运算 👍 170 👎 0

*/
//Java：交替位二进制数
class BinaryNumberWithAlternatingBits{
    public static void main(String[] args) {
        Solution solution = new BinaryNumberWithAlternatingBits().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean hasAlternatingBits(int n) {
            // 第一位
            int pre = (n&1);
            n >>= 1;
            while(n>0) {
                int next = (n&1);
                if ((next^pre)!=1 ) {
                    return false;
                }
                pre = next;
                n>>=1;
            }
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
