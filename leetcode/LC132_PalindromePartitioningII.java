package leetcode;

import java.util.Arrays;

public class LC132_PalindromePartitioningII {

	Boolean[][] isPalindrome;
	
	boolean isPalindrome(String s, int l, int r) {
		if (l >= r) return true;
		
		if (isPalindrome[l][r] != null) return isPalindrome[l][r];
		if (s.charAt(l) != s.charAt(r)) return isPalindrome[l][r] = false;

		return isPalindrome[l][r] = isPalindrome(s, l + 1, r - 1);
	}
	
	public int minCut(String s) {
		int N = s.length();
		isPalindrome = new Boolean[N][N];
		
        int[] dp = new int[N + 1]; // min nr of cuts before position i
        Arrays.fill(dp, N);
        dp[0] = 0;
        
        for (int i = 1; i <= N; ++i)
        	for (int j = 0; j < i; ++j)
    			if (isPalindrome(s, j, i - 1))
    				dp[i] = Math.min(dp[i], (j > 0 ? 1 : 0) + dp[j]);
        return dp[N];
    }
}
