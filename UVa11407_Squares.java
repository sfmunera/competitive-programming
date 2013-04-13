package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2402 (11407 - Squares) */
/* SUBMISSION: 10228891 */
/* SUBMISSION TIME: 2012-06-16 01:56:21 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa11407_Squares {
	
	static int M;
	static int[] memo;
	
	static int solve(int rem) {
		if (rem == 0)
			return 0;
		
		if (memo[rem] != -1)
			return memo[rem];
		
		int ans = Integer.MAX_VALUE;
		for (int i = 1; i * i <= rem; ++i)
			ans = Math.min(ans, 1 + solve(rem - i * i));
		
		return memo[rem] = ans;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		
		int MAXN = 10005;
		memo = new int[MAXN];
		Arrays.fill(memo, -1);
		
		while (T-- > 0) {
			int N = Integer.parseInt(in.readLine());
			
			System.out.println(solve(N));
		}
		
		in.close();
		System.exit(0);
	}
}
