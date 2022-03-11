package leetcode.editor.cn;

//给你一棵根节点为 0 的 二叉树 ，它总共有 n 个节点，节点编号为 0 到 n - 1 。同时给你一个下标从 0 开始的整数数组 parents 表示这棵
//树，其中 parents[i] 是节点 i 的父节点。由于节点 0 是根，所以 parents[0] == -1 。 
//
// 一个子树的 大小 为这个子树内节点的数目。每个节点都有一个与之关联的 分数 。求出某个节点分数的方法是，将这个节点和与它相连的边全部 删除 ，剩余部分是若
//干个 非空 子树，这个节点的 分数 为所有这些子树 大小的乘积 。 
//
// 请你返回有 最高得分 节点的 数目 。 
//
// 
//
// 示例 1: 
//
// 
//
// 输入：parents = [-1,2,0,2,0]
//输出：3
//解释：
//- 节点 0 的分数为：3 * 1 = 3
//- 节点 1 的分数为：4 = 4
//- 节点 2 的分数为：1 * 1 * 2 = 2
//- 节点 3 的分数为：4 = 4
//- 节点 4 的分数为：4 = 4
//最高得分为 4 ，有三个节点得分为 4 （分别是节点 1，3 和 4 ）。
// 
//
// 示例 2： 
//
// 
//
// 输入：parents = [-1,2,0]
//输出：2
//解释：
//- 节点 0 的分数为：2 = 2
//- 节点 1 的分数为：2 = 2
//- 节点 2 的分数为：1 * 1 = 1
//最高分数为 2 ，有两个节点分数为 2 （分别为节点 0 和 1 ）。
// 
//
// 
//
// 提示： 
//
// 
// n == parents.length 
// 2 <= n <= 10⁵ 
// parents[0] == -1 
// 对于 i != 0 ，有 0 <= parents[i] <= n - 1 
// parents 表示一棵二叉树。 
// 
// Related Topics 树 深度优先搜索 数组 二叉树 👍 121 👎 0

import java.util.*;

//Java：统计最高分的节点数目
class CountNodesWithTheHighestScore{
    public static void main(String[] args) {
        Solution solution = new CountNodesWithTheHighestScore().new Solution();
        // TO TEST
        int res = solution.countHighestScoreNodes(new int[]{-1,2,0,2,0});
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Node{
        Node parent;
        List<Node> children = new ArrayList<>();
        long size; // 存储node和孩子的个数
        int val;
        Node(){
        }
        Node(int _val){
            val = _val;
        }

        void addChild(Node node){
            children.add(node);
        }

        long getSize(){ // 返回这个树的全部节点个数
            if (size != 0L) { // 如果size不为0，证明size已经被赋值了
                return size;
            }
            long res = 0L;
            for (Node node:children) {
                if (node.size == 0L) {
                    res+=node.getSize();
                } else {
                    res+=node.size;
                }
            }
            size = res+1L;
            return res+1L;
        }

        long getScore(){
            long res = 1L;
            for (Node node:children) {
                res *= node.getSize();
            }
            return res;
        }
    }
    class Solution {
        Map<Integer, Node> nodeMap = new HashMap<>();

        public int countHighestScoreNodes(int[] parents) {
            long maxScore = 0L;
            int cnt = 0;
            Node root = buildTree(parents);
            for (int i = 0; i < parents.length; i++) {
                Node node = nodeMap.get(i);
                long sc = getScore(node, parents.length);
                if (sc > maxScore) {
                    maxScore = sc;
                    cnt = 1;
                } else if(sc==maxScore){
                    cnt++;
                }
            }
            return cnt;
        }

        Node buildTree(int[] parents){
            // 根节点一定是0
            Node root = new Node(0);
            nodeMap.put(0,root);
            for (int i = 1; i < parents.length; i++) {
                // 如果没有就new一个
                Node node = nodeMap.getOrDefault(i,new Node(i));
                nodeMap.put(i,node);
                Node parent = nodeMap.getOrDefault(parents[i], new Node(parents[i]));
                nodeMap.put(parents[i],parent);
                node.parent = parent; // 设置node的parent节点
                parent.addChild(node); // parent节点增加孩子节点
            }
            return root;
        }

        long getScore(Node node, int n){
            long res = 1;
            if (node.val==0) { // 如果是根节点
                return node.getScore();
            }
            return node.getScore()*(n-node.getSize());
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
