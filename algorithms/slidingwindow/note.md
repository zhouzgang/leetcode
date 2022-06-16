### 滑动窗口
- 3. Longest Substring Without Repeating Characters	3. 无重复字符的最长子串	🟠
- 76. Minimum Window Substring	76. 最小覆盖子串	🔴
- 438. Find All Anagrams in a String	438. 找到字符串中所有字母异位词	🟠
- 567. Permutation in String	567. 字符串的排列	🟠


```java
/* 滑动窗口算法框架 */
void slidingWindow(string s, string t) {
    unordered_map<char, int> need, window;
    for (char c : t) need[c]++;
    
    int left = 0, right = 0;
    int valid = 0; 
    while (right < s.size()) {
        // c 是将移入窗口的字符
        char c = s[right];
        // 增大窗口
        right++;
        // 进行窗口内数据的一系列更新
        ...

        /*** debug 输出的位置 ***/
        printf("window: [%d, %d)\n", left, right);
        /********************/
        
        // 判断左侧窗口是否要收缩
        while (window needs shrink) {
            // d 是将移出窗口的字符
            char d = s[left];
            // 缩小窗口
            left++;
            // 进行窗口内数据的一系列更新
            ...
        }
    }
}
```