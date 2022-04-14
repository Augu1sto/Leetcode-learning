package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。 

 示例: 

 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
输出: [3,3,5,5,6,7] 
解释: 

  滑动窗口的位置                最大值
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7 

 

 提示： 

 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。 

 注意：本题与主站 239 题相同：https://leetcode-cn.com/problems/sliding-window-maximum/ 
 Related Topics 队列 滑动窗口 单调队列 堆（优先队列） 👍 424 👎 0

*/
//Java：滑动窗口的最大值
class HuaDongChuangKouDeZuiDaZhiLcof{
    public static void main(String[] args) {
        Solution solution = new HuaDongChuangKouDeZuiDaZhiLcof().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int i = 0;
            int len = nums.length;
            if (len == 0) {
                return new int[]{};
            }
            if (len < k) {
                return new int[]{0};
            }
            // 保持递减，及新加入的元素要更小
            Deque<Integer> que = new LinkedList<>();
            int[] res = new int[len - k + 1];
            int t = 0;

            for (int j = 0; j < len; j++) {
                int n = nums[j];
                while (!que.isEmpty() && que.peekLast() < n) {
                    que.removeLast();
                }
                que.addLast(n);
                if (j - i + 1 == k) {
                    int max = que.peekFirst();
                    res[t] = max;
                    t++;
                    // 如果nums[i]还在队里，则移除
                    if (nums[i] == max) {
                        que.removeFirst();
                    }
                    i++;
                }
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
