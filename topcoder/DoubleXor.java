
import java.util.*;

public class DoubleXor {
	
	String doubleXor(String s1, String s2) {
		String res = "";

		if (s1.length() < s2.length()) {
			for (int i = s1.length(); i < s2.length(); ++i)
				s1 = "0" + s1;
		}
		if (s2.length() < s1.length()) {
			for (int i = s2.length(); i < s1.length(); ++i)
				s2 = "0" + s2;
		}		
		
		for (int i = 0; i < s1.length(); ++i)
			res += ((s1.charAt(i) - '0') ^ (s2.charAt(i) - '0')) % 10;
		
		return res;
	}
	
    public int calculate(int N) {
    	int res = N;
        for (int i = N; i > 1; --i)
        	res = Integer.parseInt(doubleXor(String.valueOf(res), String.valueOf(i - 1)));
        
        return res;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(DoubleXor.class, "test.*");
    }

	public void test0() {
		RETester.eq(calculate(1), 1);
	}

	public void test1() {
		RETester.eq(calculate(2), 3);
	}

	public void test2() {
		RETester.eq(calculate(7), 0);
	}

	public void test3() {
		RETester.eq(calculate(10), 11);
	}

	public void test4() {
		RETester.eq(calculate(102), 103);
	}

// END CUT HERE
}
