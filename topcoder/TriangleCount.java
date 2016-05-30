
public class TriangleCount {
    public int count(int N) {
        return N * (N + 2) * (2 * N + 1) / 8;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(TriangleCount.class, "test.*");
    }

	public void test0() {
		RETester.eq(count(2), 5);
	}

	public void test1() {
		RETester.eq(count(4), 27);
	}

	public void test2() {
		RETester.eq(count(100), 256275);
	}

// END CUT HERE
}
