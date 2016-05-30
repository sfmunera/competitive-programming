import java.util.*;

public class DengklekTryingToSleep {
    public int minDucks(int[] ducks) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for (int i = 0; i < ducks.length; ++i) {
        	min = Math.min(min, ducks[i]);
        	max = Math.max(max, ducks[i]);
        }
        
        return max - min + 1 - ducks.length;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(DengklekTryingToSleep.class, "test.*");
    }

	public void test0() {
		RETester.eq(minDucks(new int[] {5, 3, 2}), 1);
	}

	public void test1() {
		RETester.eq(minDucks(new int[] {58}), 0);
	}

	public void test2() {
		RETester.eq(minDucks(new int[] {9, 3, 6, 4}), 3);
	}

	public void test3() {
		RETester.eq(minDucks(new int[] {7, 4, 77, 47, 74, 44}), 68);
	}

	public void test4() {
		RETester.eq(minDucks(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}), 0);
	}

// END CUT HERE
}
