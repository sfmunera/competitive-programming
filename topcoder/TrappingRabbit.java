
public class TrappingRabbit {
    public int findMinimumTime(int[] trapX, int[] trapY) {
        int res = Integer.MAX_VALUE;
        
        for (int i = 0; i < trapX.length; ++i)
        	res = Math.min(res, Math.abs(trapX[i] - 1) + Math.abs(trapY[i] - 1));
        
        return res;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(TrappingRabbit.class, "test.*");
    }

	public void test0() {
		RETester.eq(findMinimumTime(new int[] {4,6,8}, new int[] {1,2,1}), 3);
	}

	public void test1() {
		RETester.eq(findMinimumTime(new int[] {5,4,3}, new int[] {5,4,3}), 4);
	}

	public void test2() {
		RETester.eq(findMinimumTime(new int[] {3,4,5}, new int[] {5,4,3}), 6);
	}

	public void test3() {
		RETester.eq(findMinimumTime(new int[] {958,375,195,686,483,629,377}, new int[] {104,505,882,357,759,400,869}), 878);
	}

// END CUT HERE
}
