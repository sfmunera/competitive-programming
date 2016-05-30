
import java.util.*;

public class Family {
	
	static boolean[][] adj;
	static int N;
	static int[] color;
	
	static boolean dfs(int s, int c) {
		color[s] = c;
		
		for (int i = 0; i < N; ++i) {
			if (adj[s][i]) {
				if (color[i] >= 0 && color[i] == color[s])
					return false;
				if (color[i] < 0) {
					if (!dfs(i, 1 - c))
						return false;
				}
			}
		}
		return true;
	}
	
    public String isFamily(int[] parent1, int[] parent2) {
        N = parent1.length;
        
        color = new int[N];
        Arrays.fill(color, -1);
        adj = new boolean[N][N];
        
        for (int k = 0; k < N; ++k) {
        	int i = parent1[k];
        	int j = parent2[k];
        	if (i >= 0 && j >= 0)
        		adj[i][j] = adj[j][i] = true;
        }
        
        for (int i = 0; i < N; ++i)
        	if (color[i] < 0)
        		if (!dfs(i, 0))
        			return "Impossible";
        
        return "Possible";
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(Family.class, "test.*");
    }

	public void test0() {
		RETester.eq(isFamily(new int[] {-1,-1,0}, new int[] {-1,-1,1}), "Possible");
	}

	public void test1() {
		RETester.eq(isFamily(new int[] {-1,-1,-1,-1,-1}, new int[] {-1,-1,-1,-1,-1}), "Possible");
	}

	public void test2() {
		RETester.eq(isFamily(new int[] {-1,-1,0,0,1}, new int[] {-1,-1,1,2,2}), "Impossible");
	}

	public void test3() {
		RETester.eq(isFamily(new int[] {
			-1,-1,-1,-1,1,-1,0,5,6,-1,0,3,8,6}
			,
			new int[] {
			-1,-1,-1,-1,3,-1,4,6,5,-1,5,4,6,1}
			),
			"Possible");
	}

	public void test4() {
		RETester.eq(isFamily(new int[] {-1,-1,-1,2,2,-1,5,6,4,6,2,1,8,0,2,4,6,9,-1,16,-1,11}, new int[] {-1,-1,-1,1,0,-1,1,4,2,0,4,8,2,3,0,5,14,14,-1,7,-1,13}), "Impossible");
	}

// END CUT HERE
}
