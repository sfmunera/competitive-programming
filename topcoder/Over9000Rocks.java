
import java.util.*;

public class Over9000Rocks {
	
	class Pair implements Comparable<Pair> {
		int l, r;
		public Pair(int l, int r) {
			this.l = l; this.r = r;
		}
		public int compareTo(Pair p) {
			if (this.l != p.l)
				return this.l - p.l;
			return this.r - p.r;
		}
	}
	
    public int countPossibilities(int[] lowerBound, int[] upperBound) {
        int N = lowerBound.length;
        List<Pair> pairs = new ArrayList<Pair>();
        
        for (int mask = 1; mask < (1 << N); ++mask) {
        	int lower = 0;
        	int upper = 0;
        	
        	for (int i = 0; i < N; ++i)
        		if ((mask & (1 << i)) != 0) {
        			lower += lowerBound[i];
        			upper += upperBound[i];
        		}
        	if (upper > 9000)
        		pairs.add(new Pair(Math.max(9001, lower), upper));
        }
        Collections.sort(pairs);
        
        int ans = 0;
        int curlow = -1;
        int curup = -1;
        for (Pair p : pairs) {
        	if (curlow == -1) {
        		curlow = p.l;
        		curup = p.r;
        	} else {
        		if (p.l > curup) {
        			ans += curup - curlow + 1;
        			curlow = p.l;
        			curup = p.r;
        		} else {
	        		curlow = Math.min(curlow, p.l);
	        		curup = Math.max(curup, p.r);
        		}
        	}
        }
        if (curlow != -1)
        	ans += curup - curlow + 1;
        return ans;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(Over9000Rocks.class, "test.*");
    }

	public void test0() {
		RETester.eq(countPossibilities(new int[] {9000}, new int[] {9001}), 1);
	}

	public void test1() {
		RETester.eq(countPossibilities(new int[] {9000, 1, 10}, new int[] {9000, 2, 20}), 15);
	}

	public void test2() {
		RETester.eq(countPossibilities(new int[] {1001, 2001, 3001, 3001}, new int[] {1003, 2003, 3003, 3003}), 9);
	}

	public void test3() {
		RETester.eq(countPossibilities(new int[] {9000,90000,1,10}, new int[] {9000,90000,3,15}), 38);
	}

	public void test4() {
		RETester.eq(countPossibilities(new int[] {1,1,1,1,1,1}, new int[] {3,4,5,6,7,8}), 0);
	}

// END CUT HERE
}
