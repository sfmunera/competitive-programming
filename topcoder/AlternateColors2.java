import java.util.*;

public class AlternateColors2 {
    public long countWays(int n, int k) {
        long res;
        return res;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(AlternateColors2.class, "test.*");
    }

	public void test0() {
		RETester.eq(countWays(1, 1), 1L);
	}

	public void test1() {
		RETester.eq(countWays(3, 3), 3L);
	}

	public void test2() {
		RETester.eq(countWays(6, 4), 9L);
	}

	public void test3() {
		RETester.eq(countWays(6, 1), 21L);
	}

	public void test4() {
		RETester.eq(countWays(1000, 2), 1L);
	}

	public void test5() {
		RETester.eq(countWays(100000, 100000), 1666700000L);
	}

// END CUT HERE
}
