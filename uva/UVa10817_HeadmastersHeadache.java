package uva;

import java.util.*;
import java.io.*;

public class UVa10817_HeadmastersHeadache {
	
	static int N, S;
	static boolean[][] g;
	static int[] costApp;
	static boolean[][] seen;
	static int[][] dp;
	static final int INF = (int)1e9;
	
	static int go(int mask, int idx) {
		if (mask == (1 << (2 * S)) - 1) return 0;
		if (idx == N) return INF;
		
		if (seen[mask][idx]) return dp[mask][idx];
		seen[mask][idx] = true;
		
		int newmask = mask;
		for (int i = 0; i < S; ++i)
			if (g[idx][i])
				if ((newmask & (1 << i)) == 0)
					newmask |= (1 << i);
				else
					newmask |= (1 << (i + S));
		int ans = go(mask, idx + 1);
		if (newmask != mask)
			ans = Math.min(ans, costApp[idx] + go(newmask, idx + 1));
		
		return dp[mask][idx] = ans;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		while (true) {
			stk = new StringTokenizer(in.readLine());
			S = Integer.parseInt(stk.nextToken());
			int M = Integer.parseInt(stk.nextToken());
			N = Integer.parseInt(stk.nextToken());
			
			if (S == 0) break;
			
			costApp = new int[N];
			g = new boolean[N][S];
			
			int cost = 0;
			int mask = 0;
			for (int i = 0; i < M; ++i) {
				stk = new StringTokenizer(in.readLine());
				int c = Integer.parseInt(stk.nextToken());
				cost += c;
				
				while (stk.hasMoreTokens()) {
					int s = Integer.parseInt(stk.nextToken()) - 1;
					if ((mask & (1 << s)) == 0)
						mask |= (1 << s);
					else 
						mask |= (1 << (s + S));
				}
			}
			
			for (int i = 0; i < N; ++i) {
				stk = new StringTokenizer(in.readLine());
				costApp[i] = Integer.parseInt(stk.nextToken());
				while (stk.hasMoreTokens()) {
					int s = Integer.parseInt(stk.nextToken()) - 1;
					g[i][s] = true;
				}
			}
			
			seen = new boolean[1 << (2 * S)][N + 1];
			dp = new int[1 << (2 * S)][N + 1];
			
			System.out.println(cost + go(mask, 0));
		}
		
		in.close();
		System.exit(0);
	}
}
