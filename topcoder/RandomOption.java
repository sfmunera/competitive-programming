import java.util.*;

public class RandomOption {
    public double getProbability(int keyCount, int[] badLane1, int[] badLane2) {
        double res;
        return res;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(RandomOption.class, "test.*");
    }

	public void test0() {
		RETester.eq(getProbability(5, new int[] {0}, new int[] {3}), 0.6);
	}

	public void test1() {
		RETester.eq(getProbability(5, new int[] {0, 1, 2}, new int[] {1, 2, 0}), 0.1);
	}

	public void test2() {
		RETester.eq(getProbability(5, new int[] {2, 2, 2, 2}, new int[] {0, 1, 3, 4}), 0.0);
	}

	public void test3() {
		RETester.eq(getProbability(7, new int[] {0, 1, 2}, new int[] {6, 5, 4}), 0.3904761904761904);
	}

	public void test4() {
		RETester.eq(getProbability(7, new int[] {3, 5, 1, 0, 2, 6, 4}, new int[] {0, 2, 4, 6, 1, 5, 3}), 0.09166666666666667);
	}

// END CUT HERE
}
