package dp;

/**
 * 509. 斐波那契数
 * 斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 *
 * F(0) = 0，F(1) = 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 * 给定 n ，请计算 F(n) 。
 *
 * 求解斐波拉契数列
 * 递归的暴力解法 -> 带备忘录的递归解法 -> 非递归的动态规划解法
 *
 * @author brian.zhou
 * @date 2022/1/20
 */
public class Fib {

    public static void main(String[] args) {
        System.out.println(fibV1(2));
        System.out.println(fibV1(3));
        System.out.println(fibV1(4));
        System.out.println(fibV2(2));
        System.out.println(fibV2(3));
        System.out.println(fibV2(4));
        System.out.println(fibV3(2));
        System.out.println(fibV3(3));
        System.out.println(fibV3(4));
    }

    /**
     * 暴力求解
     *
     * @param n
     * @return
     */
    public static int fibV1(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibV1(n - 1) + fibV1(n - 2);
    }

    // 自顶向下
    public static int fibV2(int n) {
        int[] arr = new int[n + 1];
        return helper(arr, n);
    }

    public static int helper(int[] arr, int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (arr[n] != 0) {
            return arr[n];
        }
        arr[n] = helper(arr, n - 1) + helper(arr, n - 2);
        return arr[n];
    }

    // 自底向上
    public static int fibV3(int n) {
        int[] arr = new int[n+1];
        // 主要单个返回，与是否有统一的返回。
        if (n >= 0) {
            arr[0] = 0;
        }
        if (n >= 1) {
            arr[1] = 1;
        }
        for (int i = 2; i < arr.length; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }
}
