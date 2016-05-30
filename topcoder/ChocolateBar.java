
import java.util.*;

public class ChocolateBar {
	
	boolean repeated(String s) {
		Set<Character> set = new HashSet<Character>();
		for (int i = 0; i < s.length(); ++i)
			set.add(s.charAt(i));
		
		return set.size() != s.length();
	}
	
    public int maxLength(String letters) {
    	int N = letters.length();
    	int ans = 0;
    	
        for (int i = 0; i < N; ++i)
        	for (int j = i + 1; j <= N; ++j)
        		if (!repeated(letters.substring(i, j)))
        			ans = Math.max(ans, letters.substring(i, j).length());
        return ans;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(ChocolateBar.class, "test.*");
    }

	public void test0() {
		RETester.eq(maxLength("srm"), 3);
	}

	public void test1() {
		RETester.eq(maxLength("dengklek"), 6);
	}

	public void test2() {
		RETester.eq(maxLength("haha"), 2);
	}

	public void test3() {
		RETester.eq(maxLength("www"), 1);
	}

	public void test4() {
		RETester.eq(maxLength("thisisansrmbeforetopcoderopenfinals"), 9);
	}

// END CUT HERE
}
