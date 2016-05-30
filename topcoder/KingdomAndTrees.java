
import java.util.*;

public class KingdomAndTrees {
    public int minLevel(int[] height) {
    	int[] h = height.clone();
    	int N = h.length;
    	int ans = 0;
        for (int i = 1; i < N; ++i) {
        	if (h[i] <= h[i - 1]) {
        		int diff = (h[i - 1] - h[i]) / 2 + 1;
        		if (i == 1) {
        			int newh = Math.max(h[i - 1] - diff, 1);
        			h[i - 1] = newh;
        		}
        	}
        }
        for (int i = 0; i < N; ++i)
        	ans = Math.max(Math.abs(h[i] - height[i]), ans);
        
        return ans;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(KingdomAndTrees.class, "test.*");
    }

	public void test0() {
		RETester.eq(minLevel(new int[] {9, 5, 11}), 3);
	}

	public void test1() {
		RETester.eq(minLevel(new int[] {5, 8}), 0);
	}

	public void test2() {
		RETester.eq(minLevel(new int[] {1, 1, 1, 1, 1}), 4);
	}

	public void test3() {
		RETester.eq(minLevel(new int[] {548, 47, 58, 250, 2012}), 251);
	}

// END CUT HERE
}
