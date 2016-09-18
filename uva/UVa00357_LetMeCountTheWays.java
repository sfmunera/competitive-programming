package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 293 (357 - Let Me Count The Ways) */
/* SUBMISSION: 10168100 */
/* SUBMISSION TIME: 2012-05-29 14:40:57 */
/* LANGUAGE: 2 */

import java.io.*;
import java.util.*;

public class UVa00357_LetMeCountTheWays {
	static long[][] memo;
	static int[] types = {50, 25, 10, 5, 1};
	
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
		int MAXV = 30000;
		
		memo = new long[MAXN + 1][MAXV + 1];
		for (int i = 0; i <= MAXN; ++i)
			Arrays.fill(memo[i], -1);
		
		String line;
		while ((line = in.readLine()) != null) {
			int V = Integer.parseInt(line);
			
			long ans = solve(0, V);
			
			if (ans == 1)
				System.out.printf("There is only 1 way to produce %d cents change.\n", V);
			else
				System.out.printf("There are %d ways to produce %d cents change.\n", ans, V);
		}
		
		in.close();
		System.exit(0);
	}
}
