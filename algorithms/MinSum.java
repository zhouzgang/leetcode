import com.sun.tools.javac.util.Assert;

/**
 * 输入字符串 s，输出 s 中包含所有整数的最小和
 * 1. 字符串只包含 az, AZ, -, +, 0-9
 *
 *
 * @author brian.zhou
 * @date 6/16/22
 */
public class MinSum {

    public static void main(String[] args) {
        System.out.println(minSum("bb1234aa"));
        Assert.check(minSum("bb1234aa") == 10);
        System.out.println(minSum("bb12-34aa"));
        Assert.check(minSum("bb12-34aa") == -31);
        System.out.println(minSum("12-34aa"));
        Assert.check(minSum("12-34aa") == -31);
        System.out.println(minSum("12"));
        Assert.check(minSum("12") == 3);
        System.out.println(minSum("-34"));
        Assert.check(minSum("-34") == -34);
        System.out.println(minSum("-34a12"));
        Assert.check(minSum("-34a12") == -31);
        System.out.println(minSum(""));
        Assert.check(minSum("") == 0);
        System.out.println(minSum("-0034a012"));
        Assert.check(minSum("-034a12") == -31);
    }

    public static long minSum(String s) {
        char[] sChar = s.toCharArray();
        int digit = 0;
        long result = 0, minus = 0;
        for (int i = 0; i < sChar.length; i++) {
            if (sChar[i] >= '0' && sChar[i] <= '9') {
                if (digit == 0) {
                    result += Character.getNumericValue(sChar[i]);
                } else {
                    minus = (minus * digit) - Character.getNumericValue(sChar[i]);
                    if (sChar[i] > '0')
                        digit *= 10;
                }
            }
            if (sChar[i] == '-') {
                digit = 1;
            }
            if (sChar[i] > '9') {
                digit = 0;
            }
        }
        return result + minus;
    }
}
