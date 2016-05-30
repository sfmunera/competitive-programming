import java.util.*;

public class EllysPairs {
    public int getDifference(int[] k) {
        Arrays.sort(k);
        
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < k.length / 2; ++i) {
        	max = Math.max(max, k[i] + k[k.length - 1 - i]);
        	min = Math.min(min, k[i] + k[k.length - 1 - i]);
        }
        return max - min;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(EllysPairs.class, "test.*");
    }

	public void test0() {
		RETester.eq(getDifference(new int[] {2, 6, 4, 3}), 1);
	}

	public void test1() {
		RETester.eq(getDifference(new int[] {1, 1, 1, 1, 1, 1}), 0);
	}

	public void test2() {
		RETester.eq(getDifference(new int[] {4, 2, 4, 2, 1, 3, 3, 7}), 2);
	}

	public void test3() {
		RETester.eq(getDifference(new int[] {5, 1, 8, 8, 13, 7, 6, 2, 1, 9, 5, 11, 3, 4}), 3);
	}

// END CUT HERE
}
