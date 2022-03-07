package leetcode.editor.cn;

//给定一个整数 num，将其转化为 7 进制，并以字符串形式输出。 
//
// 
//
// 示例 1: 
//
// 
//输入: num = 100
//输出: "202"
// 
//
// 示例 2: 
//
// 
//输入: num = -7
//输出: "-10"
// 
//
// 
//
// 提示： 
//
// 
// -10⁷ <= num <= 10⁷ 
// 
// Related Topics 数学 👍 135 👎 0

import java.lang.reflect.Array;

//Java：七进制数
public class Base7{
    public static void main(String[] args) {
        Solution solution = new Base7().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        StringBuilder res = new StringBuilder();
        public String convertToBase7(int num) {
            if (num == 0) {
                return "0";
            }
            if (num < 0 ) {
                res.append("-");
                num *= -1;
            }
            helper(num);
            return res.toString();
        }

        public void helper(int num){
            int d = num/7;
            int r = num%7;
            if (d == 0) {
                res.append(r);
            }else {
                helper(d);
                res.append(r);
            }

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
