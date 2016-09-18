package topcoder;

public class TrySail {
	
	Integer[][][] dp;
	int sumTotal;
	
	int go(int id, int sum1, int sum2, int[] strength) {
		if (id < 0) {
			int sum3 = sumTotal ^ sum1 ^ sum2;
			return sum1 + sum2 + sum3;
		}
		
		if (dp[id][sum1][sum2] != null) return dp[id][sum1][sum2];
		
		int ans = 0;
		ans = Math.max(ans, go(id - 1, sum1 ^ strength[id], sum2, strength));
		ans = Math.max(ans, go(id - 1, sum1, sum2 ^ strength[id], strength));
		ans = Math.max(ans, go(id - 1, sum1, sum2, strength));
		
		return dp[id][sum1][sum2] = ans;
	}
	
    public int get(int[] strength) {
    	sumTotal = 0;
    	for (int x : strength) {
    		sumTotal ^= x;
    	}
    	
    	dp = new Integer[strength.length][300][300];
        return go(strength.length - 1, 0, 0, strength);
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(TrySail.class, "test.*");
    }

	public void test0() {
		RETester.eq(get(new int[] {2,3,3}), 8);
	}

	public void test1() {
		RETester.eq(get(new int[] {7,3,5,2}), 17);
	}

	public void test2() {
		RETester.eq(get(new int[] {13,13,13,13,13,13,13,13}), 26);
	}

	public void test3() {
		RETester.eq(get(new int[] {114,51,4,191,9,81,0,89,3}), 470);
	}

	public void test4() {
		RETester.eq(get(new int[] {108,66,45,82,163,30,83,244,200,216,241,249,89,128,36,28,250,190,70,95,117,196,19,160,255,129,10,109,189,24,22,25,134,144,110,15,235,205,186,103,116,191,119,183,45,217,156,44,97,197}), 567);
	}

// END CUT HERE
}
