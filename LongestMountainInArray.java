package leetcode.editor.cn;

//把符合下列属性的数组 arr 称为 山脉数组 ： 
//
// 
// arr.length >= 3 
// 存在下标 i（0 < i < arr.length - 1），满足
// 
// arr[0] < arr[1] < ... < arr[i - 1] < arr[i] 
// arr[i] > arr[i + 1] > ... > arr[arr.length - 1] 
// 
// 
// 
//
// 给出一个整数数组 arr，返回最长山脉子数组的长度。如果不存在山脉子数组，返回 0 。 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [2,1,4,7,3,2,5]
//输出：5
//解释：最长的山脉子数组是 [1,4,7,3,2]，长度为 5。
// 
//
// 示例 2： 
//
// 
//输入：arr = [2,2,2]
//输出：0
//解释：不存在山脉子数组。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 10⁴ 
// 0 <= arr[i] <= 10⁴ 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以仅用一趟扫描解决此问题吗？ 
// 你可以用 O(1) 空间解决此问题吗？ 
// 
// Related Topics 数组 双指针 动态规划 枚举 👍 222 👎 0

//Java：数组中的最长山脉
public class LongestMountainInArray{
    public static void main(String[] args) {
        Solution solution = new LongestMountainInArray().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestMountain(int[] arr) {
            int res = 0; // 不存在则返回0
            int n = arr.length;
            int left = 0;
            while(left+2<n){
                if (arr[left] < arr[left+1]) { // 左山脚
                    int right = left+1; // 右山脚起始
                    while (right < n-1 && arr[right] < arr[right+1]) { // 上山
                        right++;
                    }
                    if (right < n-1 && arr[right] > arr[right+1] ) { // 到达山顶
                        while (right < n-1 && arr[right] > arr[right+1] ) { // 下山
                            right++;
                        }
                        res = Math.max(res,right-left+1);
                    }
                    left = right;

                }else{
                    left++;
                }
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
