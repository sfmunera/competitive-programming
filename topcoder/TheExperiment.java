import java.util.*;

public class TheExperiment {
    public int countPlacements(String[] intensity, int M, int L, int A, int B) {
        int res;
        return res;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(TheExperiment.class, "test.*");
    }

	public void test0() {
		RETester.eq(countPlacements(new String[] {"341156"}, 3, 3, 6, 10), 2);
	}

	public void test1() {
		RETester.eq(countPlacements(new String[] {"999112999"}, 2, 4, 21, 30), 2);
	}

	public void test2() {
		RETester.eq(countPlacements(new String[] {"111"}, 2, 2, 2, 3), 0);
	}

	public void test3() {
		RETester.eq(countPlacements(new String[] {"59059", "110", "1132230231"}, 1, 5, 10, 20), 6);
	}

	public void test4() {
		RETester.eq(countPlacements(new String[] {"111111111111111111111111", "111111111111111111111111111", "11111111111111111111111"}, 12, 8, 4, 2700), 418629948);
	}

// END CUT HERE
}
