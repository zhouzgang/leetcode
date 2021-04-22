import java.util.*;

/**
 * 写一个程序，输出从 1 到 n 数字的字符串表示。
 * 1. 如果 n 是3的倍数，输出“Fizz”；
 * 2. 如果 n 是5的倍数，输出“Buzz”；
 * 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
 *
 * Remark
 * - i + "" leetcode commit, time:7ms, memory:39.7MB  // 加号操作字符串居然这么耗时
 * - String.valueOf(i) leetcode commit, time:1ms, memory:39.5MB
 *
 * @author brian.zhou
 * @date 2021/4/22
 */
public class FizzBuzz {

	public static void main(String[] args) {
		int count = 10000;
		long start = System.currentTimeMillis();
		System.out.println(fizzBuzz(count));
		System.out.println("time: " + (System.currentTimeMillis() - start));

		start = System.currentTimeMillis();
		System.out.println(fizzBuzz01(count));
		System.out.println("time: " + (System.currentTimeMillis() - start));

		start = System.currentTimeMillis();
		System.out.println(fizzBuzz02(count));
		System.out.println("time: " + (System.currentTimeMillis() - start));
	}

	public static List<String> fizzBuzz(int n) {
		List<String> list = new LinkedList<String>();
		for (int i = 1; i <= n; i++) {
			if (i % 5 == 0) {
				if (i % 3 == 0) {
					list.add("FizzBuzz");
				} else {
					list.add("Buzz");
				}
			} else if (i % 3 == 0) {
				list.add("Fizz");
			} else {
				list.add(i + "");
			}
		}
		return list;
	}

	public static List<String> fizzBuzz01(int n) {
		List<String> list = new ArrayList<String>(n);
		for (int i = 1; i <= n; i++) {
			if (i % 15 == 0) {
				list.add("FizzBuzz");
				continue;
			}
			if (i % 5 == 0) {
				list.add("Buzz");
				continue;
			}
			if (i % 3 == 0) {
				list.add("Fizz");
				continue;
			}
			list.add(String.valueOf(i));
		}
		return list;
	}

	public static List<String> fizzBuzz02(int n) {
		String[] strings = new String[n];
		for (int i = 1; i <= n; i++) {
			if (i % 15 == 0) {
				strings[i - 1] = "FizzBuzz";
				continue;
			}
			if (i % 5 == 0) {
				strings[i - 1] = "Buzz";
				continue;
			}
			if (i % 3 == 0) {
				strings[i - 1] = "Fizz";
				continue;
			}
			strings[i - 1] = String.valueOf(i);
		}
		return Arrays.asList(strings);
	}
}
