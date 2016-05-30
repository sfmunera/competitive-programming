
public class IncubatorEasy {
	
	boolean[] isMagical;
	boolean[] isProtected;
	boolean[][] adj;
	int N;
	
	void dfs(int u) {
		
		for (int v = 0; v < N; ++v)
			if (adj[u][v] && !isProtected[v]) {
				isProtected[v] = true;
				dfs(v);
			}
	}
	
    public int maxMagicalGirls(String[] love) {
        N = love.length;
        adj = new boolean[N][N];
        
        for (int i = 0; i < N; ++i)
        	for (int j = 0; j < N; ++j)
        		if (love[i].charAt(j) == 'Y')
        			adj[i][j] = true;
        
        int ans = 0;
        for (int mask = 1; mask < (1 << N); ++mask) {
        	isProtected = new boolean[N];
        	isMagical = new boolean[N];
        	for (int i = 0; i < N; ++i) {
        		if ((mask & (1 << i)) != 0) {
        			isMagical[i] = true;
        			dfs(i);
        		}
        	}

        	int cnt = 0;
        	for (int i = 0; i < N; ++i)
        		if (isMagical[i] && !isProtected[i])
        			++cnt;
        	
        	ans = Math.max(ans, cnt);
        }
        
        return ans;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(IncubatorEasy.class, "test.*");
    }

	public void test0() {
		RETester.eq(maxMagicalGirls(new String[] {"NY","NN"}), 1);
	}

	public void test1() {
		RETester.eq(maxMagicalGirls(new String[] {"NYN", "NNY", "NNN"}), 1);
	}

	public void test2() {
		RETester.eq(maxMagicalGirls(new String[] {"NNYNN","NNYNN","NNNYY","NNNNN","NNNNN"}), 2);
	}

	public void test3() {
		RETester.eq(maxMagicalGirls(new String[] {"NNNNN","NYNNN","NYNYN","YNYNN","NNNNN"}), 2);
	}

	public void test4() {
		RETester.eq(maxMagicalGirls(new String[] {"NNNNN","NNNNN","NNNNN","NNNNN","NNNNN"}), 5);
	}

	public void test5() {
		RETester.eq(maxMagicalGirls(new String[] {"Y"}), 0);
	}

// END CUT HERE
}
