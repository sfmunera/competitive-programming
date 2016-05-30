
import java.util.*;

public class SmoothNumbers {
	
    public int countSmoothNumbers(int N, int k) {
    	int res = 0;
        for (int i = 1; i <= N; ++i) {
        	int m = i;
        	int largest = 1;
        	for (int p = 2; p * p <= m; ++p) {
        		if (m % p == 0)
        			largest = p;
        		while (m % p == 0)
        			m /= p;
        	}
        	if (m > 1)
        		largest = m;
        	if (largest <= k)
        		++res;
        }
        return res;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(SmoothNumbers.class, "test.*");
    }

	public void test0() {
		RETester.eq(countSmoothNumbers(10, 3), 7);
	}

	public void test1() {
		RETester.eq(countSmoothNumbers(10, 4), 7);
	}

	public void test2() {
		RETester.eq(countSmoothNumbers(15, 3), 8);
	}

	public void test3() {
		RETester.eq(countSmoothNumbers(5, 20), 5);
	}

	public void test4() {
		RETester.eq(countSmoothNumbers(100000, 100), 17442);
	}

// END CUT HERE
}
