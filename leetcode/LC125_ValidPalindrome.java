package leetcode;

public class LC125_ValidPalindrome {
    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        
        while (l < r) {
            char lch = s.charAt(l);
            if (!(Character.isAlphabetic(lch) || Character.isDigit(lch))) {
                ++l;
                continue;
            }
            char rch = s.charAt(r);
            if (!(Character.isAlphabetic(rch) || Character.isDigit(rch))) {
                --r;
                continue;
            }
            
            if (Character.toLowerCase(lch) != Character.toLowerCase(rch))
                return false;
            ++l;
            --r;
        }
        
        return true;
    }
}
