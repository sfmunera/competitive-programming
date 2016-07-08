package leetcode;

public class LC010_RegularExpressionMatching {
    
    Boolean[][] dp;
    
    public boolean isMatch(String s, String p) {
        
        dp = new Boolean[s.length() + 1][p.length() + 1];
        
        return isMatchHelper(s, p, 0, 0);
    }
    
    public boolean isMatchHelper(String s, String p, int i, int j) {
        if (i == s.length() && j == p.length()) {
            return true;
        }
        
        if (i < s.length() && j == p.length()) {
            return false;
        }
        
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        
        if (i == s.length() && j < p.length()) {
            if (j == p.length() - 1 || p.charAt(j + 1) != '*') {
                return dp[i][j] = false;
            }
            return dp[i][j] = isMatchHelper(s, p, i, j + 2);
        }
        
        if (j < p.length() - 1 && p.charAt(j + 1) == '*') {
            if (p.charAt(j) == '.' || p.charAt(j) == s.charAt(i)) {
                if (isMatchHelper(s, p, i + 1, j) || isMatchHelper(s, p, i + 1, j + 2)) {
                    return dp[i][j] = true;
                }
            }
            if (isMatchHelper(s, p, i, j + 2)) {
                return dp[i][j] = true;
            }
        } else {
            if (p.charAt(j) != '.' && p.charAt(j) != s.charAt(i)) {
                return dp[i][j] = false;
            } else {
                if (isMatchHelper(s, p, i + 1, j + 1)) {
                    return dp[i][j] = true;
                }
            }
        }
        
        return dp[i][j] = false;
    }
}
