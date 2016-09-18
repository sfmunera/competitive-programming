package leetcode;

public class LC009_PalindromeNumber {
	public boolean isPalindrome(int x) {
        int rev = 0;
        int tmp = x;
        while (tmp > 0) {
            int d = tmp % 10;
            rev = 10 * rev + d;
            tmp /= 10;
        }
        
        return x == rev;
    }
}
