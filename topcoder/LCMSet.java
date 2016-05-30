
import java.util.*;

public class LCMSet {
	
	int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a % b);
	}
	
	int lcm(int a, int b) {
		return a * (b / gcd(a, b));
	}
	
	ArrayList<Integer> reduce(int[] x) {
		Arrays.sort(x);
        
        ArrayList<Integer> min = new ArrayList<Integer>();
        for (int i = 0; i < x.length; ++i) {
        	int lcm = 1;
        	for (int j = 0; j < i; ++j)
        		if (x[i] % x[j] == 0) {
        			lcm = lcm(lcm, x[j]);
        		}
        	if (lcm != x[i])
        		min.add(x[i]);
        }
        
        return min;
	}

    public String equal(int[] A, int[] B) {
        return reduce(A).equals(reduce(B)) ? "Equal" : "Not equal";
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(LCMSet.class, "test.*");
    }

	public void test0() {
		RETester.eq(equal(new int[] {2,3,4,12}, new int[] {2,3,4,6}), "Equal");
	}

	public void test1() {
		RETester.eq(equal(new int[] {4,9}, new int[] {6,36}), "Not equal");
	}

	public void test2() {
		RETester.eq(equal(new int[] {2,3,5,7,14,105}, new int[] {2,3,5,6,7,30,35}), "Equal");
	}

	public void test3() {
		RETester.eq(equal(new int[] {2,3,5,7,14,105}, new int[] {2,3,5,6,7,30,36}), "Not equal");
	}

	public void test4() {
		RETester.eq(equal(new int[] {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97}, new int[] {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97}), "Equal");
	}

	public void test5() {
		RETester.eq(equal(new int[] {999999999,1953125,512,1000000000}, new int[] {999999999,1953125,512}), "Equal");
	}

	public void test6() {
		RETester.eq(equal(new int[] {999999998,999999999,1000000000}, new int[] {999999999,1000000000}), "Not equal");
	}

// END CUT HERE
}
