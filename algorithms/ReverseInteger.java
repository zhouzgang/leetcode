/**
 * @author brian.zhou
 * @date 2021/8/12
 */
public class ReverseInteger {

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(calculate(123));
        System.out.println(calculate(-123));
        System.out.println(calculate(120));
        System.out.println(calculate(0));
        System.out.println(calculate(Integer.MAX_VALUE));
        System.out.println(calculate(Integer.MIN_VALUE));
        System.out.println(calculate(2143847412));
        System.out.println(calculate(147483647));
        System.out.println(calculate(2143847412));
        System.out.println(calculate(1534236469));
    }

    public static int calculate(int x) {
        int result = 0;
        while (x != 0) {
            if (result > Integer.MAX_VALUE / 10 || result < Integer.MIN_VALUE / 10) {
                return 0;
            }
            result = x % 10 + result * 10;
            x = x / 10;
        };
        return result;
    }
}
