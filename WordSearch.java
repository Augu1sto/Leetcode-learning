package leetcode.editor.cn;

//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"ABCCED"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"SEE"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"ABCB"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n = board[i].length 
// 1 <= m, n <= 6 
// 1 <= word.length <= 15 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 
//
// 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？ 
// Related Topics 数组 回溯 矩阵 👍 1214 👎 0

//Java：单词搜索
public class WordSearch{
    public static void main(String[] args) {
        Solution solution = new WordSearch().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 四个方向
        final int[][] directions = {{0, 1},{0, -1},{1,0},{-1,0}};
        int m,n;
        public boolean exist(char[][] board, String word) {
            m = board.length;
            n = board[0].length;
            boolean[][] visited = new boolean[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    boolean res = backtracking(board, word, i, j, 0, visited); // 先找第一个
                    if (res) {
                        return true;
                    }
                }
            }
            return false;
        }

        public boolean backtracking(char[][] board, String word, int i, int j, int k, boolean[][] visited){
            // i,j 代表网格坐标，k代表遍历到第几个字符

            boolean result = false;
            // 终止条件1：字符串遍历到头
            if (k >= word.length()) {
                return true;
            }
            // 终止条件2：坐标不合法
            if (i<0||i>=m||j<0||j>=n) {
                return false;
            }

            // 终止条件3：当前格子访问过
            if (visited[i][j]) {
                return false;
            }
            // 终止条件4：当前网格不满足题意
            if (word.charAt(k) != board[i][j]) {
                return false;
            } else {
                visited[i][j] = true; // 已访问
                result = true;
            }
            // 遍历各个方向
            for (int[] direction:directions) {
                int new_i = i + direction[0];
                int new_j = j + direction[1];
                result = backtracking(board, word, new_i, new_j, k + 1, visited);
                if (result) {
                    break;
                }
            }
            visited[i][j] = false;
            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
