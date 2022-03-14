package leetcode.editor.cn;

//给你一个整数 num 。重排 num 中的各位数字，使其值 最小化 且不含 任何 前导零。 
//
// 返回不含前导零且值最小的重排数字。 
//
// 注意，重排各位数字后，num 的符号不会改变。 
//
// 
//
// 示例 1： 
//
// 输入：num = 310
//输出：103
//解释：310 中各位数字的可行排列有：013、031、103、130、301、310 。
//不含任何前导零且值最小的重排数字是 103 。
// 
//
// 示例 2： 
//
// 输入：num = -7605
//输出：-7650
//解释：-7605 中各位数字的部分可行排列为：-7650、-6705、-5076、-0567。
//不含任何前导零且值最小的重排数字是 -7650 。 
//
// 
//
// 提示： 
//
// 
// -10¹⁵ <= num <= 10¹⁵ 
// 
// Related Topics 数学 排序 👍 5 👎 0

import java.util.Arrays;

//Java：重排数字的最小值
class SmallestValueOfTheRearrangedNumber{
    public static void main(String[] args) {
        Solution solution = new SmallestValueOfTheRearrangedNumber().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long smallestNumber(long num) {
            // 1. 考虑是0的情况
            if(num==0){
                return 0;
            }
            // 2. 考虑负数的情况
            int sign = 1; // 处理正负号
            if(num<0){
                sign = -1;
                num = -num;
            }
            // 获取num的总长度
            int len = String.valueOf(num).length();

            long[] nums = new long[len];
            int i = 0;
            while(num!=0){
                long n = num%10;
                nums[i] = n;
                num /= 10;
                i++;
            }
            // 排序
            Arrays.sort(nums);

            if (sign == -1) {
                // 负数直接倒着输出即可
                long res = 0;
                for (int j = len-1; j>=0; j--) {
                    res = res*10 + nums[j];
                }
                return -res;
            }

            long firstNum = nums[0];
            // 找到第一个不为0的数，和首位互换
            if (firstNum == 0) {
                int k = 1;
                while(nums[k]==0){
                    k++;
                }
                // 互换
                nums[0] = nums[k];
                nums[k] = firstNum;
            }
            // 将数组转换为结果
            long res = 0;
            for (long n:nums) {
                res = res*10 + n;
            }
            return res;

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
