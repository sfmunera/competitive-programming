import java.util.*;

public class CentaurCompany {
    public double getvalue(int[] a, int[] b) {
        double res;
        return res;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(CentaurCompany.class, "test.*");
    }

	public void test0() {
		RETester.eq(getvalue(new int[] {1}, new int[] {2}), 0.0);
	}

	public void test1() {
		RETester.eq(getvalue(new int[] {1,1,1}, new int[] {2,3,4}), 0.125);
	}

	public void test2() {
		RETester.eq(getvalue(new int[] {1,2,3,2,2}, new int[] {2,3,4,5,6}), 0.375);
	}

	public void test3() {
		RETester.eq(getvalue(new int[] {1,2,3,4,5,6,7,8,9}, new int[] {2,3,4,5,6,7,8,9,10}), 0.41796875);
	}

	public void test4() {
		RETester.eq(getvalue(new int[] {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}, new int[] {2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36}), 15.500000001076842);
	}

	public void test5() {
		RETester.eq(getvalue(new int[] {10, 7, 2, 5, 6, 2, 4, 9, 7}, new int[] {8, 10, 10, 4, 1, 6, 2, 2, 3}), 0.646484375);
	}

// END CUT HERE
}
