package topcoder;

public class Pillars {
	
	double length(int w, int dl) {
		return Math.sqrt((double)w * w + (double)dl * dl);
	}
	
    public double getExpectedLength(int w, int x, int y) {
    	if (x > y) {
    		int t = x;
    		x = y;
    		y = t;
    	}
    	
        double ans = (double) w * x;
        
        for (int dl = x; dl <= y - x; ++dl)
        	ans += (double)x * length(w, dl);
        for (int dl = 1; dl < x; ++dl)
        	ans += (double) (x + x - dl) * length(w, dl);
        for (int dl = y - x + 1; dl < y; ++dl)
        	ans += (double) (y - dl) * length(w, dl);
        
        return ans / (x * y);
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(Pillars.class, "test.*");
    }

	public void test0() {
		RETester.eq(getExpectedLength(1, 1, 1), 1.0);
	}

	public void test1() {
		RETester.eq(getExpectedLength(1, 5, 1), 2.387132965131785);
	}

	public void test2() {
		RETester.eq(getExpectedLength(2, 3, 15), 6.737191281760445);
	}

	public void test3() {
		RETester.eq(getExpectedLength(10, 15, 23), 12.988608956320535);
	}

// END CUT HERE
}
