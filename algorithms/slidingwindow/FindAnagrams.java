package slidingwindow;

import java.util.*;

/**
 * 438. 找到字符串中所有字母异位词
 *
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 *
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 *
 * 示例 1:
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 *
 *  示例 2:
 * 输入: s = "abab", p = "ab"
 * 输出: [0,1,2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
 *
 * @author brian.zhou
 * @date 6/9/22
 */
public class FindAnagrams {

    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
        System.out.println(findAnagrams("abab", "ab"));
        System.out.println(findAnagrams("a", "a"));
        System.out.println(findAnagrams("a", "b"));
        System.out.println(findAnagrams(" ", " "));
    }


    /*
#leetcode 438

滑动窗口，固定窗口，判断条件：map 包含并且值为1

#leetcode 567

固定滑动窗口，map 给窗口的key赋值为1，判断条件，所有 key 的值为 1

#leetcode 21

循环两个链表，判断是否都指向空。判断值大小交替指向

#leetcode 19

使用长度为 N 的队列，数值计算，如果是一个超大的链表，如何处理，树
    * */
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> need = new HashMap<>(), window = new HashMap<>();
        char[] sChar = s.toCharArray();
        int left = 0, right = 0;
        int valid = 0, pLen = 0;

        for (char c: p.toCharArray()){
            need.put(c, need.getOrDefault(c, 0) + 1);
            pLen++;
        }

        while (right < sChar.length) {
            char c = sChar[right];
            right++;

            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.getOrDefault(c, 0) < need.get(c))
                    valid++;
            }

            System.out.println(String.format("window: [%d, %s)", left, right));

            while (right - left == pLen) {
                if (valid == pLen) {
                    result.add(left);
                }
                char d = sChar[left];
                if (window.containsKey(d)) {
                    window.put(d, window.getOrDefault(d, 0) - 1);
                    valid--;
                }
                left++;
            }
        }

        return result;
    }
}
