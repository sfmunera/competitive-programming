package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 83 (147 - Dollars) */
/* SUBMISSION: 10168035 */
/* SUBMISSION TIME: 2012-05-29 14:21:52 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa00147_Dollars {
	
	static long[][] memo;
	static int[] types = {2000, 1000, 400, 200, 100, 40, 20, 10, 4, 2, 1};
	
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
		
		int MAXN = types.length;
		int MAXV = 6000;
		
		memo = new long[MAXN + 1][MAXV + 1];
		for (int i = 0; i <= MAXN; ++i)
			Arrays.fill(memo[i], -1);
		
		while (true) {
			int V = (int)(Double.parseDouble(in.readLine()) * 20);
			if (V == 0)
				break;
			System.out.printf(Locale.ENGLISH, "%6.2f%17d\n", (double)(V / 20.0), solve(0, V));
		}
		
		in.close();
		System.exit(0);
	}
}