import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 两个数组的交集 II
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 进阶：
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 *
 *
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2y0c2/
 * @author brian.zhou
 * @date 2021/9/6
 */
public class Intersect {


    public static Integer[] solutionV1(int[] nums1, int[] nums2) {
        Set<Integer> temp = new HashSet<>();
        Set set = Stream.of(nums2).collect(Collectors.toSet());
        for (int n: nums1){
            if (set.contains(n)) {
                temp.add(n);
            }
        }
        Integer[] i = new Integer[temp.size()];
        return temp.toArray(i);
    }

    public static int[] solutionV2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int l1 = nums1.length, l2 = nums2.length, i = 0, j = 0;
        while (i < l1 && j < l2) {

        }

        return null;
    }
}
