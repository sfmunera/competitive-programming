import java.util.*;

public class InverseHaar1D {
    public int[] transform(int[] transformedData, int L) {
        int[] res;
        return res;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(InverseHaar1D.class, "test.*");
    }

	public void test0() {
		RETester.eq(transform(new int[] {101, -53}, 1), new int[] {24, 77 });
	}

	public void test1() {
		RETester.eq(transform(new int[] {3, 8, -1, -2}, 1), new int[] {1, 2, 3, 5 });
	}

	public void test2() {
		RETester.eq(transform(new int[] {11, -5, -1, -2}, 2), new int[] {1, 2, 3, 5 });
	}

	public void test3() {
		RETester.eq(transform(new int[] {
			369, 477, 451, 262, 47, 135, 
			-125, -2, 18, -23, 30, 101, 
			-5, -18, 54, -20, 11, 45, -5, 
			70, -24, 2, -50, 15, 55, -62, 
			-23, -17, 44, -8, -44, -52},
			3), new int[] {62, 51, 70, 25, 32, 37, 81, 11, 72, 96, 70, 68, 43, 93, 25, 10, 67, 12, 11, 73, 56, 79, 68, 85, 68, 24, 15, 23, 6, 50, 12, 64 });
	}

// END CUT HERE
}
