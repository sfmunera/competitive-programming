
public class TheAlmostLuckyNumbersDivOne {
	
	long solve(long a, long b, long cur, boolean flag) {
		long ans = 0;
		if (cur > b)
			return 0;
		if (cur >= a)
			++ans;
		
		for (int i = 0; i < 10; ++i) {
			if (cur == 0 && i == 0) continue;
			if (i != 4 && i != 7 && !flag)
				ans += solve(a, b, cur * 10 + i, true);
			if (i == 4 || i == 7)
				ans += solve(a, b, cur * 10 + i, flag);
		}
		
		return ans;
	}
	
    public long find(long a, long b) {
        return solve(a, b, 0, false);
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(TheAlmostLuckyNumbersDivOne.class, "test.*");
    }

	public void test0() {
		RETester.eq(find(4L, 7L), 4L);
	}

	public void test1() {
		RETester.eq(find(8L, 19L), 4L);
	}

	public void test2() {
		RETester.eq(find(28L, 33L), 0L);
	}

	public void test3() {
		RETester.eq(find(12345678900L, 98765432100L), 91136L);
	}

// END CUT HERE
}
