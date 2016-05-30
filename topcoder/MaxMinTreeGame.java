import java.util.*;

public class MaxMinTreeGame {
    public int findend(int[] edges, int[] costs) {
        int res;
        return res;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(MaxMinTreeGame.class, "test.*");
    }

	public void test0() {
		RETester.eq(findend(new int[] {0}, new int[] {4,6}), 6);
	}

	public void test1() {
		RETester.eq(findend(new int[] {0,1}, new int[] {4,6,5}), 5);
	}

	public void test2() {
		RETester.eq(findend(new int[] {0,1,2,3}, new int[] {0,1,0,1,0}), 0);
	}

	public void test3() {
		RETester.eq(findend(new int[] {0,0,0}, new int[] {5,1,2,3}), 3);
	}

	public void test4() {
		RETester.eq(findend(new int[] {0,0}, new int[] {3,2,5}), 5);
	}

// END CUT HERE
}
