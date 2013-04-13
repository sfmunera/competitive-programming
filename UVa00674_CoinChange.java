package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 615 (674 - Coin Change) */
/* SUBMISSION: 10166620 */
/* SUBMISSION TIME: 2012-05-29 05:17:35 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa00674_CoinChange {
	
	static int[] types = {1, 5, 10, 25, 50};
	static int[][] memo;
	
	static int solve(int type, int V) {
		if (V < 0)
			return 0;
		if (memo[type][V] != -1)
			return memo[type][V];
		if (V == 0)
			return memo[type][V] = 1;
		if (type == types.length)
			return memo[type][V] = 0;
		
		return memo[type][V] = solve(type + 1, V) + solve(type, V - types[type]);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		String line;
		
		int MAXV = 7489;
		
		memo = new int[types.length + 1][MAXV + 1];
		for (int i = 0; i <= types.length; ++i)
			Arrays.fill(memo[i], -1);
		
		for (int i = 0; i <= types.length; ++i)
			for (int j = 0; j <= MAXV; ++j)
				solve(i, j);
		
		while ((line = in.readLine()) != null) {
			int V = Integer.parseInt(line);
			
			sb.append(memo[0][V] + "\n");
		}
		System.out.print(sb);
		
		in.close();
		System.exit(0);
	}
}
