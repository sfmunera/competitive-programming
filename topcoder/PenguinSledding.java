package topcoder;

import java.util.*;

public class PenguinSledding {
	
	boolean[][] adj;
	boolean[] visited;
	
	

    public long countDesigns(int n, int[] c1, int[] c2) {
        long res = 0;
        
        adj = new boolean[n][n];
        visited = new boolean[n];
        int m = c1.length;
        for (int i = 0; i < m; ++i)
        	adj[c1[i] - 1][c2[i] - 1] = adj[c2[i] - 1][c1[i] - 1] = true;
        
        return res;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(PenguinSledding.class, "test.*");
    }

	public void test0() {
		RETester.eq(countDesigns(2, new int[] {1}, new int[] {2}), 2L);
	}

	public void test1() {
		RETester.eq(countDesigns(4, new int[] {1,2,3}, new int[] {2,3,4}), 6L);
	}

	public void test2() {
		RETester.eq(countDesigns(6, new int[] {1,3,6}, new int[] {2,4,4}), 5L);
	}

	public void test3() {
		RETester.eq(countDesigns(50, new int[] {
			40, 40, 40, 40, 40, 40, 40, 40, 
			40, 40, 40, 40, 50, 40, 40, 40, 
			23, 4, 24, 40, 22, 40, 8, 40, 40,
			40, 34, 21, 40, 40, 38, 40, 40, 
			40, 40, 40, 28, 40, 40, 40, 40, 
			46, 13, 40, 40, 40, 47, 40, 40},
			new int[] {
			45, 42, 20, 48, 12, 32, 25, 10, 
			26, 39, 16, 2, 19, 43, 37, 17, 
			19, 19, 19, 18, 19, 27, 19, 29, 
			11, 36, 19, 19, 1, 41, 19, 35, 
			14, 33, 49, 3, 19, 7, 5, 19, 31, 
			19, 19, 6, 9, 15, 19, 44, 30}),
			68719493118L);
	}

	public void test4() {
		RETester.eq(countDesigns(36, new int[] {
			13, 24, 24, 20, 31, 16, 10, 36, 34, 32, 
			28, 5, 20, 29, 23, 2, 14, 4, 9, 5, 19, 
			21, 8, 1, 26, 27, 25, 15, 22, 30, 30, 
			6, 11, 7, 2, 35, 13, 29, 4, 12, 33, 18, 
			13, 14, 17, 35, 3},
			new int[] {
			10, 15, 27, 1, 29, 11, 5, 18, 33, 1, 9,
			2, 31, 6, 19, 10, 33, 18, 6, 27, 3, 22,
			4, 12, 31, 30, 34, 16, 7, 24, 3, 28, 15,
			21, 22, 8, 26, 20, 14, 32, 25, 17, 35,
			8, 36, 26, 23}),
			162L);
	}

// END CUT HERE
}
