package leetcode.editor.cn;

//给你一个长桌子，桌子上盘子和蜡烛排成一列。给你一个下标从 0 开始的字符串 s ，它只包含字符 '*' 和 '|' ，其中 '*' 表示一个 盘子 ，'|
//' 表示一支 蜡烛 。 
//
// 同时给你一个下标从 0 开始的二维整数数组 queries ，其中 queries[i] = [lefti, righti] 表示 子字符串 s[
//lefti...righti] （包含左右端点的字符）。对于每个查询，你需要找到 子字符串中 在 两支蜡烛之间 的盘子的 数目 。如果一个盘子在 子字符串中 左边和右边
// 都 至少有一支蜡烛，那么这个盘子满足在 两支蜡烛之间 。 
//
// 
// 比方说，s = "||**||**|*" ，查询 [3, 8] ，表示的是子字符串 "*||**|" 。子字符串中在两支蜡烛之间的盘子数目为 2 ，子字符
//串中右边两个盘子在它们左边和右边 都 至少有一支蜡烛。 
// 
//
// 请你返回一个整数数组 answer ，其中 answer[i] 是第 i 个查询的答案。 
//
// 
//
// 示例 1: 
//
// 
//
// 输入：s = "**|**|***|", queries = [[2,5],[5,9]]
//输出：[2,3]
//解释：
//- queries[0] 有两个盘子在蜡烛之间。
//- queries[1] 有三个盘子在蜡烛之间。
// 
//
// 示例 2: 
//
// 
//
// 输入：s = "***|**|*****|**||**|*", queries = [[1,17],[4,5],[14,17],[5,11],[15,16
//]]
//输出：[9,0,0,0,0]
//解释：
//- queries[0] 有 9 个盘子在蜡烛之间。
//- 另一个查询没有盘子在蜡烛之间。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= s.length <= 10⁵ 
// s 只包含字符 '*' 和 '|' 。 
// 1 <= queries.length <= 10⁵ 
// queries[i].length == 2 
// 0 <= lefti <= righti < s.length 
// 
// Related Topics 数组 字符串 二分查找 前缀和 👍 61 👎 0

//Java：蜡烛之间的盘子
public class PlatesBetweenCandles{
    public static void main(String[] args) {
        Solution solution = new PlatesBetweenCandles().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] platesBetweenCandles(String s, int[][] queries) {
            int queryEntries = queries.length; // 一共有几条查询
            int[] res = new int[queryEntries]; // 存放结果
            int n = s.length();
            int[] presum = new int[n];
            int[] lefts = new int[n]; // 记录距离i最近的蜡烛的坐标（往右数）
            int[] rights = new int[n]; // 记录距离j最近的蜡烛的坐标（往左数）
            int num = 0;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '*') { // 如果是盘子
                    num++; // 盘子数量++
                    rights[i] = i==0?-1:rights[i-1]; // 左边最靠近的蜡烛坐标不变（dp）
                }else{
                    rights[i] = i; //如果是蜡烛，更新蜡烛坐标
                }
                presum[i] = num;
            }

            for (int i = n-1; i >=0 ; i--) {
                if (s.charAt(i) == '*') { // 如果是盘子
                    lefts[i] = i==n-1?-1:lefts[i+1]; // 右边最靠近的蜡烛坐标不变
                } else {
                    lefts[i] = i;
                }
            }

            for (int i = 0; i < queryEntries; i++) {
                int[] entry = queries[i];
                int left = lefts[entry[0]]; // 左边第一个蜡烛
                int right = rights[entry[1]]; // 右边第一个蜡烛
                // 考虑三种找不到蜡烛的情况
                if (left == -1 || right == -1 ||left>=right) {
                    res[i] = 0;
                } else {
                    res[i] = presum[right] - presum[left];
                }

            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
