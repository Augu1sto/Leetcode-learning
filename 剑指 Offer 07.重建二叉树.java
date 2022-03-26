package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。 

 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。 

 

 示例 1: 

 
Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]
 

 示例 2: 

 
Input: preorder = [-1], inorder = [-1]
Output: [-1]
 

 

 限制： 

 0 <= 节点个数 <= 5000 

 

 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-
preorder-and-inorder-traversal/ 
 Related Topics 树 数组 哈希表 分治 二叉树 👍 729 👎 0

*/
//Java：重建二叉树
class ZhongJianErChaShuLcof{
    public static void main(String[] args) {
        Solution solution = new ZhongJianErChaShuLcof().new Solution();
        // TO TEST
    }
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
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
        Map<Integer, Integer> map = new HashMap<>();
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            int i=0;
            for (int value:inorder) {
                map.put(value,i);
                i++;
            }
            TreeNode root = helper(preorder, 0, inorder, 0, preorder.length-1);
            return root;
        }
        TreeNode helper(int[] preorder, int root, int[] inorder, int start, int end) {
            if (root > end) {
                return null;
            }
            TreeNode node = new TreeNode(preorder[root]);

            int p = map.get(preorder[root]); // 中序遍历中根节点的位置，据此划分左子树和右子树
            int leftLen = p - start;
            int left = root+1;
            int right = left+leftLen;
            node.left = helper(preorder, left, inorder, start, right-1);
            node.right = helper(preorder, right, inorder, start+leftLen+1, end);
            return node;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
