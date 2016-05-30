import java.util.*;

public class OlympicCandles {
    public int numberOfNights(int[] candles) {
        int res;
        return res;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(OlympicCandles.class, "test.*");
    }

	public void test0() {
		RETester.eq(numberOfNights(new int[] {2, 2, 2}), 3);
	}

	public void test1() {
		RETester.eq(numberOfNights(new int[] {2, 2, 2, 4}), 4);
	}

	public void test2() {
		RETester.eq(numberOfNights(new int[] {5, 2, 2, 1}), 3);
	}

	public void test3() {
		RETester.eq(numberOfNights(new int[] {1, 2, 3, 4, 5, 6}), 6);
	}

	public void test4() {
		RETester.eq(numberOfNights(new int[] {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}), 4);
	}

// END CUT HERE
}
