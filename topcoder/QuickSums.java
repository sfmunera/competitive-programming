import java.util.*;

public class QuickSums {
    public int minSums(String numbers, int sum) {
        int res;
        return res;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(QuickSums.class, "test.*");
    }

	public void test0() {
		RETester.eq(minSums("99999", 45), 4);
	}

	public void test1() {
		RETester.eq(minSums("1110", 3), 3);
	}

	public void test2() {
		RETester.eq(minSums("0123456789", 45), 8);
	}

	public void test3() {
		RETester.eq(minSums("99999", 100), -1);
	}

	public void test4() {
		RETester.eq(minSums("382834", 100), 2);
	}

	public void test5() {
		RETester.eq(minSums("9230560001", 71), 4);
	}

// END CUT HERE
}
