import java.util.*;

public class MissingLCM {
	
	List<Integer> sieve(int N) {
		List<Integer> primes = new ArrayList<Integer>();
		boolean[] composite = new boolean[N + 1];
		
		for (int p = 2; p <= N; ++p) {
			if (!composite[p]) {
				primes.add(p);
				for (int i = p + p; i <= N; i += p) {
					composite[i] = true;
				}
			}
		}
		return primes;
	}
	
	int exponent(int x, int p) {
		int cnt = 0;
		while (x % p == 0) {
			++cnt;
			x /= p;
		}
		return cnt;
	}

    public int getMin(int N) {
    	List<Integer> primes = sieve(N);
    	
    	int ans = 2;
    	for (int p : primes) {
    		int max = 0;
    		int i;
    		for (i = p; i <= N; i += p) {
    			max = Math.max(max, exponent(i, p));
    		}
    		while (exponent(i, p) < max) {
    			i += p;
    		}
			ans = Math.max(ans, i);
    	}
    	return ans;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(MissingLCM.class, "test.*");
    }

	public void test0() {
		RETester.eq(getMin(1), 2);
	}

	public void test1() {
		RETester.eq(getMin(2), 4);
	}

	public void test2() {
		RETester.eq(getMin(3), 6);
	}

	public void test3() {
		RETester.eq(getMin(4), 8);
	}

	public void test4() {
		RETester.eq(getMin(5), 10);
	}

	public void test5() {
		RETester.eq(getMin(42), 82);
	}

	public void test6() {
		RETester.eq(getMin(999999), 1999966);
	}

// END CUT HERE
}
