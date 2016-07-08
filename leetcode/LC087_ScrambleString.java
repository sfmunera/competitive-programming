package leetcode;

import java.util.*;

public class LC087_ScrambleString {
    
    Boolean dp[][][][];

    public boolean isAnagram(String s1, String s2, int l1, int r1, int l2, int r2) {
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();
        
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        
        return String.valueOf(ch1).equals(String.valueOf(ch2));
    }
    
    public boolean isScramble(String s1, String s2) {
        int length = s1.length();
        dp = new Boolean[length + 1][length + 1][length + 1][length + 1];
        
        return isScrambleHelper(s1, s2, 0, length - 1, 0, length - 1);
    }
    
    public boolean isScrambleHelper(String s1, String s2, int l1, int r1, int l2, int r2) {
        assert (r1 - l1 == r2 - l2);
        
        int length = r1 - l1 + 1;
        
        if (length <= 0)
            return true;
        if (length == 1)
            return s1.charAt(l1) == s2.charAt(l2);
            
        if (dp[l1][r1][l2][r2] != null)
            return dp[l1][r1][l2][r2];
            
        if (!isAnagram(s1, s2, l1, r1, l2, r2))
            return false;

        boolean valid = false;
        
        for (int cut = 1; cut < length; ++cut) {
            valid |= isScrambleHelper(s1, s2, l1, l1 + cut - 1, l2, l2 + cut - 1) && 
                     isScrambleHelper(s1, s2, l1 + cut, r1, l2 + cut, r2);

            valid |= isScrambleHelper(s1, s2, l1, l1 + cut - 1, r2 - cut + 1, r2) && 
                     isScrambleHelper(s1, s2, l1 + cut, r1, l2, l2 + (r1 - l1 - cut + 1) - 1);
        }
        
        return dp[l1][r1][l2][r2] = valid;
    }
}
