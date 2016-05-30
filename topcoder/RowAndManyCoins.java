
public class RowAndManyCoins {
    public String getWinner(String cells) {
        if (cells.charAt(0) == 'A' || cells.charAt(cells.length() - 1) == 'A')
        	return "Alice";
        return "Bob";
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(RowAndManyCoins.class, "test.*");
    }

	public void test0() {
		RETester.eq(getWinner("ABBB"), "Alice");
	}

	public void test1() {
		RETester.eq(getWinner("BBBB"), "Bob");
	}

	public void test2() {
		RETester.eq(getWinner("BA"), "Alice");
	}

	public void test3() {
		RETester.eq(getWinner("BABBABBB"), "Bob");
	}

	public void test4() {
		RETester.eq(getWinner("ABABBBABAABBAA"), "Alice");
	}

	public void test5() {
		RETester.eq(getWinner("BBBAAABBAAABBB"), "Bob");
	}

// END CUT HERE
}
