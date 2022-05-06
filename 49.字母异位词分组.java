package leetcode.editor.cn;

import java.util.*;

/**
给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。 

 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。 

 

 示例 1: 

 
输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
输出: [["bat"],["nat","tan"],["ate","eat","tea"]] 

 示例 2: 

 
输入: strs = [""]
输出: [[""]]
 

 示例 3: 

 
输入: strs = ["a"]
输出: [["a"]] 

 

 提示： 

 
 1 <= strs.length <= 10⁴ 
 0 <= strs[i].length <= 100 
 strs[i] 仅包含小写字母 
 
 Related Topics 哈希表 字符串 排序 👍 1125 👎 0

*/
//Java：字母异位词分组
class GroupAnagrams{
    public static void main(String[] args) {
        Solution solution = new GroupAnagrams().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> map = new HashMap<>();
            for (String str:strs) {
                String sorted_str = sortedStr(str);
                if (!map.containsKey(sorted_str)) {
                    map.put(sorted_str, new ArrayList<>());
                }
                map.get(sorted_str).add(str);
            }
            List<List<String>> res = new ArrayList<>(map.values());
//            for (Map.Entry<String, List<String>> entry:map.entrySet()) {
//                res.add(entry.getValue());
//            }
            return res;
        }

        String sortedStr(String str) {
            char[] arrayCh = str.toCharArray();
            Arrays.sort(arrayCh);
            return Arrays.toString(arrayCh);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
