package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2631 (11584 - Partitioning by Palindromes) */
/* SUBMISSION: 10892364 */
/* SUBMISSION TIME: 2012-11-16 04:09:28 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa11584_PartitioningbyPalindromes {
	
	static String str;
	static int N;
	static int[] dp;
	
	static boolean isPalindrome(String str, int l, int r) {
		while (l < r) {
			if (str.charAt(l) != str.charAt(r))
				return false;
			++l; --r;
		}
		return true;
	}
	
	/*static int go(int l, int r) {
		if (l > r) return 0;
		if (l == r) return 1;
		
		if (dp[l][r] != -1)
			return dp[l][r];
		
		if (isPalindrome(str, l, r))
			return dp[l][r] = 1;
		
		int ans = Integer.MAX_VALUE;
		for (int i = l; i < r; ++i)
			ans = Math.min(ans, go(l, i) + go(i + 1, r));
		
		return dp[l][r] = ans;
	}*/
	
	static int go(int k) {
		if (k == 0) return 0;
		
		if (dp[k] != -1)
			return dp[k];

		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < k; ++i)
			if (isPalindrome(str, i, k - 1))
				ans = Math.min(ans, go(i) + 1);
		
		return dp[k] = ans;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int MAXN = 1005;
		dp = new int[MAXN];
		
		int T = Integer.parseInt(in.readLine());
		while (T-- > 0) {
			str = in.readLine();
			N = str.length();
			
			Arrays.fill(dp, -1);
			
			System.out.println(go(N));
		}
		
		in.close();
		System.exit(0);
	}
}
