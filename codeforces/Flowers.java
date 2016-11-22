import java.util.*;

public class Flowers {

	static final int MAX = (int) 1e5 + 7;
	static final int MOD = (int) 1e9 + 7;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int t = in.nextInt();
		int k = in.nextInt();
		
		long[] dp = new long[MAX];
		dp[1] = 1 + (k == 1 ? 1 : 0);
		for (int i = 2; i < MAX - 1; i++) {
			dp[i] += (1 + dp[i - 1]) % MOD;
			if (i >= k)
				dp[i] += (1 + dp[i - k]) % MOD;
			dp[i] %= MOD;
		}
		
		for (int i = 0; i < t; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			
			System.out.println((dp[b] - dp[a - 1] + MOD) % MOD);
		}
		
		in.close();
		System.exit(0);
	}
}
