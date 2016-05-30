
public class FoxAndGCDLCM {
	
	long gcd(long a, long b) {
		return b == 0 ? a : gcd(b, a % b);
	}
	
    public long get(long G, long L) {
        if (L % G != 0) return -1;
        
        long res = Long.MAX_VALUE;
        long D = L / G;
        for (long a = 1; a * a <= D; ++a) {
        	if (D % a == 0) {
        		long b = D / a;
        		if (gcd(a, b) == 1)
        			res = Math.min(res, a + b);
        	}
        }
        return G * res;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(FoxAndGCDLCM.class, "test.*");
    }

	public void test0() {
		RETester.eq(get(2L, 20L), 14L);
	}

	public void test1() {
		RETester.eq(get(5L, 8L), -1L);
	}

	public void test2() {
		RETester.eq(get(1000L, 100L), -1L);
	}

	public void test3() {
		RETester.eq(get(100L, 1000L), 700L);
	}

	public void test4() {
		RETester.eq(get(10L, 950863963000L), 6298430L);
	}

// END CUT HERE
}
