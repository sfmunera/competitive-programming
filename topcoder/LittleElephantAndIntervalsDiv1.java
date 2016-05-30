import java.util.*;

public class LittleElephantAndIntervalsDiv1 {
	public long getNumber(int M, int[] L, int[] R) {
		long res;
		return res;
	}

// BEGIN CUT HERE
	public static void main(String[] args) {
		RETester.test(LittleElephantAndIntervalsDiv1.class, "test.*");
	}

	public void test0() {
		RETester.eq(getNumber(4, new int[] {1, 2, 3}, new int[] {1, 2, 3}), 8L);
	}

	public void test1() {
		RETester.eq(getNumber(3, new int[] {1, 1, 2}, new int[] {3, 1, 3}), 4L);
	}

	public void test2() {
		RETester.eq(getNumber(1000, new int[] {47}, new int[] {747}), 2L);
	}

	public void test3() {
		RETester.eq(getNumber(42, new int[] {5, 23, 4, 1, 15, 2, 22, 26, 13, 16, 28, 13, 27, 9, 18, 4, 10, 3, 4, 4, 3, 4, 1, 18, 18, 2, 38, 4, 10, 12, 3, 30, 11, 38, 2, 13, 1, 13, 18, 16, 13, 2, 14, 27, 13, 3, 26, 19, 5, 10}, new int[] {30, 41, 17, 1, 21, 6, 28, 30, 15, 19, 31, 28, 35, 27, 30, 13, 31, 5, 8, 25, 40, 10, 3, 26, 23, 9, 40, 8, 40, 23, 12, 37, 35, 39, 11, 34, 10, 21, 22, 21, 24, 5, 39, 27, 17, 16, 26, 35, 25, 36}), 256L);
	}

// END CUT HERE
}
