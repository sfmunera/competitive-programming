package uva;

import java.util.*;

public class UVa01207_AGTC {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		while (in.hasNext()) {
			int M = in.nextInt();
			String X = in.next();
			int N = in.nextInt();
			String Y = in.next();
			
			int[][] dp = new int[M + 1][N + 1];
			for (int i = 0; i <= M; ++i)
				dp[i][0] = i;
			for (int j = 0; j <= N; ++j)
				dp[0][j] = j;
			
			for (int i = 1; i <= M; ++i)
				for (int j = 1; j <= N; ++j)
					dp[i][j] = Math.min(dp[i - 1][j - 1] + (X.charAt(i - 1) == Y.charAt(j - 1) ? 0 : 1), 
							Math.min(1 + dp[i - 1][j], 1 + dp[i][j - 1]));
			System.out.println(dp[M][N]);
		}
	}
}
