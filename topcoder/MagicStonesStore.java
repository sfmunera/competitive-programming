package topcoder;

public class MagicStonesStore {
    public String ableToDivide(int n) {
        if (n == 1)
        	return "NO";
        return "YES";
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(MagicStonesStore.class, "test.*");
    }

	public void test0() {
		RETester.eq(ableToDivide(1), "NO");
	}

	public void test1() {
		RETester.eq(ableToDivide(2), "YES");
	}

	public void test2() {
		RETester.eq(ableToDivide(3), "YES");
	}

	public void test3() {
		RETester.eq(ableToDivide(5), "YES");
	}

// END CUT HERE
}
