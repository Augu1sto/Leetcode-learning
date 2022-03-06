package leetcode.editor.cn;

//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。 
//
// 
//
// 示例 1： 
//
// 输入：head = [1,3,2]
//输出：[2,3,1] 
//
// 
//
// 限制： 
//
// 0 <= 链表长度 <= 10000 
// Related Topics 栈 递归 链表 双指针 👍 251 👎 0

import java.util.Deque;
import java.util.LinkedList;

//Java：从尾到头打印链表
public class CongWeiDaoTouDaYinLianBiaoLcof{
    public static void main(String[] args) {
        Solution solution = new CongWeiDaoTouDaYinLianBiaoLcof().new Solution();
        // TO TEST
    }

//     * Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    
    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public int[] reversePrint(ListNode head) {
            if (head == null) {
                return new int[]{};
            }
            ListNode curr = head;

            int n = 0;
            Deque<Integer> stack = new LinkedList<>();
            while(curr!=null){
                stack.push(curr.val);
                curr=curr.next;
                n++;
            }
            int[] res = new int[n];
            for (int i = 0; i < n; i++) {
                res[i] = stack.pop();
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
