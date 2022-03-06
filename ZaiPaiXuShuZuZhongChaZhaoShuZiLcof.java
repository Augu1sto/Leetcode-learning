package leetcode.editor.cn;

//统计一个数字在排序数组中出现的次数。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [5,7,7,8,8,10], target = 8
//输出: 2 
//
// 示例 2: 
//
// 
//输入: nums = [5,7,7,8,8,10], target = 6
//输出: 0 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// nums 是一个非递减数组 
// -10⁹ <= target <= 10⁹ 
// 
//
// 
//
// 注意：本题与主站 34 题相同（仅返回值不同）：https://leetcode-cn.com/problems/find-first-and-last-
//position-of-element-in-sorted-array/ 
// Related Topics 数组 二分查找 👍 276 👎 0

//Java：在排序数组中查找数字 I
public class ZaiPaiXuShuZuZhongChaZhaoShuZiLcof{
    public static void main(String[] args) {
        Solution solution = new ZaiPaiXuShuZuZhongChaZhaoShuZiLcof().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int search(int[] nums, int target) {
            return binSearch(nums, target, 0, nums.length) - binSearch(nums, target-1, 0, nums.length);
        }

        public int binSearch(int[] nums, int target, int left, int right){
            if (left >= right) {
                return left;
            }

            int mid = (right+left)>>1;
            if (nums[mid] <= target ) { // 找到第一个target+1
                return binSearch(nums, target, mid+1, right);
            }else {
                return binSearch(nums, target, left, mid);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
