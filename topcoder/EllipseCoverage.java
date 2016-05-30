
public class EllipseCoverage {
    public int calculateCoverage(int x1, int y1, int x2, int y2, int d) {
    	int ans = 0;
        for (int x = Math.min(x1, x2) - d; x <= Math.max(x1, x2) + d; ++x)
        	for (int y = Math.min(y1, y2) - d; y <= Math.max(y1, y2) + d; ++y) {
        		int dx1 = x - x1;
        		int dy1 = y - y1;
        		int dx2 = x - x2;
        		int dy2 = y - y2;
        		double d1 = Math.sqrt(dx1 * dx1 + dy1 * dy1);
        		double d2 = Math.sqrt(dx2 * dx2 + dy2 * dy2);
        		
        		if (d1 + d2 < d)
        			++ans;
        	}
        return ans;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(EllipseCoverage.class, "test.*");
    }

	public void test0() {
		RETester.eq(calculateCoverage(0, 0, 0, 0, 4), 9);
	}

	public void test1() {
		RETester.eq(calculateCoverage(-3, 0, 3, 0, 10), 59);
	}

	public void test2() {
		RETester.eq(calculateCoverage(10, 12, 8, 14, 50), 1941);
	}

	public void test3() {
		RETester.eq(calculateCoverage(0, 0, 0, 0, 200), 31397);
	}

	public void test4() {
		RETester.eq(calculateCoverage(13, -23, 49, 91, 200), 25187);
	}

// END CUT HERE
}
