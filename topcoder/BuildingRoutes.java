
public class BuildingRoutes {
    public int build(String[] dist, int T) {
    	int N = dist.length;
        int[][] D = new int[N][N];
        
        for (int i = 0; i < N; ++i)
        	for (int j = 0; j < N; ++j)
        		D[i][j] = dist[i].charAt(j) - '0';
        
        for (int k = 0; k < N; ++k)
        	for (int i = 0; i < N; ++i)
        		for (int j = 0; j < N; ++j)
        			D[i][j] = Math.min(D[i][j], D[i][k] + D[k][j]);
        
        int ans = 0;
        // count number of shortest paths i=>a->b=>j
        for (int a = 0; a < N; ++a)
        	for (int b = 0; b < N; ++b) {
        		int cnt = 0;
        		for (int i = 0; i < N; ++i)
        			for (int j = 0; j < N; ++j)
        				if (a != b && i != j && D[i][a] + (dist[a].charAt(b) - '0') + D[b][j] == D[i][j])
        					++cnt;
        		if (cnt >= T)
        			ans += dist[a].charAt(b) - '0';
        	}
        
        return ans;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(BuildingRoutes.class, "test.*");
    }

	public void test0() {
		RETester.eq(build(new String[] {
			"011",
			"101",
			"110"},
			1), 6);
	}

	public void test1() {
		RETester.eq(build(new String[] {
			"033",
			"309",
			"390"},
			1), 12);
	}

	public void test2() {
		RETester.eq(build(new String[] {
			"0123",
			"1023",
			"1203",
			"1230"},
			2), 5);
	}

	public void test3() {
		RETester.eq(build(new String[] {
			"05789654",
			"10347583",
			"65085479",
			"55602398",
			"76590934",
			"57939045",
			"12345608",
			"68647640"},
			3), 40);
	}

// END CUT HERE
}
