package leetcode.editor.cn;

//你和一群强盗准备打劫银行。给你一个下标从 0 开始的整数数组 security ，其中 security[i] 是第 i 天执勤警卫的数量。日子从 0 开始
//编号。同时给你一个整数 time 。 
//
// 如果第 i 天满足以下所有条件，我们称它为一个适合打劫银行的日子： 
//
// 
// 第 i 天前和后都分别至少有 time 天。 
// 第 i 天前连续 time 天警卫数目都是非递增的。 
// 第 i 天后连续 time 天警卫数目都是非递减的。 
// 
//
// 更正式的，第 i 天是一个合适打劫银行的日子当且仅当：security[i - time] >= security[i - time + 1] >= ..
//. >= security[i] <= ... <= security[i + time - 1] <= security[i + time]. 
//
// 请你返回一个数组，包含 所有 适合打劫银行的日子（下标从 0 开始）。返回的日子可以 任意 顺序排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：security = [5,3,3,3,5,6,2], time = 2
//输出：[2,3]
//解释：
//第 2 天，我们有 security[0] >= security[1] >= security[2] <= security[3] <= 
//security[4] 。
//第 3 天，我们有 security[1] >= security[2] >= security[3] <= security[4] <= 
//security[5] 。
//没有其他日子符合这个条件，所以日子 2 和 3 是适合打劫银行的日子。
// 
//
// 示例 2： 
//
// 
//输入：security = [1,1,1,1,1], time = 0
//输出：[0,1,2,3,4]
//解释：
//因为 time 等于 0 ，所以每一天都是适合打劫银行的日子，所以返回每一天。
// 
//
// 示例 3： 
//
// 
//输入：security = [1,2,3,4,5,6], time = 2
//输出：[]
//解释：
//没有任何一天的前 2 天警卫数目是非递增的。
//所以没有适合打劫银行的日子，返回空数组。
// 
//
// 示例 4： 
//
// 
//输入：security = [1], time = 5
//输出：[]
//解释：
//没有日子前面和后面有 5 天时间。
//所以没有适合打劫银行的日子，返回空数组。 
//
// 
//
// 提示： 
//
// 
// 1 <= security.length <= 10⁵ 
// 0 <= security[i], time <= 10⁵ 
// 
// Related Topics 数组 动态规划 前缀和 👍 72 👎 0

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Supplier;

//Java：适合打劫银行的日子
public class FindGoodDaysToRobTheBank{
    public static void main(String[] args) {
        Solution solution = new FindGoodDaysToRobTheBank().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> goodDaysToRobBank(int[] security, int time) {
            List<Integer> res = new ArrayList<>();
            // time=0
            if (time == 0) {
                for(int i= 0;i<security.length;i++){
                    res.add(i);
                }
                return res;
            }
            // 天数不足
            if(security.length<(time*2+1)){
                return res;
            }
            int i = 1; // 遍历数组

            int beforeDays = 0;
            int afterDays = 0;
            while(i+time<security.length){

                if (security[i-1]>=security[i]) { // 非递增
                    beforeDays ++;
                } else {
                    beforeDays = 0;
                }
                if (security[i+time-1] <= security[i+time]) {
                    afterDays ++;
                } else {
                    afterDays = 0;
                }
                if (beforeDays>=time && afterDays >= time) {
                    res.add(i);
                }
                i++;

            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
