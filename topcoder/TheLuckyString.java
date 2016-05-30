import java.util.*;

public class TheLuckyString {
	
	void swap(char[] c, int i, int j) {
		char t = c[i];
		c[i] = c[j];
		c[j] = t;
	}
	
	boolean nextPermutation(char[] c) {
		int n = c.length;
		int k = -1;
		
		for (int i = n - 2; i >= 0; --i)
			if (c[i] < c[i + 1]) {
				k = i;
				break;
			}
		if (k == -1)
			return false;
		
		int l = 0;
		for (int i = n - 1; i >= 0; --i)
			if (c[k] < c[i]) {
				l = i;
				break;
			}
		swap(c, k, l);
		for (int i = k + 1; i < (n + k + 1) / 2; ++i)
			swap(c, i, n + k - i);
		
		return true;
	}
	
    public int count(String s) {
    	char[] c = s.toCharArray();
    	Arrays.sort(c);
    	int res = 0;
    	do {
    		boolean isLucky = true;
    		for (int i = 1; i < c.length; ++i)
    			if (c[i - 1] == c[i])
    				isLucky = false;
    		if (isLucky)
    			++res;
    	} while (nextPermutation(c));
        
        return res;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(TheLuckyString.class, "test.*");
    }

	public void test0() {
		RETester.eq(count("ab"), 2);
	}

	public void test1() {
		RETester.eq(count("aaab"), 0);
	}

	public void test2() {
		RETester.eq(count("aabbbaa"), 1);
	}

	public void test3() {
		RETester.eq(count("abcdefghij"), 3628800);
	}

// END CUT HERE
}
