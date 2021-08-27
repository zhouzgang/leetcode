import java.util.Arrays;

/**
 * 88. 合并两个有序数组
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 *
 * @author brian.zhou
 * @date 2021/8/24
 */
public class MergeOrderArrays {

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0}, nums2 = {2,5,6};
        int m = 3, n = 3;
        solution(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

    public static void solution(int[] num1, int m, int[] num2, int n) {
        if (num1.length == 0 || num2.length == 0) {
            return;
        }
        for (int i = num1.length - 1; i >= 0; i--) {
            if (num1[m-1] > num2[n-1]) {
                num1[i] = num1[--m];
            } else {
                num1[i] = num2[--n];
            }
        }
    }
}
