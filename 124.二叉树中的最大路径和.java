package leetcode.editor.cn;

//路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不
//一定经过根节点。 
//
// 路径和 是路径中各节点值的总和。 
//
// 给你一个二叉树的根节点 root ，返回其 最大路径和 。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,3]
//输出：6
//解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6 
//
// 示例 2： 
//
// 
//输入：root = [-10,9,20,null,null,15,7]
//输出：42
//解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目范围是 [1, 3 * 10⁴] 
// -1000 <= Node.val <= 1000 
// 
// Related Topics 树 深度优先搜索 动态规划 二叉树 👍 1466 👎 0

//Java：二叉树中的最大路径和
class BinaryTreeMaximumPathSum{
    public static void main(String[] args) {
        Solution solution = new BinaryTreeMaximumPathSum().new Solution();
        // TO TEST
    }


    // Definition for a binary tree node.
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
    class Solution {
        int maxPath = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
            int max = maxSum(root);
            System.out.println(max);
            return maxPath;
        }

        public int maxSum(TreeNode root) {
            // 类比于最大子数组和
            if (root.left == null && root.right==null) {
                maxPath = Math.max(maxPath, root.val);
                return root.val; // 叶子节点直接返回值
            }
            int leftSum = 0;
            int rightSum = 0;
            if (root.left != null) {
                leftSum = maxSum(root.left);
            }
            if (root.right != null) {
                rightSum = maxSum(root.right);
            }
            // max是走直线的路径（即不会出现左叶子-根-右叶子的情况）
            int max = Math.max(Math.max(leftSum,rightSum)+ root.val, root.val);
            // 更新最长路径
            maxPath = Math.max(Math.max(leftSum + rightSum + root.val,max), maxPath);
            return max;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}
