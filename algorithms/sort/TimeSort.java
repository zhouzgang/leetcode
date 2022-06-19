package sort;

import java.text.ParseException;
import java.util.Arrays;

/**
 * 运维工程师采集到某产品线网运行一天产生的日志n条，现需根据日志时间先后顺序对日志进行排序
 *   日志时间格式为H:M:S.N
 *   H表示小时(0~23)
 *   M表示分钟(0~59)
 *   S表示秒(0~59)
 *   N表示毫秒(0~999)
 *   时间可能并没有补全，也就是说
 *   01:01:01.001也可能表示为1:1:1.1
 *
 *   输入描述
 *      第一行输入一个整数n表示日志条数
 *      1<=n<=100000
 *      接下来n行输入n个时间
 *
 *    输出描述
 *      按时间升序排序之后的时间
 *      如果有两个时间表示的时间相同
 *      则保持输入顺序
 *
 *    示例：
 *      输入：
 *       2
 *       01:41:8.9
 *       1:1:09.211
 *      输出
 *        1:1:09.211
 *        01:41:8.9
 *    示例
 *       输入
 *        3
 *        23:41:08.023
 *        1:1:09.211
 *        08:01:22.0
 *       输出
 *         1:1:09.211
 *         08:01:22.0
 *         23:41:08.023
 *
 *     示例
 *       输入
 *         2
 *         22:41:08.023
 *         22:41:08.23
 *       输出
 *         22:41:08.023
 *         22:41:08.23
 *
 * @author brian.zhou
 * @date 6/17/22
 */
public class TimeSort {

    public static void main(String[] args) {

        String[] timeStrs = new String[]{"01:41:8.9", "1:1:09.211"};
        System.out.println(Arrays.asList(dateSort(timeStrs)));
        timeStrs = new String[]{"23:41:08.023", "1:1:09.211", "08:01:22.0"};
        System.out.println(Arrays.asList(dateSort(timeStrs)));
        timeStrs = new String[]{"22:41:08.023", "22:41:08.23"};
        System.out.println(Arrays.asList(dateSort(timeStrs)));
    }

    public static String[] dateSort(String[] timeStrs) {
        int len = timeStrs.length, preIndex;
        String current;
        for (int i = 0; i < len; i++) {
            preIndex = i - 1;
            current = format(parse(timeStrs[i]));
            while(preIndex >= 0 && !compare(timeStrs[preIndex], current)) {
                timeStrs[preIndex+1] = timeStrs[preIndex];
                preIndex--;
            }
            timeStrs[preIndex+1] = current;
        }
        return timeStrs;
    }

    public static boolean compare(String timeStrA, String timeStrB) {
        int[] timeDataA = parse(timeStrA);
        int[] timeDataB = parse(timeStrB);
        for (int i = 0; i < 4; i++) {
            if (timeDataA[i] != timeDataB[i]) {
                return timeDataA[i] < timeDataB[i];
            }
        }
        return false;
    }

    public static String format(int[] timeData) {
        String hourA = timeData[0] > 9 ? "" + timeData[0] : "0" + timeData[0];
        String minuteA = timeData[1] > 9 ? "" + timeData[1] : "0" + timeData[1];
        String secondA = timeData[2] > 9 ? "" + timeData[2] : "0" + timeData[2];
        String milliA = timeData[3] > 9 ? timeData[3] > 99 ? "" + timeData[3] : "0" + timeData[3] : "00" + timeData[3];
        return hourA + ":" + minuteA + ":" + secondA + "." + milliA;
    }

    public static int[] parse(String timeStr) {
        int[] data = new int[4];
        String[] strs = timeStr.split(":");
        data[0] = Integer.parseInt(strs[0]);
        data[1] = Integer.parseInt(strs[1]);
        String[] strs0 = strs[2].split("\\.");
        data[2] = Integer.parseInt(strs0[0]);
        data[3] = Integer.parseInt(strs0[1]);
        return data;
    }
}
