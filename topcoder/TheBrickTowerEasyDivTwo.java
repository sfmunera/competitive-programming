
import java.util.*;

public class TheBrickTowerEasyDivTwo {
    public int find(int redCount, int redHeight, int blueCount, int blueHeight) {
    	Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i <= redCount; ++i)
        	for (int j = 0; j <= blueCount; ++j) {
        		if (Math.abs(i - j) <= 1)
        			set.add(i * redHeight + j * blueHeight);
        	}
        return set.size() - 1;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(TheBrickTowerEasyDivTwo.class, "test.*");
    }

	public void test0() {
		RETester.eq(find(1, 2, 3, 4), 4);
	}

	public void test1() {
		RETester.eq(find(4, 4, 4, 7), 12);
	}

	public void test2() {
		RETester.eq(find(7, 7, 4, 4), 13);
	}

	public void test3() {
		RETester.eq(find(47, 47, 47, 47), 94);
	}

// END CUT HERE
}
