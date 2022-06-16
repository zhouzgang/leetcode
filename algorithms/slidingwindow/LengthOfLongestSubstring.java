package slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *  
 * 示例 1:
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 示例 2:
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 示例 3:
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * @author brian.zhou
 * @date 6/7/22
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
//        System.out.println(lengthOfLongestSubstring("bbbbb"));
//        System.out.println(lengthOfLongestSubstring("pwwkew"));
//        System.out.println(lengthOfLongestSubstring(" "));

//        Map<Character, Integer> window = new HashMap();
//        System.out.println(window.put(' ', window.getOrDefault(' ', 0) + 1));
//        System.out.println(window.put(' ', window.getOrDefault(' ', 0) + 1));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        Map<Character, Integer> window = new HashMap();
        char[] sChar = s.toCharArray();
        int left = 0, right = 0;

        int subStrLen = 0;
        while (right < sChar.length) {
            char c = sChar[right];
            right++;

            System.out.println(String.format("window: [%d, %d)", left, right));

            while (window.put(c, window.getOrDefault(c, 0) + 1) == null) {
                if (right - left > subStrLen) {
                    subStrLen = right - left - 1;
                }
                char d = sChar[left];
                left++;
                window.remove(d);
            }
        }

        return subStrLen;
    }
}
