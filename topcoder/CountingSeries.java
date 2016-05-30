import java.util.*;

public class CountingSeries {
    public long countThem(long a, long b, long c, long d, long upperBound) {
        long res;
        return res;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(CountingSeries.class, "test.*");
    }

	public void test0() {
		RETester.eq(countThem(1L, 1L, 1L, 2L, 1000L), 1000L);
	}

	public void test1() {
		RETester.eq(countThem(3L, 3L, 1L, 2L, 1000L), 343L);
	}

	public void test2() {
		RETester.eq(countThem(40L, 77L, 40L, 100000L, 40L), 1L);
	}

	public void test3() {
		RETester.eq(countThem(452L, 24L, 4L, 5L, 600L), 10L);
	}

	public void test4() {
		RETester.eq(countThem(234L, 24L, 377L, 1L, 10000L), 408L);
	}

// END CUT HERE
}
