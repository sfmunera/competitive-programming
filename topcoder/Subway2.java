
public class Subway2 {
    public double minTime(int d, int a, int vf) {
    	double dhalf = d / 2.0;
        double t1 = (double)vf / a; // time until vf
        double t = Math.sqrt(2.0 * dhalf / a); // time at max acceleration
        
        if (Double.compare(t, t1) <= 0)
        	return 2.0 * t;
        double d1 = 0.5 * a * t1 * t1; // distance until vf
        double d2 = dhalf - d1;
        
        double t2 = d2 / vf;
        return 2.0 * (t1 + t2);
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(Subway2.class, "test.*");
    }

	public void test0() {
		RETester.eq(minTime(1, 2, 10), 1.4142135623730951);
	}

	public void test1() {
		RETester.eq(minTime(1, 1, 1), 2.0);
	}

	public void test2() {
		RETester.eq(minTime(10, 1, 1), 11.0);
	}

	public void test3() {
		RETester.eq(minTime(1, 10, 1), 1.1);
	}

	public void test4() {
		RETester.eq(minTime(778, 887, 384), 2.458961621570838);
	}

	public void test5() {
		RETester.eq(minTime(336, 794, 916), 1.301036207838119);
	}

// END CUT HERE
}
