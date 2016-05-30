
import java.util.*;

public class MinimalTriangle {
    public double maximalArea(int length) {
        return Math.sqrt(3.0) / 4.0 * length * length;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(MinimalTriangle.class, "test.*");
    }

	public void test0() {
		RETester.eq(maximalArea(5), 10.825317547305485);
	}

	public void test1() {
		RETester.eq(maximalArea(10), 43.30127018922194);
	}

	public void test2() {
		RETester.eq(maximalArea(100000), 4.330127018922194E9);
	}

// END CUT HERE
}
