/**
 * 求解斐波拉契数列
 * 递归的暴力解法 -> 带备忘录的递归解法 -> 非递归的动态规划解法
 *
 * @author brian.zhou
 * @date 2022/1/20
 */
public class Fib {


    /**
     * 暴力求解
     *
     * @param n
     * @return
     */
    public int fibV1(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return fibV1(n - 1) + fibV1(n - 2);
    }

    public int fibV2(int n) {
        return 0;
    }
}
