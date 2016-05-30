
import java.util.*;

public class MergersDivOne {
    public double findMaximum(int[] revenues) {
        Arrays.sort(revenues);
        
        double res = revenues[0];
        for (int i = 1; i < revenues.length; ++i)
        	res = (res + revenues[i]) / 2.0;
        
        return res;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(MergersDivOne.class, "test.*");
    }

	public void test0() {
		RETester.eq(findMaximum(new int[] {5, -7, 3}), 1.5);
	}

	public void test1() {
		RETester.eq(findMaximum(new int[] {10, -17}), -3.5);
	}

	public void test2() {
		RETester.eq(findMaximum(new int[] {12, 12, 12, 12, 12}), 12.0);
	}

	public void test3() {
		RETester.eq(findMaximum(new int[] {0, 0, 0, 0, 0, 100}), 50.0);
	}

	public void test4() {
		RETester.eq(findMaximum(new int[] {10, -10, 100, -100, 1000, -1000}), 491.25);
	}

// END CUT HERE
}
