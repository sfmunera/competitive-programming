import java.util.*;

public class Coversta {
    public int place(String[] a, int[] x, int[] y) {
        int res;
        return res;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(Coversta.class, "test.*");
    }

	public void test0() {
		RETester.eq(place(new String[] {
			"11",
			"11"},
			new int[] {0,0}, new int[] {0,1}), 4);
	}

	public void test1() {
		RETester.eq(place(new String[] {
			"11",
			"11"},
			new int[] {0,1}, new int[] {0,1}), 3);
	}

	public void test2() {
		RETester.eq(place(new String[] {
			"15",
			"61"},
			new int[] {0}, new int[] {0}), 11);
	}

	public void test3() {
		RETester.eq(place(new String[] {
			"151",
			"655",
			"661"},
			new int[] {0,0,-1}, new int[] {0,1,0}), 33);
	}

	public void test4() {
		RETester.eq(place(new String[] {
			"303",
			"333",
			"000"},
			new int[] {-1,-1}, new int[] {-1,1}), 12);
	}

	public void test5() {
		RETester.eq(place(new String[] {
			"0000000",
			"1010101"}
			,
			new int[] {-1,-1}, new int[] {-1,1}), 0);
	}

// END CUT HERE
}
