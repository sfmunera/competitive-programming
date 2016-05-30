package interview;

public class DPCoins {
	
	static int[] coinValues = {1, 5, 10, 25};
	static Integer[] dp;
	
	static int ways(int n) {
		if (n < 0)
			return 0;
		if (n == 0)
			return 1;
		
		if (dp[n] != null)
			return dp[n];
		
		int ans = 0;
		for (int i = 0; i < coinValues.length; ++i)
			ans += ways(n - coinValues[i]);
		
		return dp[n] = ans;
	}
	
	public static void main(String[] args) {
		int n = 10;
		
		dp = new Integer[n + 1];
		
		System.out.println(ways(n));
	}
}
