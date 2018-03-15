
public class LC583_DeleteOperationForTwoStrings {
    private int solve(int i, int j, String word1, String word2, Integer[][] dp) {
        if (i >= word1.length() || j >= word2.length()) return 0;
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        int ans = 0;
        if (word1.charAt(i) == word2.charAt(j)) {
            ans = Math.max(ans, 1 + solve(i + 1, j + 1, word1, word2, dp));
        }
        ans = Math.max(ans, solve(i + 1, j, word1, word2, dp));
        ans = Math.max(ans, solve(i, j + 1, word1, word2, dp));
        
        return dp[i][j] = ans;
    }
    
    private int solve(String word1, String word2) {
        Integer[][] dp = new Integer[word1.length() + 1][word2.length() + 1];
        return solve(0, 0, word1, word2, dp);
    }
    
    public int minDistance(String word1, String word2) {
        int lcs = solve(word1, word2);
        return word1.length() + word2.length() - 2 * lcs;
    }
}
