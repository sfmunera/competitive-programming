package uva;

import java.util.*;

public class UVa00531_Compromise {
	
	static int M, N;
	static int[][] dp;
	static ArrayList<String> X, Y;
	
	static void buildPath(int i, int j, boolean first) {
		if (i == 0 || j == 0)
			return;
		if (X.get(i - 1).equals(Y.get(j - 1))) {
			buildPath(i - 1, j - 1, false);
			System.out.print(X.get(i - 1));
			if (!first)
				System.out.print(" ");
		} else if (dp[i - 1][j] > dp[i][j - 1])
			buildPath(i - 1, j, first);
		else
			buildPath(i, j - 1, first);
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		while (in.hasNext()) {
			X = new ArrayList<String>();
			Y = new ArrayList<String>();
			
			while (true) {
				String token = in.next();
				if (token.equals("#"))
					break;
				X.add(token);
			}
			while (true) {
				String token = in.next();
				if (token.equals("#"))
					break;
				Y.add(token);
			}
			
			M = X.size();
			N = Y.size();
			
			dp = new int[M + 1][N + 1];
			for (int i = 0; i <= M; ++i)
				dp[i][0] = 0;
			for (int j = 0; j <= N; ++j)
				dp[0][j] = 0;
			
			for (int i = 1; i <= M; ++i)
				for (int j = 1; j <= N; ++j)
					if (X.get(i - 1).equals(Y.get(j - 1)))
						dp[i][j] = 1 + dp[i - 1][j - 1];
					else
						dp[i][j] = Math.max(dp[i - 1][j], dp[i][j- 1]);
			
			buildPath(M, N, true);
			System.out.println();
		}
	}
}
