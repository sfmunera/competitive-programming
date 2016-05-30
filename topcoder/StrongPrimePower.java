
import java.util.*;

public class StrongPrimePower {
	
	boolean isPrime(int p) {
		if (p < 2)
			return false;
		if (p == 2)
			return true;
		if (p % 2 == 0)
			return false;
		for (int i = 3; i * i <= p; i += 2)
			if (p % i == 0)
				return false;
		return true;
	}
	
    public int[] baseAndExponent(String n) {
    	long num = Long.parseLong(n);
        for (int q = 2; q <= 64; ++q) {
        	double pd = Math.exp(Math.log((double)num) / (double)q);
        	int p = (int)Math.round(pd);
        	
        	if (!isPrime(p))
        		continue;
        	
        	long pow = 1;
        	for (int i = 1; i <= q; ++i)
        		pow *= p;
        	
        	if (pow == num)
        		return new int[]{p, q};
        }
        return new int[]{};
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(StrongPrimePower.class, "test.*");
    }

	public void test0() {
		RETester.eq(baseAndExponent("27"), new int[] {3, 3 });
	}

	public void test1() {
		RETester.eq(baseAndExponent("10"), new int[] { });
	}

	public void test2() {
		RETester.eq(baseAndExponent("7"), new int[] { });
	}

	public void test3() {
		RETester.eq(baseAndExponent("1296"), new int[] { });
	}

	public void test4() {
		RETester.eq(baseAndExponent("576460752303423488"), new int[] {2, 59 });
	}

	public void test5() {
		RETester.eq(baseAndExponent("999999874000003969"), new int[] {999999937, 2 });
	}

	public void test6() {
		RETester.eq(baseAndExponent("883600005640000009"), new int[] {940000003, 2});
	}
	
	public void test7() {
		RETester.eq(baseAndExponent("10885107702466060"), new int[] {});
	}

// END CUT HERE
}
