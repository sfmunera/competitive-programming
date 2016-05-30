import java.util.*;

public class Cut {
    public int getMaximum(int[] eelLengths, int maxCuts) {
        int res = 0;

        Arrays.sort(eelLengths);
        for (int x : eelLengths)
        	if (x % 10 == 0) {
        		if (x / 10 - 1 <= maxCuts) {
        			maxCuts -= x / 10 - 1;
        			res += x / 10;
        		} else {
        			res += maxCuts;
        			maxCuts = 0;
        		}
        	}
        for (int x : eelLengths)
        	if (x % 10 != 0) {
        		if (x / 10 <= maxCuts) {
        			maxCuts -= x / 10;
        			res += x / 10;
        		} else {
        			res += maxCuts;
        			maxCuts = 0;
        		}
        	}
        
        return res;
    }
 // BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(Cut.class, "test.*");
    }

	public void test0() {
		RETester.eq(getMaximum(new int[] {13, 20, 13}, 2), 3);
	}

	public void test1() {
		RETester.eq(getMaximum(new int[] {5, 5, 5, 5}, 2), 0);
	}

	public void test2() {
		RETester.eq(getMaximum(new int[] {34, 10, 48}, 4), 5);
	}

	public void test3() {
		RETester.eq(getMaximum(new int[] {30, 50, 30, 50}, 350), 16);
	}

// END CUT HERE

}
