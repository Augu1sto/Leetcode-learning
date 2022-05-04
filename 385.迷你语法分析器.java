package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
给定一个字符串 s 表示一个整数嵌套列表，实现一个解析它的语法分析器并返回解析的结果 NestedInteger 。 

 列表中的每个元素只可能是整数或整数嵌套列表 

 

 示例 1： 

 
输入：s = "324",
输出：324
解释：你应该返回一个 NestedInteger 对象，其中只包含整数值 324。
 

 示例 2： 

 
输入：s = "[123,[456,[789]]]",
输出：[123,[456,[789]]]
解释：返回一个 NestedInteger 对象包含一个有两个元素的嵌套列表：
1. 一个 integer 包含值 123
2. 一个包含两个元素的嵌套列表：
    i.  一个 integer 包含值 456
    ii. 一个包含一个元素的嵌套列表
         a. 一个 integer 包含值 789
 

 

 提示： 

 
 1 <= s.length <= 5 * 10⁴ 
 s 由数字、方括号 "[]"、负号 '-' 、逗号 ','组成 
 用例保证 s 是可解析的 NestedInteger 
 输入中的所有值的范围是 [-10⁶, 10⁶] 
 
 Related Topics 栈 深度优先搜索 字符串 👍 142 👎 0

*/
//Java：迷你语法分析器
class MiniParser{
    public static void main(String[] args) {
        Solution solution = new MiniParser().new Solution();
        // TO TEST
    }
    static class NestedInteger {
        public NestedInteger(){}
        public NestedInteger(int value){}
        public boolean isInteger(){return false;}
        public void setInteger(int value){}
        public void add(NestedInteger ni){}
        public List<NestedInteger> getList(){return new ArrayList<>(){};}
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * // This is the interface that allows for creating nested lists.
     * // You should not implement it, or speculate about its implementation
     * public interface NestedInteger {
     *     // Constructor initializes an empty nested list.
     *     public NestedInteger();
     *
     *     // Constructor initializes a single integer.
     *     public NestedInteger(int value);
     *
     *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
     *     public boolean isInteger();
     *
     *     // @return the single integer that this NestedInteger holds, if it holds a single integer
     *     // Return null if this NestedInteger holds a nested list
     *     public Integer getInteger();
     *
     *     // Set this NestedInteger to hold a single integer.
     *     public void setInteger(int value);
     *
     *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
     *     public void add(NestedInteger ni);
     *
     *     // @return the nested list that this NestedInteger holds, if it holds a nested list
     *     // Return empty list if this NestedInteger holds a single integer
     *     public List<NestedInteger> getList();
     * }
     */
    class Solution {
        static NestedInteger startSign = new NestedInteger(0);
        public NestedInteger deserialize(String s) {
            // 栈
            Deque<NestedInteger> stack = new LinkedList<>();
            // 计数
            int i = 0;
            int len = s.length();
            while (i<len) {
                if (s.charAt(i) == ',') {
                    i++;
                    continue;
                }
                // 数值压栈
                if (s.charAt(i) == '-' || (s.charAt(i) - '0' >= 0 && s.charAt(i) - '0' <= 9)) {
                    int sign = 1;
                    if (s.charAt(i) == '-') {
                        sign = -1;
                        i++;
                    }
                    // 循环计算数字
                    int num = 0;
                    while (i<len && (s.charAt(i) - '0' >= 0 && s.charAt(i) - '0' <= 9)) {
                        num = num*10 + (s.charAt(i) - '0');
                        i++;
                    }
                    num *= sign;
                    stack.push(new NestedInteger(num));
                } else if (s.charAt(i) == '[') {
                    stack.push(new NestedInteger());
                    stack.push(startSign);
                    i++;
                } else {
                    Deque<NestedInteger> list = new LinkedList<>();
                    while (!stack.isEmpty()) {
                        NestedInteger p = stack.pop();
                        if (p == startSign) {
                            break;
                        }
                        list.push(p);
                    }
                    while (!list.isEmpty()) {
                        stack.peek().add(list.pop());
                    }
                    i++;
                }
            }
            return stack.peek();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
