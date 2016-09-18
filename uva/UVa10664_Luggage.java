package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1605 (10664 - Luggage) */
/* SUBMISSION: 10180845 */
/* SUBMISSION TIME: 2012-06-02 01:13:16 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa10664_Luggage {
	
	static int N, sum;
	static int[] values;
	static int[][] memo;
	
	static int solve(int item, int V) {
		if (item == N)
			return Math.abs(V - (sum - V));
		
		if (memo[item][V] != -1)
			return memo[item][V];
		
		return memo[item][V] = Math.min(solve(item + 1, V), solve(item + 1, V + values[item]));
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		while (T-- > 0) {
			String[] parts = in.readLine().split("[ ]+");
			N = parts.length;
			values = new int[N];
			sum = 0;
			
			for (int i = 0; i < N; ++i) {
				values[i] = Integer.parseInt(parts[i]);
				sum += values[i];
 			}
			
			int MAXI = 20;
			int MAXV = 200;
			
			memo = new int[MAXI + 5][MAXV + 5];
			for (int i = 0; i < MAXI + 5; ++i)
				Arrays.fill(memo[i], -1);
			
			int diff = solve(0, 0);
			if (diff == 0)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
		
		in.close();
		System.exit(0);
	}
}
