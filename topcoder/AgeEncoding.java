
public class AgeEncoding {
	
	double getValue(String c, double f) {
		double val = 0.0;
		for (int i = c.length() - 1; i >= 0; --i)
			if (c.charAt(i) == '1')
				val += Math.pow(f, c.length() - 1 - i);
		
		return val;
	}
	
	boolean isOne(String c) {
		boolean ok = true;
		for (int i = 0; i < c.length() - 1; ++i)
			ok &= c.charAt(i) == '0';
		return ok && c.charAt(c.length() - 1) == '1';
	}
	
    public double getRadix(int age, String candlesLine) {
    	if (age == 1 && isOne(candlesLine))
    		return -2.0;
        double lo = 0.0;
        double hi = 1000.0;
        
        while (lo < hi - 1e-12) {
        	double mid = (lo + hi) / 2.0;
        	if (getValue(candlesLine, mid) > age - 1e-12)
        		hi = mid;
        	else
        		lo = mid;
        }
        if (Math.abs(lo - 1000.0) < 1e-9 || Math.abs(lo) < 1e-9)
        	return -1.0;
        return lo;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(AgeEncoding.class, "test.*");
    }

	public void test0() {
		RETester.eq(getRadix(10, "00010"), 10.0);
	}

	public void test1() {
		RETester.eq(getRadix(21, "10101"), 2.0);
	}

	public void test2() {
		RETester.eq(getRadix(6, "10100"), 1.414213562373095);
	}

	public void test3() {
		RETester.eq(getRadix(21, "10111111110111101111111100111111110111111111111100"), 0.9685012944510603);
	}

	public void test4() {
		RETester.eq(getRadix(16, "1"), -1.0);
	}

	public void test5() {
		RETester.eq(getRadix(1, "1"), -2.0);
	}

	public void test6() {
		RETester.eq(getRadix(1, "001000"), 1.0);
	}

// END CUT HERE
}
