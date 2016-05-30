package uva;

import java.util.*;
import java.io.*;

public class UVa11218_KTV {
	
	static int[][][] score;
	static boolean[] seen;
	static int[] dp;
	
	static int go(int mask) {
		if (mask == (1 << 9) - 1) return 0;
		
		if (seen[mask]) return dp[mask];
		seen[mask] = true;
		
		int ans = Integer.MIN_VALUE;
		for (int a = 0; a < 9; ++a)
			for (int b = a + 1; b < 9; ++b)
				for (int c = b + 1; c < 9; ++c)
					if ((mask & (1 << a)) == 0 && 
						(mask & (1 << b)) == 0 && 
						(mask & (1 << c)) == 0 && score[a][b][c] > 0)
						ans = Math.max(ans, score[a][b][c] + go(mask | (1 << a) | (1 << b) | (1 << c)));
		return dp[mask] = ans;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		int t = 1;
		while (true) {
			int N = Integer.parseInt(in.readLine());
			if (N == 0) break;
			
			score = new int[9][9][9];
			for (int i = 0; i < N; ++i) {
				stk = new StringTokenizer(in.readLine());
				int a = Integer.parseInt(stk.nextToken()) - 1;
				int b = Integer.parseInt(stk.nextToken()) - 1;
				int c = Integer.parseInt(stk.nextToken()) - 1;
				int s = Integer.parseInt(stk.nextToken());
				
				score[a][b][c] = s;
			}
			
			seen = new boolean[1 << 9];
			dp = new int[1 << 9];
			
			int ans = go(0);
			System.out.println("Case " + t + ": " + (ans < 0 ? -1 : ans));
			++t;
		}
		
		in.close();
		System.exit(0);
	}
}
