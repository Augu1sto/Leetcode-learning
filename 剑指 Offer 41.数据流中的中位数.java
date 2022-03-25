package leetcode.editor.cn;

//如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数
//值排序之后中间两个数的平均值。 
//
// 例如， 
//
// [2,3,4] 的中位数是 3 
//
// [2,3] 的中位数是 (2 + 3) / 2 = 2.5 
//
// 设计一个支持以下两种操作的数据结构： 
//
// 
// void addNum(int num) - 从数据流中添加一个整数到数据结构中。 
// double findMedian() - 返回目前所有元素的中位数。 
// 
//
// 示例 1： 
//
// 输入：
//["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]
//[[],[1],[2],[],[3],[]]
//输出：[null,null,null,1.50000,null,2.00000]
// 
//
// 示例 2： 
//
// 输入：
//["MedianFinder","addNum","findMedian","addNum","findMedian"]
//[[],[2],[],[3],[]]
//输出：[null,null,2.00000,null,2.50000] 
//
// 
//
// 限制： 
//
// 
// 最多会对 addNum、findMedian 进行 50000 次调用。 
// 
//
// 注意：本题与主站 295 题相同：https://leetcode-cn.com/problems/find-median-from-data-
//stream/ 
// Related Topics 设计 双指针 数据流 排序 堆（优先队列） 👍 287 👎 0

import java.util.PriorityQueue;
import java.util.Queue;

//Java：数据流中的中位数
class ShuJuLiuZhongDeZhongWeiShuLcof{
    public static void main(String[] args) {
        Solution solution = new ShuJuLiuZhongDeZhongWeiShuLcof().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class MedianFinder {
        Queue<Integer> queA, queB;
        /** initialize your data structure here. */
        public MedianFinder() {
            queA = new PriorityQueue<>(); // 小顶堆，保存较大的一半
            queB = new PriorityQueue<>((o1, o2)->(o2 - o1)); // 大顶堆，保存较小的一半
            // 保持B的长度始终=A或比A小1
        }

        public void addNum(int num) {
            if (queA.size() == queB.size()) {
                // 先加入B，再将B中最大的放入A里，保持两个队列的性质不变
                queB.offer(num);
                queA.offer(queB.poll());
            } else {
                queA.offer(num); // 先加入queA，此时sizeA=sizeB+2
                queB.offer(queA.poll()); // 再将queA中最小的加入queB，此时sizeA=sizeB
            }
        }

        public double findMedian() {
            if (queA.size() == queB.size()) {
                return (double) (queB.peek()+ queA.peek())/2;
            } else {
                return (double) queA.peek();
            }
        }
    }

    /**
     * Your MedianFinder object will be instantiated and called as such:
     * MedianFinder obj = new MedianFinder();
     * obj.addNum(num);
     * double param_2 = obj.findMedian();
     */
    //leetcode submit region end(Prohibit modification and deletion)

}
