import java.util.*;

public class CandyBox {
    public double[] expectedScore(int C, int[] score, int S) {
        double[] res;
        return res;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(CandyBox.class, "test.*");
    }

	public void test0() {
		RETester.eq(expectedScore(10, new int[] {1, 10}, 0), new double[] {1.0, 10.0 });
	}

	public void test1() {
		RETester.eq(expectedScore(2, new int[] {1, 10}, 1), new double[] {4.0, 7.000000000000001 });
	}

	public void test2() {
		RETester.eq(expectedScore(1, new int[] {1, 4, 10}, 1), new double[] {5.0, 5.0, 5.0 });
	}

	public void test3() {
		RETester.eq(expectedScore(98, new int[] {13, 82, 74, 78, 12, 71, 81, 80, 30}, 154), new double[] {26.25622829378155, 74.87969915903301, 69.24219529059805, 72.06094722481552, 25.551540310227182, 67.12813133993495, 74.17501117547864, 73.47032319192427, 38.23592401420582 });
	}

// END CUT HERE
}
