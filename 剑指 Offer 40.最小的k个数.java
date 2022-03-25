package leetcode.editor.cn;

//输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [3,2,1], k = 2
//输出：[1,2] 或者 [2,1]
// 
//
// 示例 2： 
//
// 输入：arr = [0,1,2,1], k = 1
//输出：[0] 
//
// 
//
// 限制： 
//
// 
// 0 <= k <= arr.length <= 10000 
// 0 <= arr[i] <= 10000 
// 
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 402 👎 0

//Java：最小的k个数
class ZuiXiaoDeKgeShuLcof{
    public static void main(String[] args) {
        Solution solution = new ZuiXiaoDeKgeShuLcof().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] getLeastNumbers(int[] arr, int k) {
            quickSort(arr, 0, arr.length-1, k);
            int[] res = new int[k];
            for (int i = 0; i < k; i++) {
                res[i] = arr[i];
            }
            return res;
        }

        void quickSort(int[] nums, int l ,int r, int k) {
            if (l>=r) {
                return;
            }
            int t = partition(nums,l,r);
            if (t == k-1) {
                return;
            }
            if (t < k-1) {
                quickSort(nums,t+1, r, k);
            }
            quickSort(nums, l, t-1, k);
        }

        int partition(int[] nums, int l, int r) {
            // 在闭区间 [l, r] 随机选取任意索引，并与 nums[l] 交换
            int ra = (int)(l + Math.random() * (r - l + 1));
            swap(nums, l, ra);
            // base nums[l]
            int i = l;
            int j = r;
            while(i<j) {
                while(i<j&&nums[j]>=nums[l]) {
                    j--;
                }
                while(i<j&&nums[i]<=nums[l]) {
                    i++;
                }
                swap(nums,i,j);
            }
            swap(nums,i,l);
            return i;
        }

        void swap(int[] nums, int i, int j){
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
