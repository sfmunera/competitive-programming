
public class CompositeSmash {
	
	boolean solve(int N, int target) {
		if (N == target) return true;

		boolean ok = true;
		boolean isPrime = true;
		for (int p = 2; p * p <= N; ++p) {
			boolean ok2 = false;
			if (N % p == 0) {
				isPrime = false;
				ok2 |= solve(p, target);
				if (p != N / p)
					ok2 |= solve(N / p, target);
				ok &= ok2;
			}
		}
		return ok && !isPrime;
	}
	
    public String thePossible(int N, int target) {
        return solve(N, target) ? "Yes" : "No";
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(CompositeSmash.class, "test.*");
    }

	public void test0() {
		RETester.eq(thePossible(517, 47), "Yes");
	}

	public void test1() {
		RETester.eq(thePossible(8, 4), "Yes");
	}

	public void test2() {
		RETester.eq(thePossible(12, 6), "No");
	}

	public void test3() {
		RETester.eq(thePossible(5, 8), "No");
	}

	public void test4() {
		RETester.eq(thePossible(100000, 100000), "Yes");
	}

	public void test5() {
		RETester.eq(thePossible(5858, 2), "Yes");
	}

	public void test6() {
		RETester.eq(thePossible(81461, 2809), "No");
	}

	public void test7() {
		RETester.eq(thePossible(65536, 256), "No");
	}

// END CUT HERE
}
