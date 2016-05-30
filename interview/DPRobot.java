package interview;

public class DPRobot {

	public static void main(String[] args) {
		int R = 5;
		int C = 7;
		
		int[][] dp = new int[R + 1][C + 1];
		dp[0][0] = 1;
		for (int i = 0; i <= R; ++i)
			for (int j = 0; j <= C; ++j) {
				if (i > 0)
					dp[i][j] += dp[i - 1][j];
				if (j > 0)
					dp[i][j] += dp[i][j - 1];
			}
		
		System.out.println(dp[R][C]);
	}
}
