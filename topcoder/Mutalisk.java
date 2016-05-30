import java.util.*;

public class Mutalisk {
    public int minimalAttacks(int[] x) {
        int res;
        return res;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(Mutalisk.class, "test.*");
    }

	public void test0() {
		RETester.eq(minimalAttacks(new int[] {12,10,4}), 2);
	}

	public void test1() {
		RETester.eq(minimalAttacks(new int[] {54,18,6}), 6);
	}

	public void test2() {
		RETester.eq(minimalAttacks(new int[] {1,1,1,1,1,1,1,1,1,1}), 4);
	}

	public void test3() {
		RETester.eq(minimalAttacks(new int[] {55,60,53}), 13);
	}

	public void test4() {
		RETester.eq(minimalAttacks(new int[] {60}), 7);
	}

	public void test5() {
		RETester.eq(minimalAttacks(new int[] {60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60}), 93);
	}

// END CUT HERE
}
