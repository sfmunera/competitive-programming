
public class PolygonTraversal {
	int N;
	int[] points;
	boolean[][] seen;
	long[][] dp;
	
	long go(int mask, int p) {
		if (mask == (1 << N) - 1 && p == points[0] - 1) return 1;
		
		if (seen[mask][p]) return dp[mask][p];
		
		seen[mask][p] = true;
		
		long ans = 0;
		for (int i = 0; i < N; ++i) {
			if ((i + 1) % N == p || (p + 1) % N == i) continue; // cannot be adjacent
			if ((mask & (1 << i)) > 0) continue; // has to be not visited
			boolean ok1 = false;
			for (int j = (i + 1) % N; j != p; j = (j + 1) % N)
				if ((mask & (1 << j)) > 0 || j == points[0] - 1) {
					ok1 = true;
					break;
				}
			boolean ok2 = false;
			for (int j = (p + 1) % N; j != i; j = (j + 1) % N)
				if ((mask & (1 << j)) > 0 || j == points[0] - 1) {
					ok2 = true;
					break;
				}
			
			if (ok1 && ok2) {
				ans += go(mask | (1 << i), i);
			}
		}
		return dp[mask][p] = ans;
	}
	
    public long count(int _N, int[] _points) {
    	N = _N;
    	points = _points;
    	
        int mask = 0;
        for (int i = 1; i < points.length; ++i)
        	mask |= (1 << (points[i] - 1));
        
        seen = new boolean[1 << N][N];
        dp = new long[1 << N][N];
        
        return go(mask, points[points.length - 1] - 1);
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(PolygonTraversal.class, "test.*");
    }

	public void test0() {
		RETester.eq(count(5, new int[] {1, 3, 5}), 1L);
	}

	public void test1() {
		RETester.eq(count(6, new int[] {1, 4, 2}), 1L);
	}

	public void test2() {
		RETester.eq(count(7, new int[] {2, 4, 7}), 2L);
	}

	public void test3() {
		RETester.eq(count(7, new int[] {1, 2, 3, 4, 6, 5}), 0L);
	}

	public void test4() {
		RETester.eq(count(18, new int[] {1, 7, 18}), 4374612736L);
	}

// END CUT HERE
}
