package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2078 (11137 - Ingenuous Cubrency) */
/* SUBMISSION: 10168324 */
/* SUBMISSION TIME: 2012-05-29 16:00:38 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa11137_IngenuousCubrency {
	
	static int[] types;
	static long[][] memo;
	
	static long solve(int type, int V) {
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

		int MAXN = 21;
		int MAXV = 10000;
		
		types = new int[MAXN];
		
		for (int i = 1; i <= MAXN; ++i)
			types[i - 1] = i * i * i;
		
		memo = new long[MAXN + 1][MAXV + 1];
		for (int i = 0; i <= MAXN; ++i)
			Arrays.fill(memo[i], -1);
		
		
		String line;
		while ((line = in.readLine()) != null) {
			int V = Integer.parseInt(line.trim());
			System.out.println(solve(0, V));
		}
		
		in.close();
		System.exit(0);
	}
}
