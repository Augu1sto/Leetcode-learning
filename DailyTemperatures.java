package leetcode.editor.cn;

//给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指在第 i 天之后，才会有更高的温度
//。如果气温在这之后都不会升高，请在该位置用 0 来代替。 
//
// 
//
// 示例 1: 
//
// 
//输入: temperatures = [73,74,75,71,69,72,76,73]
//输出: [1,1,4,2,1,1,0,0]
// 
//
// 示例 2: 
//
// 
//输入: temperatures = [30,40,50,60]
//输出: [1,1,1,0]
// 
//
// 示例 3: 
//
// 
//输入: temperatures = [30,60,90]
//输出: [1,1,0] 
//
// 
//
// 提示： 
//
// 
// 1 <= temperatures.length <= 10⁵ 
// 30 <= temperatures[i] <= 100 
// 
// Related Topics 栈 数组 单调栈 👍 1047 👎 0

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

//Java：每日温度
public class DailyTemperatures{
    public static void main(String[] args) {
        Solution solution = new DailyTemperatures().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            Deque<Integer> stack = new LinkedList<>();
            int[] ans = new int[temperatures.length];
            for (int i = 0; i < temperatures.length; i++) {
                if (stack.isEmpty()) {
                    stack.push(i);
                }else{
                    int temp = temperatures[i];
                    int top = stack.peek();
                    // 不断和栈顶元素比较，直到不比栈顶元素大
                    while (temp > temperatures[top]) {
                        top = stack.pop();
                        ans[top] = i-top;
                        // 如果栈空，也跳出循环
                        if (stack.isEmpty()) {
                            break;
                        }
                        top = stack.peek();
                    }
                    stack.push(i);
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
