public class ProblemSets {
    public long maxSets(long E, long EM, long M, long MH, long H) {
        long low = 0;
        long high = Long.MAX_VALUE;
        
        long ans = 0;
        while (low <= high) {
        	long mid = (low + high) / 2;
        	long remEM = EM - Math.max(0, mid - E);
        	long remMH = MH - Math.max(0, mid - H);
        	if (remEM < 0 || remMH < 0 || remEM + remMH - Math.max(0, mid - M) < 0) {
        		high = mid - 1;
        	} else {
        		ans = mid;
        		low = mid + 1;
        	}
        }
        return ans;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(ProblemSets.class, "test.*");
    }

	public void test0() {
		RETester.eq(maxSets(2L, 2L, 1L, 2L, 2L), 3L);
	}

	public void test1() {
		RETester.eq(maxSets(100L, 100L, 100L, 0L, 0L), 0L);
	}

	public void test2() {
		RETester.eq(maxSets(657L, 657L, 657L, 657L, 657L), 1095L);
	}

	public void test3() {
		RETester.eq(maxSets(1L, 2L, 3L, 4L, 5L), 3L);
	}

	public void test4() {
		RETester.eq(maxSets(1000000000000000000L, 1000000000000000000L, 1000000000000000000L, 1000000000000000000L, 1000000000000000000L), 1666666666666666666L);
	}

// END CUT HERE
}
