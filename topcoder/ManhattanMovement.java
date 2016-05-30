
public class ManhattanMovement {
	public double getDistance(int _a, int _b, int _x0, int _y0) {
		long a = _a;
		long b = _b;
		long x0 = _x0;
		long y0 = _y0;
		if (a == 0) {
			return Math.abs(y0 - 1.0 / b);
		} else if (b == 0) {
			return Math.abs(x0 - 1.0 / a);
		} else {
			double m = (double)-a / b;
			double c = 1.0 / b;
			
			double xc = (y0 - c) / m;
			double yc = m * x0 + c;
			
			return Math.min(Math.abs(x0 - xc), Math.abs(y0 - yc));
		}
	}

// BEGIN CUT HERE
	public static void main(String[] args) {
		RETester.test(ManhattanMovement.class, "test.*");
	}

	public void test0() {
		RETester.eq(getDistance(1, 2, -2, 3), 1.5);
	}

	public void test1() {
		RETester.eq(getDistance(37, 37, 42, 19), 60.97297297297297);
	}

	public void test2() {
		RETester.eq(getDistance(-100, 0, -999999, 314159), 999998.99);
	}

	public void test3() {
		RETester.eq(getDistance(0, -2147483648, 1, 100000), 100000.00000000047);
	}

// END CUT HERE
}
