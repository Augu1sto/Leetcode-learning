package leetcode.editor.cn;

/**
输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。 

 

 参考以下这颗二叉搜索树： 

      5
    / \
   2   6
  / \
 1   3 

 示例 1： 

 输入: [1,6,3,2,5]
输出: false 

 示例 2： 

 输入: [1,3,2,6,5]
输出: true 

 

 提示： 

 
 数组长度 <= 1000 
 
 Related Topics 栈 树 二叉搜索树 递归 二叉树 单调栈 👍 473 👎 0

*/
//Java：二叉搜索树的后序遍历序列
class ErChaSouSuoShuDeHouXuBianLiXuLieLcof{
    public static void main(String[] args) {
        Solution solution = new ErChaSouSuoShuDeHouXuBianLiXuLieLcof().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean verifyPostorder(int[] postorder) {
            if (postorder.length == 1) {
                return true;
            }
            return help(postorder, 0, postorder.length-1);
        }
        boolean help(int[] postorder, int start, int root) {
            if (start >= root) {
                return true;
            }
            // 情况一：只有左子树
            if (root>0 && postorder[root-1] < postorder[root]) {
                for (int i = start; i < root; i++) {
                    if (postorder[i] > postorder[root]) {
                        return false;
                    }
                }
                return help(postorder, start, root-1);
            }
            // 情况二：只有右子树
            if (postorder[start] > postorder[root]) {
                for (int i = start; i < root; i++) {
                    if (postorder[i] < postorder[root]) {
                        return false;
                    }
                    return help(postorder, start, root-1);
                }
            }
            // 情况三：左右子树都有
            // 从左到右遍历，第一个大于[root]的就是右子树的开始
            int start_right = root-1;
            for (int i = start; i < root-1; i++) {
                if (postorder[i] > postorder[root]) {
                    start_right = i;
                    break;
                }
            }
            for (int i = start_right; i < root-1; i++) {
                // 如果出现了小于root的值，必是错误
                if (postorder[i] < postorder[root]) {
                    return false;
                }
            }
            // 左子树成立&&右子树成立
            return help(postorder, start, start_right-1) && help(postorder, start_right, root-1);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
