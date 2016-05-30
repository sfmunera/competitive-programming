package topcoder;

import java.util.*;

public class DivisorsPower {
	
	int numDiv(long x) {
		int cnt = 1;
		for (int p = 2; p * p <= x; ++p) {
			int c = 0;
			while (x % p == 0) {
				++cnt;
				x /= p;
			}
			cnt *= c + 1;
		}
		
		if (x > 1)
			cnt *= 2;
		
		return cnt;
	}
	
    public long findArgument(long n) {

    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(DivisorsPower.class, "test.*");
    }

	public void test0() {
		RETester.eq(findArgument(4L), 2L);
	}

	public void test1() {
		RETester.eq(findArgument(10L), -1L);
	}

	public void test2() {
		RETester.eq(findArgument(64L), 4L);
	}

	public void test3() {
		RETester.eq(findArgument(10000L), 10L);
	}

	public void test4() {
		RETester.eq(findArgument(2498388559757689L), 49983883L);
	}

// END CUT HERE
}
