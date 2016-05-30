
public class SplitStoneGame {
    public String winOrLose(int[] number) {
    	int N = number.length;
        boolean allOnes = true;
        
        for (int i = 0; i < N; ++i)
        	allOnes &= number[i] == 1;
        
        if (allOnes || N <= 2 || N % 2 == 0)
        	return "LOSE";
        
        return "WIN";
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(SplitStoneGame.class, "test.*");
    }

	public void test0() {
		RETester.eq(winOrLose(new int[] {1, 1, 1}), "LOSE");
	}

	public void test1() {
		RETester.eq(winOrLose(new int[] {2, 2}), "LOSE");
	}

	public void test2() {
		RETester.eq(winOrLose(new int[] {1, 1, 2}), "WIN");
	}

	public void test3() {
		RETester.eq(winOrLose(new int[] {1, 2, 3, 4, 3, 2, 2, 4, 3, 1, 4, 4, 1, 2, 4, 4, 1, 4, 3, 1, 4, 2, 1}), "WIN");
	}

	public void test4() {
		RETester.eq(winOrLose(new int[] {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 3, 1, 9, 1, 3, 1, 1, 1, 1, 1}), "LOSE");
	}

// END CUT HERE
}
