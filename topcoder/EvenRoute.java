
public class EvenRoute {
    public String isItPossible(int[] x, int[] y, int wantedParity) {
        for (int i = 0; i < x.length; ++i)
        	if ((Math.abs(x[i]) + Math.abs(y[i])) % 2 == wantedParity)
        		return "CAN";
        return "CANNOT";
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(EvenRoute.class, "test.*");
    }

	public void test0() {
		RETester.eq(isItPossible(new int[] {-1,-1,1,1}, new int[] {-1,1,1,-1}, 0), "CAN");
	}

	public void test1() {
		RETester.eq(isItPossible(new int[] {-5,-3,2}, new int[] {2,0,3}, 1), "CAN");
	}

	public void test2() {
		RETester.eq(isItPossible(new int[] {1001, -4000}, new int[] {0,0}, 1), "CAN");
	}

	public void test3() {
		RETester.eq(isItPossible(new int[] {11, 21, 0}, new int[] {-20, 42, 7}, 0), "CANNOT");
	}

	public void test4() {
		RETester.eq(isItPossible(new int[] {0, 6}, new int[] {10, -20}, 1), "CANNOT");
	}

// END CUT HERE
}
