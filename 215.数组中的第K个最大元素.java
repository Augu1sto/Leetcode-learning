package leetcode.editor.cn;

//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。 
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 
//
// 示例 1: 
//
// 
//输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 
//输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 1524 👎 0

import java.util.PriorityQueue;
import java.util.Queue;

//Java：数组中的第K个最大元素
class KthLargestElementInAnArray{
    public static void main(String[] args) {
        Solution solution = new KthLargestElementInAnArray().new Solution();
        // TO TEST
        int res = solution.findKthLargest(new int[]{3,2,1,5,6,4},2);
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            quickSort(nums, 0, nums.length - 1, k);
            return nums[k-1];
        }
        void swap(int[] nums, int i, int j){
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        int partition(int[] nums, int l, int r){
            // 随机选择基准数优化
            int ra = (int)(l + Math.random() * (r - l + 1));
            swap(nums, l, ra);
            // 基准nums[l]
            int i = l;
            int j = r;
            while (i<j){
                // 从右往左找第一个大于nums[l]的数
                while(i<j && nums[j] <= nums[l]){
                    j--;
                }
                // 从左往右找第一个小于nums[l]的数
                while(i<j && nums[i]>=nums[l]){
                    i++;
                }
                swap(nums, i, j);
            }
            // 最后i==j在中间临界处
            swap(nums, i, l);
            return i; // 返回临界点
        }

        void quickSort(int[] nums, int l, int r, int k){
            if (l >= r ) {
                return;
            }
            int t = partition(nums, l, r);
            if (t > k) { // 说明前k个一定在左边, 不用排右边的了
                quickSort(nums, l, t-1, k);
            } else {
                quickSort(nums, l, t-1, k);
                quickSort(nums, t+1, r, k);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
