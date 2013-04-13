package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2008 (11067 - Little Red Riding Hood) */
/* SUBMISSION: 11412970 */
/* SUBMISSION TIME: 2013-03-10 04:20:53 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa11067_LittleRedRidingHood {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			StringTokenizer stk = new StringTokenizer(in.readLine());
			int C = Integer.parseInt(stk.nextToken());
			int R = Integer.parseInt(stk.nextToken());
			
			if (C == 0 && R == 0) break;
			
			boolean[][] wolf = new boolean[R + 1][C + 1];
			long[][] dp = new long[R + 1][C + 1];
			int N = Integer.parseInt(in.readLine());
			
			for (int i = 0; i < N; ++i) {
				stk = new StringTokenizer(in.readLine());
				int c = Integer.parseInt(stk.nextToken());
				int r = Integer.parseInt(stk.nextToken());
				wolf[r][c] = true;
			}
			
			dp[0][0] = 1;
			for (int i = 0; i <= R; ++i)
				for (int j = 0; j <= C; ++j) {
					if (i + 1 <= R && !wolf[i + 1][j])
						dp[i + 1][j] += dp[i][j];
					if (j + 1 <= C && !wolf[i][j + 1])
						dp[i][j + 1] += dp[i][j];
				}
			if (dp[R][C] == 0)
				System.out.println("There is no path.");
			else if (dp[R][C] == 1)
				System.out.println("There is one path from Little Red Riding Hood's house to her grandmother's house.");
			else
				System.out.println("There are " + dp[R][C] + " paths from Little Red Riding Hood's house to her grandmother's house.");
		}
		
		in.close();
		System.exit(0);
	}
}
