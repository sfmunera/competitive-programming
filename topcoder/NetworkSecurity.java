package topcoder;

import java.util.*;

public class NetworkSecurity {

	int N, M;
	Vertex[] G, Gt;
	boolean[] seen;
	int[] leader;
	Stack<Integer> sort;

	class Vertex {
		int id;
		List<Integer> adj;
		public Vertex(int id) {
			this.id = id;
			this.adj = new ArrayList<Integer>();
		}
	}
	
	void dfs(int u) {
		seen[u] = true;
		
		for (int v : G[u].adj)
			if (!seen[v])
				dfs(v);
		sort.push(u);
	}
	
	void dfs2(int u, int l) {
		seen[u] = true;
		leader[u] = l;
		
		for (int v : Gt[u].adj)
			if (!seen[v])
				dfs2(v, l);
	}
	
    public int secureNetwork(String[] clientCable, String[] serverCable) {
        N = clientCable.length;
        M = serverCable[0].length();
        
        G = new Vertex[N + M];
        Gt = new Vertex[N + M];
        seen = new boolean[N + M];
        for (int i = 0; i < N + M; ++i) {
        	Gt[i] = new Vertex(i);
        	G[i] = new Vertex(i);
        }
        
        for (int i = 0; i < N; ++i)
        	for (int j = 0; j < N; ++j)
        		if (clientCable[i].charAt(j) == 'Y') {
        			Gt[i].adj.add(j);
        			G[j].adj.add(i);
        		}
        for (int i = 0; i < N; ++i)
        	for (int j = 0; j < M; ++j)
        		if (serverCable[i].charAt(j) == 'Y') {
        			Gt[i].adj.add(N + j);
        			G[N + j].adj.add(i);
        		}

        sort = new Stack<Integer>();
        for (int i = 0; i < N + M; ++i) {
        	if (!seen[i])
        		dfs(i);
        }
        seen = new boolean[N + M];
        leader = new int[N + M];
        
        while (!sort.isEmpty()) {
        	int u = sort.pop();
        	if (!seen[u])
        		dfs2(u, u);
        }
        
        Set<Integer> set = new HashSet<Integer>();
        for (int i = N; i < N + M; ++i)
        	if (!G[i].adj.isEmpty())
        		set.add(leader[i]);
        
        return set.size();
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(NetworkSecurity.class, "test.*");
    }

	public void test0() {
		RETester.eq(secureNetwork(new String[] {
			"NYN"
			,"NNN"
			,"NYN"},
			new String[] {
			"YN"
			,"YN"
			,"NY"}),
			2);
	}

	public void test1() {
		RETester.eq(secureNetwork(new String[] {
			"NN"
			,"NN"},
			new String[] {
			"NNN"
			,"NNN"}),
			0);
	}

	public void test2() {
		RETester.eq(secureNetwork(new String[] {
			"NYNN"
			,"NNNN"
			,"NNNY"
			,"NNNN"},
			new String[] {
			"YYN"
			,"NNN"
			,"NNY"
			,"NNN"}),
			3);
	}

// END CUT HERE
}
