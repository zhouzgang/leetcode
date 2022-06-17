package backtrack;

import java.util.*;

/**
 * 46. 全排列
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 * 示例 2：
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 *
 * 示例 3：
 * 输入：nums = [1]
 * 输出：[[1]]
 *
 * 链接：https://leetcode.cn/problems/permutations
 * @author brian.zhou
 * @date 6/17/22
 */
public class Permute {

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1, 2, 3}));
        System.out.println(permute(new int[]{0, 1}));
        System.out.println(permute(new int[]{1}));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backTrack(result, new LinkedList<>(), nums, new boolean[nums.length]);
        return result;
    }

    public static void backTrack(List<List<Integer>> result, LinkedList<Integer> group, int[] nums, boolean[] used) {
        if (nums.length == group.size()) {
            // 这里浅拷贝
            List<Integer> list = new LinkedList<>(group);
            result.add(list);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            group.add(nums[i]);
            used[i] = true;
            backTrack(result, group, nums, used);
            group.removeLast();
            used[i] = false;
        }
    }
}
