
import java.util.*;

public class TheBrickTowerMediumDivTwo {
	
	void swap(int[] c, int i, int j) {
		int t = c[i];
		c[i] = c[j];
		c[j] = t;
	}
	
	boolean nextPermutation(int[] c) {
		  int n = c.length;
		  int k = -1;
		  for (int i = n - 2; i >= 0; --i)
		    if (c[i] < c[i + 1]) {
		      k = i;
		      break;
		    }
		  if (k == -1) return false;
		  int l = 0;
		  for (int i = n - 1; i >= 0; --i)
		    if (c[k] < c[i]) {
		      l = i;
		      break;
		    }
		  swap(c, k, l);
		  for (int i = k + 1; i < (n + k + 1) / 2; ++i)
		    swap(c, i, n + k - i);
		  return true;
	}
	
	boolean lessThan(int[] a, int[] b) {
		for (int i = 0; i < a.length; ++i) {
			if (a[i] == b[i])
				continue;
			if (a[i] > b[i])
				return false;
			if (a[i] < b[i])
				return true;
		}
		return false;
	}
	
	public int[] find(int[] heights) {
        int min = Integer.MAX_VALUE;
        int[] h = heights.clone();
        Arrays.sort(h);
        int n = h.length;
        int[] res = new int[n];
        Arrays.fill(res, Integer.MAX_VALUE);
        do {
        	int sum = 0;
        	for (int i = 1; i < n; ++i)
        		sum += Math.max(h[i], h[i - 1]);
        	if (sum <= min) {
    			min = sum;
    			boolean[] done = new boolean[n];
    			int[] tmp = new int[n];
    			for (int j = 0; j < n; ++j)
    				for (int k = 0; k < n; ++k)
    					if (!done[k] && heights[k] == h[j]) {
    						tmp[j] = k;
    						done[k] = true;
    						break;
    					}
    			if (lessThan(tmp, res))
    				res = tmp.clone();
    		}
        } while (nextPermutation(h));
        return res;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(TheBrickTowerMediumDivTwo.class, "test.*");
    }

	public void test0() {
		RETester.eq(find(new int[] {4, 7, 5}), new int[] {0, 2, 1 });
	}

	public void test1() {
		RETester.eq(find(new int[] {4, 4, 4, 4, 4, 4, 4}), new int[] {0, 1, 2, 3, 4, 5, 6 });
	}

	public void test2() {
		RETester.eq(find(new int[] {2, 3, 3, 2}), new int[] {0, 3, 1, 2 });
	}

	public void test3() {
		RETester.eq(find(new int[] {13, 32, 38, 25, 43, 47, 6}), new int[] {0, 6, 3, 1, 2, 4, 5 });
	}

// END CUT HERE
}
