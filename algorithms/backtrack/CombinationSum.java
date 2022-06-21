package backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 39. 组合总和
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。 
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 *
 * 示例 1：
 * 输入：candidates = [2,3,6,7], target = 7
 * 输出：[[2,2,3],[7]]
 * 解释：
 * 2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
 * 7 也是一个候选， 7 = 7 。
 * 仅有这两种组合。
 *
 * 示例 2：
 * 输入: candidates = [2,3,5], target = 8
 * 输出: [[2,2,2,2],[2,3,3],[3,5]]
 *
 * 示例 3：
 * 输入: candidates = [2], target = 1
 * 输出: []
 *  
 * 提示：
 * 1 <= candidates.length <= 30
 * 1 <= candidates[i] <= 200
 * candidate 中的每个元素都 互不相同
 * 1 <= target <= 500
 *
 * 链接：https://leetcode.cn/problems/combination-sum
 * @author brian.zhou
 * @date 6/20/22
 */
public class CombinationSum {

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2,3,6,7}, 7));
        System.out.println(combinationSum(new int[]{2,3,5}, 8));
        System.out.println(combinationSum(new int[]{2}, 1));
    }

    /*
     * 回溯，推进列表为整个列表，判断条件为相加之和满足条件，On2
     * 元素无重可复选
     * 可以不可以先做一次排序，再做回溯来降低时间复杂度，要不要考虑重复组合
     */
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backTrack(result, new LinkedList<>(), candidates, target, 0);
        return result;
    }

    public static void backTrack(List<List<Integer>> result, LinkedList<Integer> group, int[] candidates, int target, int start) {
        // 递归推出条件
        int sum = group.stream().mapToInt(Integer::intValue).sum();
        if (sum >= target) {
            if (sum == target) {
                result.add(new ArrayList<>(group));
            }
            return;
        }
        // 回溯
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] <= target - sum) {
                group.add(candidates[i]);
                backTrack(result, group, candidates, target, i);
                group.removeLast();
            }
        }
    }
}
