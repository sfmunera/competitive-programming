
import java.util.*;

public class PalindromicSubstringsDiv1 {
	
	double[][] dp;
	String S;
	
	double go(int i, int j) {
		if (i >= j) return 1.0;
		
		if (dp[i][j] != -1) return dp[i][j];
		
		double ans = 0.0;
		if (S.charAt(i) == '?' || S.charAt(j) == '?')
			ans = 1.0 / 26.0 * go(i + 1, j - 1);
		else if (S.charAt(i) == S.charAt(j))
			ans = 1.0 * go(i + 1, j - 1);
		else ans = 0.0;
		
		return dp[i][j] = ans;
	}
	
    public double expectedPalindromes(String[] S1, String[] S2) {
        S = "";
        for (String s : S1)
        	S += s;
        for (String s : S2)
        	S += s;
        
        int N = S.length();
        
        dp = new double[N + 1][N + 1];
        for (int i = 0; i <= N; ++i)
        	Arrays.fill(dp[i], -1);
        
        double ans = 0.0;
        for (int i = 0; i < N; ++i)
        	for (int j = i; j < N; ++j)
        		ans += go(i, j);
        
        return ans;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(PalindromicSubstringsDiv1.class, "test.*");
    }

	public void test0() {
		RETester.eq(expectedPalindromes(new String[] {"a","a",""}, new String[] {"a"}), 6.0);
	}

	public void test1() {
		RETester.eq(expectedPalindromes(new String[] {"z??"}, new String[] {}), 3.115384615384615);
	}

	public void test2() {
		RETester.eq(expectedPalindromes(new String[] {"ab","c"}, new String[] {"??","a?"}), 7.315088757396449);
	}

	public void test3() {
		RETester.eq(expectedPalindromes(new String[] {}, new String[] {"?"}), 1.0);
	}

	public void test4() {
		RETester.eq(expectedPalindromes(new String[] {"ab?def","?"}, new String[] {"f??a"}), 12.545971779699588);
	}

// END CUT HERE
}
