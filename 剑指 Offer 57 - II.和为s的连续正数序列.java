package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。 

 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。 

 

 示例 1： 

 输入：target = 9
输出：[[2,3,4],[4,5]]
 

 示例 2： 

 输入：target = 15
输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 

 

 限制： 

 
 1 <= target <= 10^5 
 

 
 Related Topics 数学 双指针 枚举 👍 406 👎 0

*/
//Java：和为s的连续正数序列
class HeWeiSdeLianXuZhengShuXuLieLcof{
    public static void main(String[] args) {
        Solution solution = new HeWeiSdeLianXuZhengShuXuLieLcof().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] findContinuousSequence(int target) {
            if (target == 1) {
                return new int[][]{{1}};
            }
            int i = 1;
            int sum = 1;
            List<int[]> ans = new ArrayList<>();
            for (int j = 2; j < target; j++) {
                sum += j;
                while (sum > target&&i<j) {
                    sum-=i;
                    i++;
                }
                if (sum == target) {
                    int[] res = new int[j-i+1];
                    for (int k = i; k <= j; k++) {
                        res[k-i] = k;
                    }
                    ans.add(res);
                }

            }
            return ans.toArray(new int[0][]);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
