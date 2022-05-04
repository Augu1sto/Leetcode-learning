package leetcode.editor.cn;

/**
请实现两个函数，分别用来序列化和反序列化二叉树。 

 你需要设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串
反序列化为原始的树结构。 

 提示：输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解
决这个问题。 

 

 示例： 

 
输入：root = [1,2,3,null,null,4,5]
输出：[1,2,3,null,null,4,5]
 

 

 注意：本题与主站 297 题相同：https://leetcode-cn.com/problems/serialize-and-deserialize-
binary-tree/ 
 Related Topics 树 深度优先搜索 广度优先搜索 设计 字符串 二叉树 👍 289 👎 0

*/
//Java：序列化二叉树
class XuLieHuaErChaShuLcof{
    public static void main(String[] args) {
        Solution solution = new XuLieHuaErChaShuLcof().new Solution();
        // TO TEST
    }

    class TreeNode {
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
    public class Codec {
        StringBuilder st = new StringBuilder();

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) {
                return "";
            }
            preOrder(root);
            return st.toString();
        }

        void preOrder(TreeNode root) {
            if (root == null) {
                st.append("Null#");
            } else {
                st.append(Integer.toString(root.val) + "#");
                preOrder(root.left);
                preOrder(root.right);
            }
        }

        // Decodes your encoded data to tree.
        int i = 0;
        public TreeNode deserialize(String data) {
            if (data == "") {
                return null;
            }
            String[] nodes = data.split("#");
            return buildTree(nodes);
        }

        TreeNode buildTree(String[] nodes) {
            if (i == nodes.length - 1) {
                return null; // 非法访问
            }
            if (nodes[i].equals("Null")) {
                i++;
                return null;
            }
            TreeNode node = new TreeNode(Integer.parseInt(nodes[i]));
            i++;
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }
    }

    // Your Codec object will be instantiated and called as such:
    // Codec codec = new Codec();
    // codec.deserialize(codec.serialize(root));
    //leetcode submit region end(Prohibit modification and deletion)

}
