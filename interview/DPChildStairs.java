package interview;

public class DPChildStairs {
	
	static Integer[] dp;
	
	static int ways(int n) {
		if (n == 0)
			return 1;
		
		if (dp[n] != null)
			return dp[n];
		
		int ans = 0;
		if (n - 1 >= 0) ans += ways(n - 1);
		if (n - 2 >= 0) ans += ways(n - 2);
		if (n - 3 >= 0) ans += ways(n - 3);
		
		return dp[n] = ans;
	}
	
	public static void main(String[] args) {
		
		int n = 10;
		dp = new Integer[n + 1];
		System.out.println(ways(n));
	}
}
