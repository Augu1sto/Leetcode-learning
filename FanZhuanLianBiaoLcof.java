package leetcode.editor.cn;

//定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。 
//
// 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 5000 
//
// 
//
// 注意：本题与主站 206 题相同：https://leetcode-cn.com/problems/reverse-linked-list/ 
// Related Topics 递归 链表 👍 386 👎 0

import java.util.Deque;
import java.util.LinkedList;

//Java：反转链表
public class FanZhuanLianBiaoLcof{
    public static void main(String[] args) {
        Solution solution = new FanZhuanLianBiaoLcof().new Solution();
        // TO TEST
    }
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
        public ListNode reverseList(ListNode head) {
            if(head==null) {
                return null;
            }
            ListNode curr = null;
            ListNode res = new ListNode(head.val);
            while(head!=null){
                res = new ListNode(head.val);
                res.next = curr;
                curr = res;
                head = head.next;
            }
            return res;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
