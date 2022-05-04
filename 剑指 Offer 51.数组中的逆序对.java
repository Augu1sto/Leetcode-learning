package leetcode.editor.cn;

/**
在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。 

 

 示例 1: 

 输入: [7,5,6,4]
输出: 5 

 

 限制： 

 0 <= 数组长度 <= 50000 
 Related Topics 树状数组 线段树 数组 二分查找 分治 有序集合 归并排序 👍 725 👎 0

*/
//Java：数组中的逆序对
class ShuZuZhongDeNiXuDuiLcof{
    public static void main(String[] args) {
        Solution solution = new ShuZuZhongDeNiXuDuiLcof().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] nums, tmp;
        public int reversePairs(int[] nums) {
            this.nums = nums;
            tmp = new int[nums.length];
            return mergeSort(0, nums.length - 1);
        }

        public int mergeSort(int start, int end) {
            if (start >= end) {
                return 0;
            }
            // 递归划分
            int mid = (start + end) / 2;
            int res = mergeSort(start, mid) + mergeSort(mid+1, end);
            // 合并
            // 创建新的临时数组
//            int[] tmp = new int[nums.length];
            for (int k = start; k <= end; k++) {
                tmp[k] = nums[k];
            }
            int i = start, j = mid+1 ;
            for (int k = start; k <= end; k++) {
                if (i == mid+1) { // 左边半段已经添加完了
                    nums[k] = tmp[j++]; // 把右边剩下的都加进去
                } else if (j == end+1 || tmp[i] <= tmp[j]) { // 右边半段添加完了 或者 是正序的情况
                    nums[k] = tmp[i++]; // 加入左边的
                } else { // 即右边的比左边小，构成逆序的情况
                    nums[k] = tmp[j++];
                    res += mid - i + 1; // 统计逆序对（因为是排好序的，所以i~m部分均比j的大）
                }
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
