
import java.util.*;

public class PalindromeDecoding {
    public String decode(String code, int[] position, int[] length) {
        int N = position.length;
        
        for (int i = 0; i < N; ++i) {
        	String sub = code.substring(position[i], position[i] + length[i]);
        	String reverse = (new StringBuffer(sub)).reverse().toString();
        	code = code.substring(0, position[i] + length[i]) + 
        		reverse + code.substring(position[i] + length[i]);
        }
        
        return code;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(PalindromeDecoding.class, "test.*");
    }

	public void test0() {
		RETester.eq(decode("ab", new int[] {0}, new int[] {2}), "abba");
	}

	public void test1() {
		RETester.eq(decode("Misip", new int[] {2,3,1,7}, new int[] {1,1,2,2}), "Mississippi");
	}

	public void test2() {
		RETester.eq(decode("XY", new int[] {0, 0, 0, 0}, new int[] {2, 4, 8, 16}), "XYYXXYYXXYYXXYYXXYYXXYYXXYYXXYYX");
	}

	public void test3() {
		RETester.eq(decode("TC206", new int[] {1,2,5}, new int[] {1,1,1}), "TCCC2006");
	}

	public void test4() {
		RETester.eq(decode("nodecoding", new int[] {}, new int[] {}), "nodecoding");
	}

// END CUT HERE
}
