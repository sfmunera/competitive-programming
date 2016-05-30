
public class MagicalStringDiv1 {
	
	int count(String S, int cut) {
		int cnt1 = 0;
		int cnt2 = 0;
		for (int i = 0; i < cut; ++i)
			if (S.charAt(i) == '>')
				++cnt1;
		for (int i = cut; i < S.length(); ++i)
			if (S.charAt(i) == '<')
				++cnt2;
		
		return 2 * Math.min(cnt1, cnt2);
	}
	
    public int getLongest(String S) {
    	int N = S.length();
    	int ans = 0;
        for (int i = 0; i <= N; ++i)
        	ans = Math.max(ans, count(S, i));
        
        return ans;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(MagicalStringDiv1.class, "test.*");
    }

	public void test0() {
		RETester.eq(getLongest("<><><<>"), 4);
	}

	public void test1() {
		RETester.eq(getLongest(">>><<<"), 6);
	}

	public void test2() {
		RETester.eq(getLongest("<<<>>>"), 0);
	}

	public void test3() {
		RETester.eq(getLongest("<<<<><>>><>>><>><>><>>><<<<>><>>>>><<>>>>><><<<<>>"), 24);
	}

// END CUT HERE
}
