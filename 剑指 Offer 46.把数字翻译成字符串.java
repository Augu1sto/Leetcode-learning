package leetcode.editor.cn;

//给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可
//能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。 
//
// 
//
// 示例 1: 
//
// 输入: 12258
//输出: 5
//解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi" 
//
// 
//
// 提示： 
//
// 
// 0 <= num < 2³¹ 
// 
// Related Topics 字符串 动态规划 👍 386 👎 0

//Java：把数字翻译成字符串
class BaShuZiFanYiChengZiFuChuanLcof{
    public static void main(String[] args) {
        Solution solution = new BaShuZiFanYiChengZiFuChuanLcof().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int translateNum(int num) {
            char[] nums = Integer.toString(num).toCharArray();
            int n = nums.length;
            int dp0 = 1; // 无数字，初始化为1(从第2位推一下)
            int dp1 = 1; // 一个数字，初始化为1
            int res = 1; // 结果
            for (int i = 1; i < n; i++) {
                int a = nums[i-1] - '0';
                int b = nums[i] - '0';
                if (a!=0&&(a*10+b)<=25) { // 前两个数字可以被翻译
                    res = dp0 + dp1;
                } else {
                    res = dp1;
                }
                dp0 = dp1;
                dp1 = res;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
