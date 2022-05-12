package leetcode.editor.cn;

/**
请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。 

 数值（按顺序）可以分成以下几个部分： 

 
 若干空格 
 一个 小数 或者 整数 
 （可选）一个 'e' 或 'E' ，后面跟着一个 整数 
 若干空格 
 

 小数（按顺序）可以分成以下几个部分： 

 
 （可选）一个符号字符（'+' 或 '-'） 
 下述格式之一：
 
 至少一位数字，后面跟着一个点 '.' 
 至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字 
 一个点 '.' ，后面跟着至少一位数字 
 
 
 

 整数（按顺序）可以分成以下几个部分： 

 
 （可选）一个符号字符（'+' 或 '-'） 
 至少一位数字 
 

 部分数值列举如下： 

 
 ["+100", "5e2", "-123", "3.1416", "-1E-16", "0123"] 
 

 部分非数值列举如下： 

 
 ["12e", "1a3.14", "1.2.3", "+-5", "12e+5.4"] 
 

 

 示例 1： 

 
输入：s = "0"
输出：true
 

 示例 2： 

 
输入：s = "e"
输出：false
 

 示例 3： 

 
输入：s = "."
输出：false 

 示例 4： 

 
输入：s = "    .1  "
输出：true
 

 

 提示： 

 
 1 <= s.length <= 20 
 s 仅含英文字母（大写和小写），数字（0-9），加号 '+' ，减号 '-' ，空格 ' ' 或者点 '.' 。 
 
 Related Topics 字符串 👍 320 👎 0

*/
//Java：表示数值的字符串
class BiaoShiShuZhiDeZiFuChuanLcof{
    public static void main(String[] args) {
        Solution solution = new BiaoShiShuZhiDeZiFuChuanLcof().new Solution();
        // TO TEST
        Boolean r =  solution.isNumber("-1E-16");
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isNumber(String s) {
            String st = s.trim();
            int len = st.length();
            if (len == 0) {
                return false;
            }
            // 判断开头
            if (!(isNum(st.charAt(0)) || isValidSign(st.charAt(0)))
                    || (isValidSign(st.charAt(0)) && len==1)){
                return false;
            }

//            int cnt_sign = 1;
            int cnt_e = 1;
            int cnt_dot = 1;
            if (st.charAt(0) == '.') {
//                cnt_e = 0;
                cnt_dot = 0;
            }
            // 判断后续
            int i = 1;
            char ch_pre = st.charAt(0);
            while(i<len) {
                char ch = st.charAt(i);
                if (!isNum(ch)) {
                    if ((ch == 'e' || ch == 'E')) {
                        if (cnt_e == 0) {
                            return false;
                        } else if (i == len-1) {
                            return false;
                        } else if ((!isNum(ch_pre)) && ch_pre!='.') {
                            return false;
                        } else if (ch_pre=='.' && i == 1){
                            return false;
                        } else {
                            cnt_e = 0;
                            cnt_dot = 0;
                        }
                    } else if (ch == '+' || ch == '-') {
                        if (ch_pre != 'e' && ch_pre != 'E') {
                            return false;
                        }
                        if (i == len-1) {
                            return false;
                        }
                    } else if (ch == '.') {
                        if ((!isNum(ch_pre))&&i==len-1) {
                            return false;
                        }
                        if (cnt_dot == 0) {
                            return false;
                        } else {
                            cnt_dot = 0;
                        }
                    } else {
                        return false;
                    }
                }
                ch_pre = ch;
                i++;
            }
            return true;
        }

        boolean isNum(char ch) {
            if (ch - '0' >=0 && ch - '0' <=9) {
                return true;
            }
            return false;
        }

        boolean isValidSign(char ch) {
            if (ch == '+') {
                return true;
            }
            if (ch == '-') {
                return true;
            }
            if (ch == '.') {
                return true;
            }
            return false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
