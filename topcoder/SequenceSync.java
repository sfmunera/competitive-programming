package topcoder;

import java.util.*;

public class SequenceSync {
	
	final int INF = (int) 1e9;
	
    public int getLength(String[] transitions) {
        int N = transitions.length;
        
        int[][] adj = new int[N][N];
        for (int i = 0; i < N; ++i) {
        	Arrays.fill(adj[i], INF);
        	adj[i][i] = 0;
        	
        	String[] parts = transitions[i].split("[ ]+");
        	for (int k = 0; k < 4; ++k) {
        		int j = Integer.parseInt(parts[k]);
        		adj[i][j] = Math.min(adj[i][j], 1);
        	}
        }
        
        for (int k = 0; k < N; ++k)
        	for (int i = 0; i < N; ++i)
        		for (int j = 0; j < N; ++j)
        			adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
        
        int max = -1;
        for (int i = 0; i < N; ++i)
        	for (int j = 0; j < N; ++j)
        		if (adj[i][j] < INF)
        			max = Math.max(max, adj[i][j]);
        for (int i = 0; i < N; ++i)
        	System.out.println(Arrays.toString(adj[i]));
        return max;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(SequenceSync.class, "test.*");
    }

	public void test0() {
		RETester.eq(getLength(new String[] {
			"1 1 1 1",
			"1 1 1 2",
			"0 2 2 2"}),
			2);
	}

	public void test1() {
		RETester.eq(getLength(new String[] {
			"1 1 1 1",
			"2 2 2 2",
			"3 3 3 3",
			"0 0 0 0"}),
			-1);
	}

	public void test2() {
		RETester.eq(getLength(new String[] {"0 0 0 0"}), 0);
	}

	public void test3() {
		RETester.eq(getLength(new String[] {
			"1 1 1 0",
			"2 2 2 1",
			"3 3 3 2",
			"4 4 4 3",
			"5 5 5 5",
			"6 6 6 6",
			"7 7 7 0",
			"0 0 0 8",
			"8 8 8 8",
			"9 9 9 8"}),
			15);
	}

// END CUT HERE
}
