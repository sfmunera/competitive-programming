
public class BiggestRectangleEasy {
    public int findArea(int N) {
    	int ans = 0;
        for (int a = 1; a <= N / 2; ++a) {
        	int b = N / 2 - a;
        	ans = Math.max(ans, a * b);
        }
        return ans;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(BiggestRectangleEasy.class, "test.*");
    }

	public void test0() {
		RETester.eq(findArea(11), 6);
	}

	public void test1() {
		RETester.eq(findArea(5), 1);
	}

	public void test2() {
		RETester.eq(findArea(64), 256);
	}

	public void test3() {
		RETester.eq(findArea(753), 35344);
	}

	public void test4() {
		RETester.eq(findArea(7254), 3288782);
	}

// END CUT HERE
}
