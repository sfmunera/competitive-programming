
public class OrderedNim {
	
	int[] layout;
	Boolean[][] dp;
	
	boolean canWin(int index, boolean takeAll) {
		if (index == layout.length)
			return false;
		
		if (dp[index][takeAll ? 1 : 0] != null)
			return dp[index][takeAll ? 1 : 0];
		
		if (takeAll) {
			if (!canWin(index + 1, true) && !canWin(index + 1, false))
				return dp[index][takeAll ? 1 : 0] = true;
		} else {
			if (layout[index] > 1)
				if (!canWin(index, true))
					return dp[index][takeAll ? 1 : 0] = true;
		}
		return dp[index][takeAll ? 1 : 0] = false;
	}
	
    public String winner(int[] _layout) {
        layout = _layout;
        
        dp = new Boolean[layout.length  + 1][2];
        return canWin(0, true) || canWin(0, false) ? "Alice" : "Bob";
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(OrderedNim.class, "test.*");
    }

	public void test0() {
		RETester.eq(winner(new int[] {5}), "Alice");
	}

	public void test1() {
		RETester.eq(winner(new int[] {1,2}), "Bob");
	}

	public void test2() {
		RETester.eq(winner(new int[] {2,1}), "Alice");
	}

	public void test3() {
		RETester.eq(winner(new int[] {10,9,8,7,6,5,4,3,2,1}), "Alice");
	}

	public void test4() {
		RETester.eq(winner(new int[] {1,1,1,1}), "Bob");
	}

// END CUT HERE
}
