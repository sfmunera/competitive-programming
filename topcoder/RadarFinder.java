
public class RadarFinder {

	public int possibleLocations(int x1, int y1, int r1, int x2, int y2, int r2) {
		if (x1 == x2 && y1 == y2 && r1 == r2)
			return -1;
		
		long dx = x2 - x1;
		long dy = y2 - y1;
		long d = dx * dx + dy * dy;
		
		if ((long)(r1 + r2) * (r1 + r2) < d)
			return 0;
		if ((long)(r1 + r2) * (r1 + r2) == d)
			return 1;
		if ((long)(r1 + r2) * (r1 + r2) > d && (long)(r2 - r1) * (r2 - r1) < d)
			return 2;
		if ((long)(r2 - r1) * (r2 - r1) > d)
			return 0;
		if ((long)(r2 - r1) * (r2 - r1) == d)
			return 1;
		return 3;
	}

// BEGIN CUT HERE
	public static void main(String[] args) {
		RETester.test(RadarFinder.class, "test.*");
	}

	public void test0() {
		RETester.eq(possibleLocations(0, 0, 13, 40, 0, 37), 2);
	}

	public void test1() {
		RETester.eq(possibleLocations(0, 0, 3, 0, 7, 4), 1);
	}

	public void test2() {
		RETester.eq(possibleLocations(0, 0, 5, 10, 10, 3), 0);
	}

	public void test3() {
		RETester.eq(possibleLocations(0, 0, 1, 0, 0, 1), -1);
	}

// END CUT HERE
}
