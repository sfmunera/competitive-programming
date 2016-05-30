package spoj;

import java.util.*;
import java.io.*;

public class SCUBADIV {
	
	static int[] o, n, w;
	static final int INF = (int)1e9;
	static boolean[][][] seen;
	static int[][][] dp;
	
	static int go(int i, int O, int N) {
		if (O <= 0 && N <= 0) return 0;
		if (i < 0) return INF;
		
		O = Math.max(0, O);
		N = Math.max(0, N);
		
		if (seen[i][O][N]) return dp[i][O][N];
		
		seen[i][O][N] = true;
		return dp[i][O][N] = Math.min(go(i - 1, O, N), 
				           			  go(i - 1, O - o[i], N - n[i]) + w[i]);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		int T = Integer.parseInt(in.readLine());
		while (T-- > 0) {
			stk = new StringTokenizer(in.readLine());
			int O = Integer.parseInt(stk.nextToken());
			int N = Integer.parseInt(stk.nextToken());
			
			int M = Integer.parseInt(in.readLine());
			o = new int[M];
			n = new int[M];
			w = new int[M];
			for (int i = 0; i < M; ++i) {
				stk = new StringTokenizer(in.readLine());
				o[i] = Integer.parseInt(stk.nextToken());
				n[i] = Integer.parseInt(stk.nextToken());
				w[i] = Integer.parseInt(stk.nextToken());
			}
			in.readLine();
			
			seen = new boolean[M][O + 1][N + 1];
			dp = new int[M][O + 1][N + 1];
			
			for (int i = 0; i < M; ++i)
				for (int j = 0; j <= O; ++j)
					for (int k = 0; k <= N; ++k)
						dp[i][j][k] = -1;
			
			System.out.println(go(M - 1, O, N));
		}
	}
}
