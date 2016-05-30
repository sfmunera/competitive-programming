
import java.util.*;

public class TheAlmostLuckyNumbersDivTwo {
	
	public boolean almostLucky(int x) {
		int cnt = 0;
		while (x > 0) {
			int d = x % 10;
			if (d != 4 && d != 7)
				++cnt;
			x /= 10;
		}
		
		return cnt <= 1;
	}
	
	public int find(int a, int b) {
		int cnt = 0;
		for (int i = a; i <= b; ++i)
			if (almostLucky(i))
				++cnt;
		return cnt;
	}

// BEGIN CUT HERE
	public static void main(String[] args) {
		RETester.test(TheAlmostLuckyNumbersDivTwo.class, "test.*");
	}

	public void test0() {
		RETester.eq(find(4, 7), 4);
	}

	public void test1() {
		RETester.eq(find(8, 19), 4);
	}

	public void test2() {
		RETester.eq(find(28, 33), 0);
	}

	public void test3() {
		RETester.eq(find(1234, 4321), 36);
	}

// END CUT HERE
}
