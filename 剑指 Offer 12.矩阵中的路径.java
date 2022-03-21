package leetcode.editor.cn;

//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。 
//
// 
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
//输入：board = [["a","b"],["c","d"]], word = "abcd"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= board.length <= 200 
// 1 <= board[i].length <= 200 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 
//
// 注意：本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/ 
// Related Topics 数组 回溯 矩阵 👍 551 👎 0

//Java：矩阵中的路径
class JuZhenZhongDeLuJingLcof{
    public static void main(String[] args) {
        Solution solution = new JuZhenZhongDeLuJingLcof().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        boolean[][] visited;
        int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        public boolean exist(char[][] board, String word) {
            int m = board.length;
            int n = board[0].length;
            visited = new boolean[m][n];
            // 找第一个节点
            for (int i = 0; i < m ; i++) {
                for (int j = 0; j < n ; j++) {
                    visited[i][j] = true;
                    boolean flag = backtracking(board, i, j, word, 0);
                    visited[i][j] = false;
                    if (flag) { // 如果flag为真，说明找到了，直接return true
                        return true;
                    }
                }
            }
            return false;
        }

        boolean backtracking(char[][] board, int i, int j, String word, int k){
            if (board[i][j]!=word.charAt(k)) {
                return false;
            }
            if (k == word.length()-1) {
                return true;
            }

            for(int[] d : directions) {
                int new_i = i + d[0];
                int new_j = j + d[1];
                // check新点是否超出边界或者被访问过
                if (new_i < 0 || new_i >= board.length || new_j < 0 || new_j >= board[0].length || visited[new_i][new_j]) {
                    continue;
                }
                visited[new_i][new_j] = true;
                boolean flag = backtracking(board, new_i, new_j, word, k+1);
                visited[new_i][new_j] = false;
                if (flag) {
                    return true;
                }
            }
            return false;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}
