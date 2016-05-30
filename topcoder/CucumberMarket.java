
import java.util.*;

public class CucumberMarket {
    public String check(int[] price, int budget, int k) {
    	Arrays.sort(price);
    	int sum = 0;
        for (int i = 0; i < k; ++i)
        	sum += price[price.length - 1 - i];
        
        return budget >= sum ? "YES" : "NO";
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(CucumberMarket.class, "test.*");
    }

	public void test0() {
		RETester.eq(check(new int[] {1000,1,10,100}, 1110, 3), "YES");
	}

	public void test1() {
		RETester.eq(check(new int[] {1000,1,10,100}, 1109, 3), "NO");
	}

	public void test2() {
		RETester.eq(check(new int[] {33,4}, 33, 1), "YES");
	}

	public void test3() {
		RETester.eq(check(new int[] {1,1,1,1,1,1}, 2, 4), "NO");
	}

	public void test4() {
		RETester.eq(check(new int[] {1000,1000,1000,1000,1000,1000,1000,1000,1000}, 10000, 9), "YES");
	}

// END CUT HERE
}
