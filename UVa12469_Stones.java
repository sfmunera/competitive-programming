package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 3913 (12469 - Stones) */
/* SUBMISSION: 10187153 */
/* SUBMISSION TIME: 2012-06-03 19:12:04 */
/* LANGUAGE: 2 */

import java.io.*;
import java.util.*;

public class UVa12469_Stones {
	
	static int[][] memo;
	
	static int canWin(int N, int K) {
		if (N == 0)
			return 0;

		if (memo[N][K] != -1)
			return memo[N][K];

		int ans = 0;
		for (int k = 1; k <= K; ++k)
			if (canWin(N - k, Math.min(2 * k, N - k)) == 0) {
				ans = 1;
				break;
			}
		
		return memo[N][K] = ans;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		memo = new int[1005][1005];
		for (int i = 0; i < 1005; ++i)
			Arrays.fill(memo[i], -1);
		
		while (true) {
			int N = Integer.parseInt(in.readLine());
			if (N == 0)
				break;
			
			boolean can = false;
			for (int k = 1; k < N; ++k)
				if (canWin(N, k) == 1) {
					can = true;
					break;
				}
			
			if (can)
				System.out.println("Alicia");
			else
				System.out.println("Roberto");
		}
		
		in.close();
		System.exit(0);
	}
}