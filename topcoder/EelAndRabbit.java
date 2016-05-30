
import java.util.*;

public class EelAndRabbit {

    public int getmax(int[] l, int[] t) {
    	ArrayList<Integer> points = new ArrayList<Integer>();
    	
    	for (int i = 0; i < l.length; ++i) {
    		points.add(t[i]);
    		points.add(t[i] + l[i]);
    	}
    	
    	long[] set = new long[points.size()];
    	for (int i = 0; i < points.size(); ++i) {
    		int p = points.get(i);
    		for (int j = 0; j < l.length; ++j)
    			if (p >= t[j] && p <= t[j] + l[j])
    				set[i] |= (1L << j);
    	}
    	
    	int ans = 0;
    	for (int i = 0; i < points.size(); ++i)
    		for (int j = 0; j < points.size(); ++j)
    			ans = Math.max(ans, Long.bitCount(set[i] | set[j]));
    	
    	return ans;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(EelAndRabbit.class, "test.*");
    }

	public void test0() {
		RETester.eq(getmax(new int[] {2, 4, 3, 2, 2, 1, 10}, new int[] {2, 6, 3, 7, 0, 2, 0}), 6);
	}

	public void test1() {
		RETester.eq(getmax(new int[] {1, 1, 1}, new int[] {2, 0, 4}), 2);
	}

	public void test2() {
		RETester.eq(getmax(new int[] {1}, new int[] {1}), 1);
	}

	public void test3() {
		RETester.eq(getmax(new int[] {8, 2, 1, 10, 8, 6, 3, 1, 2, 5}, new int[] {17, 27, 26, 11, 1, 27, 23, 12, 11, 13}), 7);
	}

// END CUT HERE
}
