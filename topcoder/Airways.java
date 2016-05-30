import java.util.*;

public class Airways {
	public double distance(int n, int x, int y) {
		double d = 2.0 * Math.PI / n;

		double theta = Math.atan2(y, x);
		if (theta < 0)
			theta += 2.0 * Math.PI;
		
		for (int i = 1; i < n; ++i) {
			double prev = d * (i - 1);
			double cur = d * i;
			if (theta >= prev && theta <= cur) {
				
			}
		}
	}

// BEGIN CUT HERE
	public static void main(String[] args) {
		RETester.test(Airways.class, "test.*");
	}

	public void test0() {
		RETester.eq(distance(3, -219, 0), 437.99999999999994);
	}

	public void test1() {
		RETester.eq(distance(3, 171, 0), 171.0);
	}

	public void test2() {
		RETester.eq(distance(4, 233, 3111), 3344.0000000000005);
	}

	public void test3() {
		RETester.eq(distance(14, -3840, -1768), 4243.534462721784);
	}

// END CUT HERE
}
