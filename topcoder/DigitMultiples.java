
import java.util.*;

public class DigitMultiples {
    public int getLongest(String single, String multiple) {
        int n1 = single.length();
        int n2 = multiple.length();
        
        int max = 0;
        for (int i = 0; i < n1; ++i)
        	for (int j = i + 1; j <= n1; ++j) {
        		String sub1 = single.substring(i, j);
        		for (int k = 0; k <= n2 - j + i; ++k) {
        			String sub2 = multiple.substring(k, k + j - i);
        			int ind = 0;
        			boolean ok = true;
        			while (ind < j - i && sub1.charAt(ind) == '0' && sub2.charAt(ind) == '0')
        				++ind;
        			if (ind < j - i) {
	        			int m1 = sub1.charAt(ind) - '0';
	        			int m2 = sub2.charAt(ind) - '0';
	        			if (m1 == 0)
	        				continue;
	        			if (m2 % m1 != 0)
	        				continue;
	        			int mult = m2 / m1;
	        			
	        			for (int l = 0; l < j - i; ++l) {
	        				m1 = sub1.charAt(l) - '0';
	            			m2 = sub2.charAt(l) - '0';
	            			if (m1 == 0 && m2 == 0)
	            				continue;
	            			if (m1 * mult != m2) {
	            				ok = false;
	            				break;
	            			}
	        			}
        			}
        			if (ok)
        				max = Math.max(max, j - i);
        		}
        	}
        return max;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(DigitMultiples.class, "test.*");
    }

	public void test0() {
		RETester.eq(getLongest("3211113321571", "5555266420"), 5);
	}

	public void test1() {
		RETester.eq(getLongest("100200300", "100400600"), 8);
	}

	public void test2() {
		RETester.eq(getLongest("111111111100000000000000000000000000000000000", "122333444455555666666777777788888888999999999"), 9);
	}

	public void test3() {
		RETester.eq(getLongest("000000000000", "000000000000"), 12);
	}

	public void test4() {
		RETester.eq(getLongest("11111111111", "11111111111"), 11);
	}

	public void test5() {
		RETester.eq(getLongest("89248987092734709478099", "00000000000000000000000"), 23);
	}

	public void test6() {
		RETester.eq(getLongest("11111111111111111111111111111111111111111111111111", "00000000000000000000000001111111111111111111111111"), 25);
	}

// END CUT HERE
}
