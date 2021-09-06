import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 存在重复元素
 * 给定一个整数数组，判断是否存在重复元素。
 * 如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 *
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x248f5/
 *
 * @author brian.zhou
 * @date 2021/9/6
 */
public class ContainsDuplicate {

    public static void main(String[] args) {
        int[] t1 = {1, 2, 3, 1};
        System.out.println(true == solution(t1));
        System.out.println(true == solution1(t1));

        int[] t2 = {1,2,3,4};
        System.out.println(false == solution(t2));
        System.out.println(false == solution1(t2));

        int[] t3 = {1,1,1,3,3,4,3,2,4,2};
        System.out.println(true == solution(t3));
        System.out.println(true == solution1(t3));
    }

    public static boolean solution(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0, length = nums.length; i < length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }

    /**
     * 使用工具类排序，O(N*logN) 居然比 O(n) 要好
     * @param nums
     * @return
     */
    public static  boolean solution1(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1, length = nums.length; i < length; i++) {
            if (nums[i - 1] == nums[i]) {
                return true;
            }
        }
        return false;
    }
}
