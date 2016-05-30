
public class RedAndGreen {
    public int minPaints(String row) {
    	int N = row.length();
    	int ans = Integer.MAX_VALUE;
    	
        for (int k = N; k >= 0; --k) {
        	int cnt = 0;
        	for (int i = 0; i < N; ++i)
        		if (i < k && row.charAt(i) != 'R')
        			++cnt;
        		else if (i >= k && row.charAt(i) != 'G')
        			++cnt;
        	ans = Math.min(ans, cnt);
        }
        return ans;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(RedAndGreen.class, "test.*");
    }

	public void test0() {
		RETester.eq(minPaints("RGRGR"), 2);
	}

	public void test1() {
		RETester.eq(minPaints("RRRGGGGG"), 0);
	}

	public void test2() {
		RETester.eq(minPaints("GGGGRRR"), 3);
	}

	public void test3() {
		RETester.eq(minPaints("RGRGRGRGRGRGRGRGR"), 8);
	}

	public void test4() {
		RETester.eq(minPaints("RRRGGGRGGGRGGRRRGGRRRGR"), 9);
	}

// END CUT HERE
}
