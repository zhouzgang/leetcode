import javax.swing.plaf.IconUIResource;
import java.util.Arrays;

/**
 * 26.删除有序数组中的重复项
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 *
 * 记录：
 * 看题要仔细，最后的输出，是由判题根据长度打印出来的。
 *
 * @author brian.zhou
 * @date 2021/8/23
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] nums = {1, 2};
        int length = solution(nums);
        System.out.println(length);
        System.out.println(Arrays.toString(nums));
    }

    public static int solution(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int position = 0;
        for (int i = 0, length = nums.length; i < length; i++) {
            if (nums[i] != nums[position]) {
                position++;
                nums[position] = nums[i];
            }
        }

        return ++position;
    }
}
