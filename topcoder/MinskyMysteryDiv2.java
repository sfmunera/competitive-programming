
public class MinskyMysteryDiv2 {
    public long computeAnswer(long N) {        
        if (N == 0 || N == 1)
        	return -1;
        
        for (long i = 2; i * i <= N; ++i)
        	if (N % i == 0)
        		return i + N / i;
        
        return N + 1;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(MinskyMysteryDiv2.class, "test.*");
    }

	public void test0() {
		RETester.eq(computeAnswer(2L), 3L);
	}

	public void test1() {
		RETester.eq(computeAnswer(3L), 4L);
	}

	public void test2() {
		RETester.eq(computeAnswer(4L), 4L);
	}

	public void test3() {
		RETester.eq(computeAnswer(15L), 8L);
	}

	public void test4() {
		RETester.eq(computeAnswer(24L), 14L);
	}

// END CUT HERE
}
