
public class MonstersValley {
	
	long[] d;
	int[] p;
	final int INF = (int)1e9;
	
	int solve(int i, long sum, int price) {
		if (i == d.length) return price;
		
		if (sum < d[i])
			return solve(i + 1, sum + d[i], price + p[i]);
		
		return Math.min(solve(i + 1, sum, price), solve(i + 1, sum + d[i], price + p[i]));
	}
	
    public int minimumPrice(long[] dread, int[] price) {
        d = dread;
        p = price;
        
        return solve(0, 0, 0);
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(MonstersValley.class, "test.*");
    }

	public void test0() {
		RETester.eq(minimumPrice(new long[] {8L, 5L, 10L}, new int[] {1, 1, 2}), 2);
	}

	public void test1() {
		RETester.eq(minimumPrice(new long[] {1L, 2L, 4L, 1000000000L}, new int[] {1, 1, 1, 2}), 5);
	}

	public void test2() {
		RETester.eq(minimumPrice(new long[] {200L, 107L, 105L, 206L, 307L, 400L}, new int[] {1, 2, 1, 1, 1, 2}), 2);
	}

	public void test3() {
		RETester.eq(minimumPrice(new long[] {5216L, 12512L, 613L, 1256L, 66L, 17202L, 30000L, 23512L, 2125L, 33333L}, new int[] {2, 2, 1, 1, 1, 1, 2, 1, 2, 1}), 5);
	}

// END CUT HERE
}
