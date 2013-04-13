package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1071 (10130 - SuperSale) */
/* SUBMISSION: 10177070 */
/* SUBMISSION TIME: 2012-05-31 20:21:46 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa10130_SuperSale {
	
	static int[] P;
	static int[] W;
	static int N;
	static int[][] memo;
	
	static int solve(int item, int V) {
		if (memo[item][V] != -1)
			return memo[item][V];
		if (V == 0)
			return memo[item][V] = 0;
		if (item == N)
			return memo[item][V] = 0;
		if (W[item] <= V)
			return memo[item][V] = Math.max(solve(item + 1, V), P[item] + solve(item + 1, V - W[item]));
		else
			return memo[item][V] =  solve(item + 1, V);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int MAXI = 1000;
		int MAXW = 30;
		memo = new int[MAXI + 5][MAXW + 5];
		
		int T = Integer.parseInt(in.readLine());
		while (T-- > 0) {
			
			N = Integer.parseInt(in.readLine().trim());
			P = new int[N];
			W = new int[N];
			for (int i = 0; i < N; ++i) {
				String[] parts = in.readLine().trim().split("[ ]+");
				P[i] = Integer.parseInt(parts[0]);
				W[i] = Integer.parseInt(parts[1]);
			}
			int G = Integer.parseInt(in.readLine().trim());
			
			int ans = 0;
			for (int i = 0; i < G; ++i) {
				int S = Integer.parseInt(in.readLine().trim());
				for (int j = 0; j <= MAXI; ++j)
					Arrays.fill(memo[j], -1);
				
				ans += solve(0, S);
			}
			System.out.println(ans);
		}
		
		in.close();
		System.exit(0);
	}
}
