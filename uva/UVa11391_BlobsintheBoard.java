package uva;

import java.util.*;
import java.io.*;

public class UVa11391_BlobsintheBoard {
	
	static int R, C;
	static boolean[][][] seen;
	static int[][][] dp;
	
	static final int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
	static final int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};
	
	static int posToBinpos(int r, int c) {
		return R * r + c;
	}

	static boolean inside(int r, int c) {
		return r >= 0 && c >= 0 && r < R && c < C;
	}
	
	static int go(int mask) {
		if (Integer.bitCount(mask) == 1) return 1;
		
		if (seen[mask][R - 1][C - 1]) return dp[mask][R - 1][C - 1];
		seen[mask][R - 1][C - 1] = true;

		int ans = 0;
		for (int r = 0; r < R; ++r)
			for (int c = 0; c < C; ++c) {
				int x = posToBinpos(r, c);
				if ((mask & (1 << x)) == 0) continue;
				for (int i = 0; i < 8; ++i) {
					int nr1 = r + dr[i];
					int nc1 = c + dc[i];
					int nr2 = r + 2 * dr[i];
					int nc2 = c + 2 * dc[i];
					if (inside(nr1, nc1) && inside(nr2, nc2)) {
						int x1 = posToBinpos(nr1, nc1);
						int x2 = posToBinpos(nr2, nc2);
						if ((mask & (1 << x1)) > 0 && (mask & (1 << x2)) == 0) {
							int newmask = mask & ~(1 << x) & ~(1 << x1) | (1 << x2);
							ans += go(newmask);
						}
					}
				}
			}
		return dp[mask][R - 1][C - 1] = ans;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		StringBuilder ans = new StringBuilder();
		
		seen = new boolean[1 << 16][4][4];
		dp = new int[1 << 16][4][4];
		
		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; ++t) {
			stk = new StringTokenizer(in.readLine());
			R = Integer.parseInt(stk.nextToken());
			C = Integer.parseInt(stk.nextToken());
			int N = Integer.parseInt(stk.nextToken());
			
			int mask = 0;
			for (int i = 0; i < N; ++i) {
				stk = new StringTokenizer(in.readLine());
				int r = Integer.parseInt(stk.nextToken()) - 1;
				int c = Integer.parseInt(stk.nextToken()) - 1;
				
				int x = posToBinpos(r, c);
				mask |= (1 << x);
			}
			ans.append("Case " + t + ": " + go(mask) + "\n");
		}
		System.out.print(ans);
		
		in.close();
		System.exit(0);
	}
}
