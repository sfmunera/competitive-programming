package topcoder;

import java.util.*;

public class OddEvenTree {
	
	List<Pair> ans = null;
	boolean[] seen;
	
	class Pair {
		int f, s;
		public Pair(int f, int s) {
			this.f = f;
			this.s = s;
		}
		@Override public String toString() {
			return "(" + f + ", " + s + ")";
		}
	}
	
	void dfs(int u, String[] x) {
		boolean done = true;
		for (int i = 0; i < x.length; ++i) {
			if (!seen[i]) {
				done = false;
			}
		}
		if (done) {
			return;
		}
		
		for (int i = 0; i < x.length; ++i) {
			if (x[u].charAt(i) == 'O' && !seen[i]) {
				seen[i] = true;
				ans.add(new Pair(u, i));
				dfs(i, x);
				seen[i] = false;
				ans.remove(ans.size() - 1);
			}
		}
		
	}
	
	boolean diagonalEven(String[] x) {
		int N = x.length;
        for (int i = 0; i < N; ++i) {
        	if (x[i].charAt(i) != 'E') {
        		return false;
        	}
        }
        return true;
	}
	
	boolean isSymmetric(String[] x) {
		int N = x.length;
        for (int i = 0; i < N; ++i) {
        	for (int j = i + 1; j < N; ++j) {
        		if (x[i].charAt(j) != x[j].charAt(i)) {
        			return false;
        		}
        	}
        }
        return true;
	}
	
	boolean hasOddInRows(String[] x) {
		int N = x.length;
        for (int i = 0; i < N; ++i) {
        	int odds = 0;
        	for (int j = 0; j < N; ++j) {
        		if (x[i].charAt(j) == 'O') {
        			++odds;
        		}
        	}
        	if (odds == 0) {
        		return false;
        	}
        }
        return true;
	}
	
    public int[] getTree(String[] x) {
    	int N = x.length;
        if (!diagonalEven(x) || !isSymmetric(x) || !hasOddInRows(x)) {
        	return new int[]{-1};
        }
        ans = new ArrayList<Pair>();
        seen = new boolean[N];
        seen[0] = true;
        dfs(0, x);
        
        if (ans.isEmpty()) {
        	return new int[]{-1};
        }
        
        assert ans.size() == N - 1;
        
        int[] res = new int[2 * N - 2];
        for (int i = 0; i < N - 1; ++i) {
        	res[2 * i] = ans.get(i).f;
        	res[2 * i + 1] = ans.get(i).s;
        }
        
        return res;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(OddEvenTree.class, "test.*");
    }

	public void test0() {
		RETester.eq(getTree(new String[] {
			"EOE",
			"OEO",
			"EOE"}),
			new int[] {0, 1, 2, 1 });
	}

	public void test1() {
		RETester.eq(getTree(new String[] {
			"EO",
			"OE"}),
			new int[] {0, 1 });
	}

	public void test2() {
		RETester.eq(getTree(new String[] {
			"OO",
			"OE"}),
			new int[] {-1 });
	}

	public void test3() {
		RETester.eq(getTree(new String[] {
			"EO",
			"EE"}),
			new int[] {-1 });
	}

	public void test4() {
		RETester.eq(getTree(new String[] {
			"EOEO",
			"OEOE",
			"EOEO",
			"OEOE"}),
			new int[] {0, 1, 0, 3, 2, 1 });
	}
	
	public void test5() {
		RETester.eq(getTree(new String[] {
			"EOO",
			"OEE",
			"OEE"}),
			new int[] {0, 1, 0, 2 });
	}

// END CUT HERE
}
