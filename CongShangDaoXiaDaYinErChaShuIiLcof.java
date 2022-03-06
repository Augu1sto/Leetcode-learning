package leetcode.editor.cn;

//从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。 
//
// 
//
// 例如: 
//给定二叉树: [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 1000 
// 
//
// 注意：本题与主站 102 题相同：https://leetcode-cn.com/problems/binary-tree-level-order-
//traversal/ 
// Related Topics 树 广度优先搜索 二叉树 👍 185 👎 0

import java.util.ArrayList;
import java.util.List;

//Java：从上到下打印二叉树 II
public class CongShangDaoXiaDaYinErChaShuIiLcof{
    public static void main(String[] args) {
        Solution solution = new CongShangDaoXiaDaYinErChaShuIiLcof().new Solution();
        // TO TEST
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
    class Solution {
        public List<List<Integer>> res = new ArrayList<>();
        public List<List<Integer>> levelOrder(TreeNode root) {
            helper(root, 0);
            return res;
        }

        public void helper(TreeNode root, int level){
            if (root == null) {
                return;
            }
            if (level > res.size()-1) {
                // 如果是新的一层
                res.add(new ArrayList<>());
            }
            res.get(level).add(root.val);
            if (root.left != null) {
                helper(root.left, level+1);
            }
            if (root.right != null) {
                helper(root.right, level+1);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
