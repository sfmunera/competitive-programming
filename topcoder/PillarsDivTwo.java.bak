import java.util.*;

public class PillarsDivTwo {
    public double maximalLength(int[] height, int w) {
        double[][] dp = new double[105][105];
        
        int N = height.length;
        for (int i = 1; i < N; ++i)
        	for (int j = 1; j <= height[i]; ++j)
        		for (int k = 1; k <= height[i - 1]; ++k)
        			dp[i][j] = Math.max(dp[i][j], dp[i - 1][k] + Math.sqrt(w * w + (k - j) * (k - j)));
        
        double ans = 0.0;
        for (int j = 1; j <= height[N - 1]; ++j)
        	ans = Math.max(ans, dp[N - 1][j]);
        
        return ans;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(PillarsDivTwo.class, "test.*");
    }

	public void test0() {
		RETester.eq(maximalLength(new int[] {3,3,3}, 2), 5.656854249492381);
	}

	public void test1() {
		RETester.eq(maximalLength(new int[] {1,1,1,1}, 100), 300.0);
	}

	public void test2() {
		RETester.eq(maximalLength(new int[] {100,2,100,2,100}, 4), 396.32310051270036);
	}

	public void test3() {
		RETester.eq(maximalLength(new int[] {2,1,1,2}, 1), 3.82842712474619);
	}

// END CUT HERE
}
