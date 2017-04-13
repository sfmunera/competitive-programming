package leetcode;

public class LC005_LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }
        int bestLeft = -1;
        int bestRight = -1;
        int max = 0;
        
        for (int leftOffset = 0; leftOffset <= 1; leftOffset++) {
            for (int i = 0; i < s.length() - 1; i++) {
                int left = i - leftOffset;
                int right = i + 1;
                int length = right - left - 1;
                while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                    length += 2;
                    left--;
                    right++;
                }
                if (length > max) {
                    max = length;
                    bestLeft = left + 1;
                    bestRight = right - 1;
                }
            }
        }
        return s.substring(bestLeft, bestRight + 1);
    }
}
