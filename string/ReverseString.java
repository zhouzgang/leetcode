import com.sun.tools.javac.util.StringUtils;

/**
 * 反转字符串
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 *
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnhbqj/
 * @author brian.zhou
 * @date 2021/10/26
 */
public class ReverseString {

    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        solution(s);
        System.out.println(s);
    }

    public static void solution(char[] s) {
        char c;
        for (int i = 0, l = s.length / 2; i < l; i++) {
            c = s[i];
            s[i] = s[s.length - i - 1];
            s[s.length - i - 1] = c;
        }
    }
}
