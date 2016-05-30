public class LotteryTicket {
	
	boolean solve(int price, int[] b, boolean[] used) {
		if (price < 0) return false;
		if (price == 0) return true;
		
		for (int i = 0; i < b.length; ++i)
			if (!used[i]) {
				used[i] = true;
				if (solve(price - b[i], b, used)) return true;
				used[i] = false;
			}
		return false;
	}
	
    public String buy(int price, int b1, int b2, int b3, int b4) {
        int[] b = {b1, b2, b3, b4};
        boolean[] used = new boolean[4];
        
        return solve(price, b, used) ? "POSSIBLE" : "IMPOSSIBLE";
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(LotteryTicket.class, "test.*");
    }

	public void test0() {
		RETester.eq(buy(10, 1, 5, 10, 50), "POSSIBLE");
	}

	public void test1() {
		RETester.eq(buy(15, 1, 5, 10, 50), "POSSIBLE");
	}

	public void test2() {
		RETester.eq(buy(65, 1, 5, 10, 50), "POSSIBLE");
	}

	public void test3() {
		RETester.eq(buy(66, 1, 5, 10, 50), "POSSIBLE");
	}

	public void test4() {
		RETester.eq(buy(1000, 999, 998, 997, 996), "IMPOSSIBLE");
	}

	public void test5() {
		RETester.eq(buy(20, 5, 5, 5, 5), "POSSIBLE");
	}

	public void test6() {
		RETester.eq(buy(2, 1, 5, 10, 50), "IMPOSSIBLE");
	}

// END CUT HERE
}
