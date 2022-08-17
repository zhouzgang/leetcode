package dp;

import java.util.Arrays;

/**
 * 322. 零钱兑换
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * 你可以认为每种硬币的数量是无限的。
 *
 *示例 1：
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 *
 * 示例 2：
 * 输入：coins = [2], amount = 3
 * 输出：-1
 *
 * 示例 3：
 * 输入：coins = [1], amount = 0
 * 输出：0
 *
 * 链接：https://leetcode.cn/problems/coin-change
 * @author brian.zhou
 * @date 6/26/22
 */
public class CoinChange {


    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(coinChange(new int[]{2}, 3));
        System.out.println(coinChange(new int[]{1}, 0));
    }

    public static int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, -999);
        return dp(coins, amount, memo);
    }

    public static int dp(int[] coins, int amount , int[] memo) {
        if (amount == 0) {
            return 0;
        }
        // 这里可以用负数来处理，而不是使用数组下标。
        if (amount < 0) {
            return -1;
        }

        if (memo[amount] != -999) {
            return memo[amount];
        }
        // 直接考虑数量，而是不是回溯的那些数额
        int result = Integer.MAX_VALUE;
        for (int coin : coins) {
            int subProblem = dp(coins, amount - coin, memo);
            if (subProblem == -1) {
                continue;
            }
            // 最值问题，可以一个一个去比较
            result = Math.min(result, subProblem + 1);
        }
        memo[amount] = result == Integer.MAX_VALUE ? -1 : result;
        return memo[amount];
    }
}
