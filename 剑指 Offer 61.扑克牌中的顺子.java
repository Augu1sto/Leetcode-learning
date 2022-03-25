package leetcode.editor.cn;

//从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，
//可以看成任意数字。A 不能视为 14。 
//
// 
//
// 示例 1: 
//
// 
//输入: [1,2,3,4,5]
//输出: True 
//
// 
//
// 示例 2: 
//
// 
//输入: [0,0,1,2,5]
//输出: True 
//
// 
//
// 限制： 
//
// 数组长度为 5 
//
// 数组的数取值为 [0, 13] . 
// Related Topics 数组 排序 👍 218 👎 0

import java.util.Arrays;

//Java：扑克牌中的顺子
class BuKePaiZhongDeShunZiLcof{
    public static void main(String[] args) {
        Solution solution = new BuKePaiZhongDeShunZiLcof().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isStraight(int[] nums) {
            Arrays.sort(nums);
            int i = 0;
            int cntZero = 0;
            while(nums[i]==0&&i<5){
                cntZero++;
                i++;
            }
            // 如果有5或4张0，则一定可以组成顺子
            if (i == 5|| i==4) {
                return true;
            }
            while( i < 4 ){
                if (cntZero < 0) {
                    return false;
                }
                // 如果两个连续的数相等，则不能组成顺子
                if (nums[i] == nums[i+1]) {
                    return false;
                }
                // d为需要用0填充的间隔
                int d = nums[i+1] - nums[i] - 1;
                cntZero -= d;
                i++;
            }
            // 最后还要再判断一次，因为有可能是因为i>=4跳出的循环
            if (cntZero < 0) {
                return false;
            }
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
