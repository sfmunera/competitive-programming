import java.util.*;

public class TheBrickTowerHardDivTwo {
    public int find(int C, int K, int H) {
        int res;
        return res;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(TheBrickTowerHardDivTwo.class, "test.*");
    }

	public void test0() {
		RETester.eq(find(2, 0, 2), 4);
	}

	public void test1() {
		RETester.eq(find(1, 7, 19), 1);
	}

	public void test2() {
		RETester.eq(find(2, 3, 1), 14);
	}

	public void test3() {
		RETester.eq(find(4, 7, 47), 1008981254);
	}

// END CUT HERE
}
