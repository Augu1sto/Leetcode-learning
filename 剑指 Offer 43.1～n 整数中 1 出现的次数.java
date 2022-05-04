package leetcode.editor.cn;

/**
输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。 

 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。 

 

 示例 1： 

 
输入：n = 12
输出：5
 

 示例 2： 

 
输入：n = 13
输出：6 

 

 限制： 

 
 1 <= n < 2^31 
 

 注意：本题与主站 233 题相同：https://leetcode-cn.com/problems/number-of-digit-one/ 
 Related Topics 递归 数学 动态规划 👍 326 👎 0

*/
//Java：1～n 整数中 1 出现的次数
class OneNzhengShuZhong1chuXianDeCiShuLcof{
    public static void main(String[] args) {
        Solution solution = new OneNzhengShuZhong1chuXianDeCiShuLcof().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countDigitOne(int n) {
            int bit = 1; // 标记当前的位数是10的多少次方
            int res = 0;
            int high = n/10, cur = n%10, low = 0;
            while(high != 0 || cur != 0) {
                switch (cur) {
                    case 0:
                        res += high*bit;
                        break;
                    case 1:
                        res += high*bit + 1 + low;
                        break;
                    default:
                        res += (high + 1)*bit;
                }
                low += cur*bit;
                cur = high%10;
                high /= 10;
                bit *= 10;
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
