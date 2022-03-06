package leetcode.editor.cn;

//请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。 
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
//  [20,9],
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
// Related Topics 树 广度优先搜索 二叉树 👍 185 👎 0

import java.util.*;

//Java：从上到下打印二叉树 III
public class CongShangDaoXiaDaYinErChaShuIiiLcof{
    public static void main(String[] args) {
        Solution solution = new CongShangDaoXiaDaYinErChaShuIiiLcof().new Solution();
        // TO TEST
    }
    public class TreeNode {
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
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) {
                return res;
            }
            Queue<TreeNode> que = new LinkedList<>(); // 按层的顺序存放节点
            int isOdd = 1; // 判断是不是单数层，单双数层入栈方向相反
            que.offer(root);
            while(!que.isEmpty()){
                LinkedList<Integer> itemList = new LinkedList<>(); // 存放每一层的节点
                int len = que.size(); // 遍历队列中元素
                while(len > 0){
                    TreeNode curNode = que.poll(); // 拿出本层的节点
                    if (isOdd == 1) {
                        itemList.add(curNode.val); // 正序加入结果
                    } else {
                        itemList.addFirst(curNode.val);
                    }
                    if (curNode.left != null) {
                        que.offer(curNode.left);
                    }
                    if (curNode.right != null) {
                        que.offer(curNode.right);
                    }
                    len -- ;
                }
                res.add(itemList);
                isOdd ^= 1; // 一层处理结束，1变0，0变1
            }

            return res;

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
