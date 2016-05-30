
public class TeamBuilder {
    public int[] specialLocations(String[] paths) {
        int N = paths.length;
        boolean[][] adj = new boolean[N][N];
        
        for (int i = 0; i < N; ++i)
        	for (int j = 0; j < N; ++j)
        		if (paths[i].charAt(j) == '1')
        			adj[i][j] = true;
        
        for (int k = 0; k < N; ++k)
        	for (int i = 0; i < N; ++i)
        		for (int j = 0; j < N; ++j)
        			adj[i][j] |= adj[i][k] & adj[k][j];
        
        int ans1 = 0;
        int ans2 = 0;
        
        for (int i = 0; i < N; ++i) {
        	int cnt = 0;
        	for (int j = 0; j < N; ++j)
        		if (i != j && adj[i][j])
        			++cnt;
        	if (cnt == N - 1)
        		++ans1;
        }
        
        for (int i = 0; i < N; ++i) {
        	int cnt = 0;
        	for (int j = 0; j < N; ++j)
        		if (i != j && adj[j][i])
        			++cnt;
        	if (cnt == N - 1)
        		++ans2;
        }
        
        return new int[]{ans1, ans2};
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(TeamBuilder.class, "test.*");
    }

	public void test0() {
		RETester.eq(specialLocations(new String[] {"010","000","110"}), new int[] { 1,  1 });
	}

	public void test1() {
		RETester.eq(specialLocations(new String[] {"0010","1000","1100","1000"}), new int[] { 1,  3 });
	}

	public void test2() {
		RETester.eq(specialLocations(new String[] {"01000","00100","00010","00001","10000"}), new int[] { 5,  5 });
	}

	public void test3() {
		RETester.eq(specialLocations(new String[] {"0110000","1000100","0000001","0010000","0110000","1000010","0001000"}), new int[] { 1,  3 });
	}

// END CUT HERE
}
