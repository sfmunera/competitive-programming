import java.util.*;

public class MafiaGame {
	public double probabilityToLose(int N, int[] decisions) {
		double res;
		return res;
	}

// BEGIN CUT HERE
	public static void main(String[] args) {
		RETester.test(MafiaGame.class, "test.*");
	}

	public void test0() {
		RETester.eq(probabilityToLose(3, new int[] {1, 1, 1}), 1.0);
	}

	public void test1() {
		RETester.eq(probabilityToLose(5, new int[] {1, 2, 3}), 0.0);
	}

	public void test2() {
		RETester.eq(probabilityToLose(20, new int[] {1, 2, 3, 4, 5, 6, 7, 1, 2, 3, 4, 5, 6, 7, 18, 19, 0}), 0.0);
	}

	public void test3() {
		RETester.eq(probabilityToLose(23, new int[] {17, 10, 3, 14, 22, 5, 11, 10, 22, 3, 14, 5, 11, 17}), 0.14285714285714285);
	}

// END CUT HERE
}
