package topcoder;

import java.util.*;

public class StrongEconomy {
    public long earn(long n, long k, long price, long target) {
    	long ans = 0;
    	long gold = 0;
        while (gold < target) {
        	
        	++ans;
        	gold += n * k;
        	if (gold >= target)
        		break;
        	//System.out.println(ans + " " + gold);
        	long toSpend = gold / price;
        	gold -= toSpend * price;
        	long n1 = (n + k + toSpend) / 2;
        	long n2 = n + k + toSpend - n1;
        	n = n1;
        	k = n2;
        	/*if (gold >= price) {
	        	if (n < k)
	        		++n;
	        	else
	        		++k;
	        	gold -= price;
        	}*/
        }
        
        return ans;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(StrongEconomy.class, "test.*");
    }

	public void test0() {
		RETester.eq(earn(2L, 1L, 2L, 10L), 4L);
	}

	public void test1() {
		RETester.eq(earn(2L, 1L, 2L, 9L), 3L);
	}

	public void test2() {
		RETester.eq(earn(1L, 1L, 500000L, 1000002L), 1000001L);
	}

	public void test3() {
		RETester.eq(earn(5L, 4L, 15L, 100L), 5L);
	}

// END CUT HERE
}
