package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 503 (562 - Dividing coins) */
/* SUBMISSION: 10180782 */
/* SUBMISSION TIME: 2012-06-02 00:09:53 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa00562_Dividingcoins {
	
	static int M, sum;
	static int[] values;
	static int[][] memo;
	
	static int solve(int coin, int V) {
		if (memo[coin][V] != -1)
			return memo[coin][V];
		
		if (coin == M)
			return memo[coin][V] = Math.abs(V - (sum - V));
		
		return memo[coin][V] = Math.min(solve(coin + 1, V), solve(coin + 1, V + values[coin]));
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		while (T-- > 0) {
			M = Integer.parseInt(in.readLine());
			sum = 0;
			values = new int[M];
			String[] parts = in.readLine().split("[ ]+");
			
			for (int i = 0; i < M; ++i) {
				values[i] = Integer.parseInt(parts[i]);
				sum += values[i];
			}
			
			int MAXC = 100;
			int MAXV = MAXC * 500;
			memo = new int[MAXC + 5][MAXV + 5];
			for (int i = 0; i < MAXC + 5; ++i)
				Arrays.fill(memo[i], -1);
			
			System.out.println(solve(0, 0));
		}
		
		in.close();
		System.exit(0);
	}
}
