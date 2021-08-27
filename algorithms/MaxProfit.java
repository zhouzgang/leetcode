/**
 * 122. 买卖股票的最佳时机 II
 * 给定一个数组 prices ，其中 prices[i] 是一支给定股票第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
 *
 * @author brian.zhou
 * @date 2021/8/25
 */
public class MaxProfit {

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int result = solution(prices);
        System.out.println(result);
    }

    public static int solution(int[] prices) {
        int result = 0;
        for (int i = 1, length = prices.length; i < length; i++) {
            if (prices[i - 1] < prices[i]) {
                result += prices[i] - prices[i - 1];
            }
        }
        return result;
    }
}
