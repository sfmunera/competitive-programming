import java.util.*;

public class ThePalindrome {
	
	boolean isPalindrome(String s) {
		int n = s.length();
		for (int i = 0; i < n / 2; ++i)
			if (s.charAt(i) != s.charAt(n - i - 1))
				return false;
		return true;
	}
	
    public int find(String s) {
    	int n = s.length();
    	int res = 0;
        for (int i = 0; i < n; ++i)
        	if (isPalindrome(s.substring(i))) {
        		res = n + i;
        		break;
        	}
        return res;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(ThePalindrome.class, "test.*");
    }

	public void test0() {
		RETester.eq(find("abab"), 5);
	}

	public void test1() {
		RETester.eq(find("abacaba"), 7);
	}

	public void test2() {
		RETester.eq(find("qwerty"), 11);
	}

	public void test3() {
		RETester.eq(find("abdfhdyrbdbsdfghjkllkjhgfds"), 38);
	}

// END CUT HERE
}
