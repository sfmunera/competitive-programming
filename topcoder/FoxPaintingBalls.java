import java.util.*;

public class FoxPaintingBalls {
    public long theMax(long R, long G, long B, int N) {
        long res;
        return res;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(FoxPaintingBalls.class, "test.*");
    }

	public void test0() {
		RETester.eq(theMax(2L, 2L, 2L, 3), 1L);
	}

	public void test1() {
		RETester.eq(theMax(1L, 2L, 3L, 3), 0L);
	}

	public void test2() {
		RETester.eq(theMax(8L, 6L, 6L, 4), 2L);
	}

	public void test3() {
		RETester.eq(theMax(7L, 6L, 7L, 4), 2L);
	}

	public void test4() {
		RETester.eq(theMax(100L, 100L, 100L, 4), 30L);
	}

	public void test5() {
		RETester.eq(theMax(19330428391852493L, 48815737582834113L, 11451481019198930L, 3456), 5750952686L);
	}

	public void test6() {
		RETester.eq(theMax(1L, 1L, 1L, 1), 3L);
	}

// END CUT HERE
}
