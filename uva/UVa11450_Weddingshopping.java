package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2445 (11450 - Wedding shopping) */
/* SUBMISSION: 11428652 */
/* SUBMISSION TIME: 2013-03-13 05:17:50 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa11450_Weddingshopping {
	
	static int[][] price, dp;
	static int G, M;
	
	static int go(int m, int g) {
		if (m < 0) return 0;
		if (g == G) return M - m;
		
		if (dp[m][g] != -1)
			return dp[m][g];
		
		int ans = 0;
		for (int i = 1; i <= price[g][0]; ++i)
			ans = Math.max(ans, go(m - price[g][i], g + 1));
		
		return dp[m][g] = ans;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		int T = Integer.parseInt(in.readLine());
		while (T-- > 0) {
			stk = new StringTokenizer(in.readLine());
			M = Integer.parseInt(stk.nextToken());
			G = Integer.parseInt(stk.nextToken());
			
			price = new int[G][21];
			for (int i = 0; i < G; ++i) {
				stk = new StringTokenizer(in.readLine());
				int k = 0;
				while (stk.hasMoreTokens())
					price[i][k++] = Integer.parseInt(stk.nextToken());
			}
			
			dp = new int[205][25];
			for (int i = 0; i < 205; ++i)
				Arrays.fill(dp[i], -1);
			
			int ans = go(M, 0);
			if (ans == 0)
				System.out.println("no solution");
			else
				System.out.println(ans);
		}
		
		in.close();
		System.exit(0);
	}
}
