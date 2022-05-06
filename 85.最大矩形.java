package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

/**
给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。 

 

 示例 1： 

 
输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],[
"1","0","0","1","0"]]
输出：6
解释：最大矩形如上图所示。
 

 示例 2： 

 
输入：matrix = []
输出：0
 

 示例 3： 

 
输入：matrix = [["0"]]
输出：0
 

 示例 4： 

 
输入：matrix = [["1"]]
输出：1
 

 示例 5： 

 
输入：matrix = [["0","0"]]
输出：0
 

 

 提示： 

 
 rows == matrix.length 
 cols == matrix[0].length 
 1 <= row, cols <= 200 
 matrix[i][j] 为 '0' 或 '1' 
 
 Related Topics 栈 数组 动态规划 矩阵 单调栈 👍 1259 👎 0

*/
//Java：最大矩形
class MaximalRectangle{
    public static void main(String[] args) {
        Solution solution = new MaximalRectangle().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximalRectangle(char[][] matrix) {
            int ans = 0;
            int m = matrix.length;
            int n = matrix[0].length;
            int[][] D = new int[m][n];
            for (int i = 0; i < n; i++) {
                D[0][i] = matrix[0][i]-'0';
            }
            for (int i = 0; i < m; i++) {
                int[] left = new int[n];
                int[] right = new int[n];
                Deque<Integer> stack = new LinkedList<>();
                for (int j = 0; j < n; j++) {
                    if (i!=0) {
                        if (matrix[i][j] == '0') {
                            D[i][j] = 0;
                        } else {
                            D[i][j] = D[i-1][j] + 1;
                        }
                    }

                    while(!stack.isEmpty() && D[i][j] <= D[i][stack.peek()]) {
                        // 执行一次pop操作
                        int top = stack.pop();
                        right[top] = j;
                    }
                    left[j] = stack.isEmpty() ? -1 : stack.peek();
                    stack.push(j);
                }
                while (!stack.isEmpty()) {
                    int top = stack.pop();
                    right[top] = n;
                }
                for (int j = 0; j < n; j++) {
                    ans = Math.max(ans, (right[j]-left[j]-1)*D[i][j]);
                }

            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
