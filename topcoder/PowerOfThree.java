import java.util.*;

public class PowerOfThree {
    public String ableToGet(int x, int y) {
        String res;
        return res;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(PowerOfThree.class, "test.*");
    }

	public void test0() {
		RETester.eq(ableToGet(1, 3), "Possible");
	}

	public void test1() {
		RETester.eq(ableToGet(0, 2), "Possible");
	}

	public void test2() {
		RETester.eq(ableToGet(1, 9), "Impossible");
	}

	public void test3() {
		RETester.eq(ableToGet(3, 0), "Impossible");
	}

	public void test4() {
		RETester.eq(ableToGet(1, 1), "Impossible");
	}

	public void test5() {
		RETester.eq(ableToGet(-6890, 18252), "Possible");
	}

	public void test6() {
		RETester.eq(ableToGet(1000000000, -1000000000), "Impossible");
	}

	public void test7() {
		RETester.eq(ableToGet(0, 0), "Possible");
	}

// END CUT HERE
}
