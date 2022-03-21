package leetcode.editor.cn;

//地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一
//格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但
//它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？ 
//
// 
//
// 示例 1： 
//
// 输入：m = 2, n = 3, k = 1
//输出：3
// 
//
// 示例 2： 
//
// 输入：m = 3, n = 1, k = 0
//输出：1
// 
//
// 提示： 
//
// 
// 1 <= n,m <= 100 
// 0 <= k <= 20 
// 
// Related Topics 深度优先搜索 广度优先搜索 动态规划 👍 472 👎 0

//Java：机器人的运动范围
class JiQiRenDeYunDongFanWeiLcof{
    public static void main(String[] args) {
        Solution solution = new JiQiRenDeYunDongFanWeiLcof().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        boolean[][] visited;
        boolean[][] valid;
        int cnt = 0;
        int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        public int movingCount(int m, int n, int k) {
            visited = new boolean[m][n];
            valid = new boolean[m][n];
            // 判断每个格子的行列坐标数位之和是否大于k
            for (int i = 0; i < m ; i++) {
                for (int j = 0; j < n ; j++) {
                    if (getSum(i)+getSum(j) > k) {
                        valid[i][j] = false;
                    } else {
                        valid[i][j] = true;
                    }
                }
            }
            // DFS遍历每个路径
            dfs(m, n, 0, 0);
            return cnt;
        }

        void dfs(int m, int n, int i, int j) {
            if (i<0 || i>=m || j<0 || j>=n || (!valid[i][j]) || visited[i][j]) {
                return;
            }
            visited[i][j] = true;
            cnt++;
            for(int[] d : directions) {
                int new_i = i + d[0];
                int new_j = j + d[1];
                dfs(m,n,new_i,new_j);
            }
        }


        int getSum(int num) {
            int sum = 0;
            while (num!=0) {
                sum += (num%10);
                num /= 10;
            }
            return sum;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}
