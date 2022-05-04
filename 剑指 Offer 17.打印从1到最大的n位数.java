package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。 

 示例 1: 

 输入: n = 1
输出: [1,2,3,4,5,6,7,8,9]
 

 

 说明： 

 
 用返回一个整数列表来代替打印 
 n 为正整数 
 
 Related Topics 数组 数学 👍 222 👎 0

*/
//Java：打印从1到最大的n位数
class DaYinCong1daoZuiDaDeNweiShuLcof{
    public static void main(String[] args) {
        Solution solution = new DaYinCong1daoZuiDaDeNweiShuLcof().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] res;
        int nine = 0, count = 0, start, n; // nine表示9的数量
        char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        public int[] printNumbers(int n) {
            this.n = n;
            res = new int[(int)Math.pow(10, n) - 1];
            num = new char[n];
            start = n - 1;
            dfs(0);
            return res;
        }
        void dfs(int x) {
            if(x == n) {
                // 获取从start开始的子串
                String s = String.valueOf(num).substring(start);
                if(!s.equals("0")) { // 0不打印
                    // 解析为数字加入到结果集中
                    res[count++] = Integer.parseInt(s);
                }
                // 当输出的数字所有位都是9时，需要进一位
                if(n - start == nine) {
                    start--;
                }
                return;
            }
            for(char i : loop) {
                if(i == '9') {
                    nine++;
                }
                num[x] = i;
                dfs(x + 1);
            }
            nine--;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}
