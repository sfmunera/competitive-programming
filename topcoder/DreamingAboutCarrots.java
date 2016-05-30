
public class DreamingAboutCarrots {
    public int carrotsBetweenCarrots(int x1, int y1, int x2, int y2) {
    	
    	if (x1 == x2)
    		return Math.abs(y2 - y1) - 1;
    	if (y1 == y2)
    		return Math.abs(x2 - x1) - 1;
    	
    	double m = (double)(y2 - y1) / (x2 - x1);
    	double b = y1 - m * x1;
    	
    	int ans = 0;
        for (int x = Math.min(x1, x2) + 1; x < Math.max(x1, x2); ++x)
        	for (int y = Math.min(y1, y2) + 1; y < Math.max(y1, y2); ++y)
        		if (Math.abs(m * x + b - y) < 1e-9)
        			++ans;
        return ans;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(DreamingAboutCarrots.class, "test.*");
    }

	public void test0() {
		RETester.eq(carrotsBetweenCarrots(1, 1, 5, 5), 3);
	}

	public void test1() {
		RETester.eq(carrotsBetweenCarrots(0, 0, 1, 1), 0);
	}

	public void test2() {
		RETester.eq(carrotsBetweenCarrots(50, 48, 0, 0), 1);
	}

	public void test3() {
		RETester.eq(carrotsBetweenCarrots(0, 0, 42, 36), 5);
	}

// END CUT HERE
}
