
public class FiveHundredEleven {
	int[] cards;
	boolean[][] seen;
	boolean[][] dp;
	
	boolean canWin(int m, int c) {
		if (c == cards.length) return false;
		if (seen[m][c]) return dp[m][c];
		
		seen[m][c] = true;
		int cnt = 0;
		// Case when there is a non-played card that doesn't change memory
		for (int i = 0; i < cards.length; ++i)
			if ((m | cards[i]) == m)
				++cnt;
		if (cnt > c && !canWin(m, c + 1))
			return dp[m][c] = true;
		// Case with all non-played cards
		for (int i = 0; i < cards.length; ++i)
			if ((m | cards[i]) != 511 && (m | cards[i]) != m)
				if (!canWin(m | cards[i], c + 1))
					return dp[m][c] = true;
		return dp[m][c] = false;
	}
	
    public String theWinner(int[] _cards) {
    	cards = _cards;
    	
    	seen = new boolean[512][cards.length];
    	dp = new boolean[512][cards.length];
    	return canWin(0, 0) ? "Fox Ciel" : "Toastman";
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(FiveHundredEleven.class, "test.*");
    }

	public void test0() {
		RETester.eq(theWinner(new int[] {3, 5, 7, 9, 510}), "Fox Ciel");
	}

	public void test1() {
		RETester.eq(theWinner(new int[] {0, 0, 0, 0}), "Toastman");
	}

	public void test2() {
		RETester.eq(theWinner(new int[] {511}), "Toastman");
	}

	public void test3() {
		RETester.eq(theWinner(new int[] {5, 58, 192, 256}), "Fox Ciel");
	}

// END CUT HERE
}
