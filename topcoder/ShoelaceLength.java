
public class ShoelaceLength {
	public double calculate(int startWidth, int endWidth, int spread, int numPairs) {
		double ans = startWidth;
		
		if (startWidth == endWidth) {
			double dist = Math.sqrt(spread * spread + startWidth * startWidth);
			return ans + 2.0 * (numPairs - 1) * dist;
		}
		
		if (startWidth > endWidth) {
			int t = startWidth;
			startWidth = endWidth;
			endWidth = t;
		}
		
		double x0 = startWidth / 2.0;
		double x1 = endWidth / 2.0;
		double y0 = 0.0;
		double y1 = spread * (numPairs - 1);
		
		double m = (y1 - y0) / (x1 - x0);
		double b = y1 - m * x1;
		
		double dx = (double)(x1 - x0) / (numPairs - 1);
		
		double[] x = new double[numPairs];
		double[] y = new double[numPairs];
		
		for (int i = 0; i < numPairs; ++i) {
			x[i] = x0 + i * dx;
			y[i] = m * x[i] + b;
		}
		
		for (int i = 0; i < numPairs - 1; ++i)
			ans += 2.0 * Math.sqrt((x[i] + x[i + 1]) * (x[i] + x[i + 1]) + (y[i] - y[i + 1]) * (y[i] - y[i + 1]));
		return ans;
	}

// BEGIN CUT HERE
	public static void main(String[] args) {
		RETester.test(ShoelaceLength.class, "test.*");
	}

	public void test0() {
		RETester.eq(calculate(2, 2, 1, 2), 6.47213595499958);
	}

	public void test1() {
		RETester.eq(calculate(10, 1, 1, 10), 111.1786186482248);
	}

	public void test2() {
		RETester.eq(calculate(1, 10, 1, 10), 102.17861864822481);
	}

	public void test3() {
		RETester.eq(calculate(1, 1, 1, 2), 3.8284271247461903);
	}

	public void test4() {
		RETester.eq(calculate(1, 99, 19, 2), 107.97663296253066);
	}

// END CUT HERE
}
