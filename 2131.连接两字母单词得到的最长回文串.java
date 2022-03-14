package leetcode.editor.cn;

//给你一个字符串数组 words 。words 中每个元素都是一个包含 两个 小写英文字母的单词。 
//
// 请你从 words 中选择一些元素并按 任意顺序 连接它们，并得到一个 尽可能长的回文串 。每个元素 至多 只能使用一次。 
//
// 请你返回你能得到的最长回文串的 长度 。如果没办法得到任何一个回文串，请你返回 0 。 
//
// 回文串 指的是从前往后和从后往前读一样的字符串。 
//
// 
//
// 示例 1： 
//
// 输入：words = ["lc","cl","gg"]
//输出：6
//解释：一个最长的回文串为 "lc" + "gg" + "cl" = "lcggcl" ，长度为 6 。
//"clgglc" 是另一个可以得到的最长回文串。
// 
//
// 示例 2： 
//
// 输入：words = ["ab","ty","yt","lc","cl","ab"]
//输出：8
//解释：最长回文串是 "ty" + "lc" + "cl" + "yt" = "tylcclyt" ，长度为 8 。
//"lcyttycl" 是另一个可以得到的最长回文串。
// 
//
// 示例 3： 
//
// 输入：words = ["cc","ll","xx"]
//输出：2
//解释：最长回文串是 "cc" ，长度为 2 。
//"ll" 是另一个可以得到的最长回文串。"xx" 也是。 
//
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 10⁵ 
// words[i].length == 2 
// words[i] 仅包含小写英文字母。 
// 
// Related Topics 贪心 数组 哈希表 字符串 计数 👍 10 👎 0

import java.util.HashMap;
import java.util.Map;

//Java：连接两字母单词得到的最长回文串
class LongestPalindromeByConcatenatingTwoLetterWords{
    public static void main(String[] args) {
        Solution solution = new LongestPalindromeByConcatenatingTwoLetterWords().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestPalindrome(String[] words) {
            Map<String, Integer> map1 = new HashMap<>();
            Map<String, Integer> map2 = new HashMap<>();
            int len1 = 0;
            for (String word:words) {
                if (word.charAt(0) == word.charAt(1)) {
                    // xx的情况
                    int k = map2.getOrDefault(word,0)+1;
                    map2.put(word, k);
                } else {
                    // xy的情况
                    // 计算yx
                    String reversedWord = String.valueOf(""+word.charAt(1) + word.charAt(0));
                    if (map1.containsKey(reversedWord)) {
                        len1 += 2*2;
                        int k = map1.get(reversedWord)-1;
                        if (k == 0) {
                            map1.remove(reversedWord);
                        } else {
                            map1.put(reversedWord, k);
                        }
                    } else {
                        int k = map1.getOrDefault(word, 0) + 1;
                        map1.put(word, k);
                    }

                }
            }
            // 计算xx产生的长度
            int len2 = 0;
            int flag = 0; // 如果产生了出现了奇数的xx（不管有多少个），将flag置0，最后要加1*2
            for (Map.Entry<String, Integer> wordEntry:map2.entrySet()) {
                if((wordEntry.getValue()&1)==1){
                    flag = 1;
                }
                // %2*2是为了统一奇数的情况
                len2 += wordEntry.getValue()/2*2*2;
            }
            return len1+len2+flag*2;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
