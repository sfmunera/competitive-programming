import java.util.*;

public class TimeTravellingSalesman {
	int N;
	int[] p;
	int[] rank;
	List<Edge> edgeList;
	
	void initSet() {
		p = new int[N];
		rank = new int[N];
		for (int i = 0; i < N; ++i)
			p[i] = i;
	}
	
	int findSet(int i) {
		return p[i] == i ? i : (p[i] = findSet(p[i]));
	}
	
	void unionSet(int i, int j) {
		int pi = findSet(i);
		int pj = findSet(j);
		if (rank[pi] > rank[pj])
			p[pj] = pi;
		else
			p[pi] = pj;
		if (rank[pi] == rank[pj])
			++rank[pj];
	}
	
	boolean isSameSet(int i, int j) {
		return findSet(i) == findSet(j);
	}
	
	class Edge implements Comparable<Edge> {
		int u, v;
		double w;
		public Edge(int u, int v, double w) {
			this.u = u; this.v = v; this.w = w;
		}
		public int compareTo(Edge e) {
			return Double.compare(this.w, e.w);
		}
	}
	
	long kruskal() {
		Collections.sort(edgeList);
		
		long cost = 0;
		initSet();

		for (Edge e : edgeList) {
			int u = e.u; int v = e.v; double w = e.w;
			if (!isSameSet(u, v)) {
				unionSet(u, v);
				cost += w;
			}
		}
		
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < N; ++i)
			set.add(findSet(i));
		if (set.size() != 1)
			return -1;
		return cost;
	}
    public long determineCost(int _N, String[] roads) {
    	N = _N;
        String cat = "";
        for (String s : roads)
        	cat += s;
        
        String[] parts = cat.split("[ ]");
        
        edgeList = new ArrayList<Edge>();
        for (String s : parts) {
        	String[] parts2 = s.split("[,]");
        	int u = Integer.parseInt(parts2[0]);
        	int v = Integer.parseInt(parts2[1]);
        	int w = Integer.parseInt(parts2[2]);
        	edgeList.add(new Edge(u, v, w));
        }
        
        return kruskal();
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(TimeTravellingSalesman.class, "test.*");
    }

	public void test0() {
		RETester.eq(determineCost(3, new String[] {"0,1,1 0,2,1 1,2,2"}), 2L);
	}

	public void test1() {
		RETester.eq(determineCost(6, new String[] {"0,1,2 1,4,2 4,3,3 2,4,4 0,5,3"}), 14L);
	}

	public void test2() {
		RETester.eq(determineCost(3, new String[] {"0,2,2"}), -1L);
	}

	public void test3() {
		RETester.eq(determineCost(4, new String[] {"1,0",",10","0 2,1",",584 3,2",",754"}), 1438L);
	}

// END CUT HERE
}
