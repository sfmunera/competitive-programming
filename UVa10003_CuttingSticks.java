package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 944 (10003 - Cutting Sticks) */
/* SUBMISSION: 10223960 */
/* SUBMISSION TIME: 2012-06-14 14:40:37 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa10003_CuttingSticks {
	
	static int N;
	static int[] pos;
	static int[][] memo;
	
	static int solve(int l, int r) {

		if (l + 1 == r)
			return 0;
		
		if (memo[l][r] != -1)
			return memo[l][r];
		
		int min = Integer.MAX_VALUE / 3;
		for (int i = l + 1; i < r; ++i)
				min = Math.min(min, solve(l, i) + solve(i, r));
		
		return memo[l][r] = min + pos[r] - pos[l];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			int L = Integer.parseInt(in.readLine());
			if (L == 0)
				break;
			
			N = Integer.parseInt(in.readLine());
			pos = new int[N + 2];
			
			String[] parts = in.readLine().split("[ ]+");
			for (int i = 1; i <= N; ++i)
				pos[i] = Integer.parseInt(parts[i - 1]);
			pos[0] = 0;
			pos[N + 1] = L;
			
			memo = new int[55][55];
			for (int i = 0; i < 55; ++i)
				Arrays.fill(memo[i], -1);
			
			System.out.println("The minimum cutting is " + solve(0, N + 1) + ".");
		}
		
		in.close();
		System.exit(0);
	}
}
