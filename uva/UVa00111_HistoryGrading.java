package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 47 (111 - History Grading) */
/* SUBMISSION: 11573193 */
/* SUBMISSION TIME: 2013-04-07 22:34:22 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa00111_HistoryGrading {
	
	static int lis(int[] s, int[] rank) {
		int N = s.length;
		int[] dp = new int[N];
		
		int ans = 0;
		for (int i = 0; i < N; ++i) {
			int max = 0;
			for (int j = 0; j < i; ++j)
				if (rank[s[i]] > rank[s[j]])
					max = Math.max(max, dp[j]);
			dp[i] = 1 + max;
			ans = Math.max(ans, dp[i]);
		}
		
		return ans;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		int N = Integer.parseInt(in.readLine());
		int[] rank = new int[N];
		stk = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; ++i)
			rank[i] = Integer.parseInt(stk.nextToken()) - 1;
		
		String line;
		while ((line = in.readLine()) != null) {
			stk = new StringTokenizer(line);
			int[] s = new int[N];
			for (int i = 0; i < N; ++i)
				s[Integer.parseInt(stk.nextToken()) - 1] = i;
			
			System.out.println(lis(s, rank));
		}
		
		in.close();
		System.exit(0);
	}
}
