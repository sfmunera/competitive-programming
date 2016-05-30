
public class KnightCircuit2 {
    public int maxSize(int w, int h) {
        if (w == 1 || h == 1) return 1;
        if (w == 2 || h == 2) {
        	int max = Math.max(w, h);
        	return (max + 1) / 2;
        }
        if (w == 3 && h == 3) return 8;
        return w * h;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(KnightCircuit2.class, "test.*");
    }

	public void test0() {
		RETester.eq(maxSize(1, 1), 1);
	}

	public void test1() {
		RETester.eq(maxSize(15, 2), 8);
	}

	public void test2() {
		RETester.eq(maxSize(100, 100), 10000);
	}

// END CUT HERE
}
