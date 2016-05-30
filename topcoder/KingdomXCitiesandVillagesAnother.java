import java.util.*;

public class KingdomXCitiesandVillagesAnother {
	
	int N;
	int[] p;
	int[] rank;
	List<Edge> edgeList;
	boolean[] isCity;
	
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
	
	double kruskal() {
		Collections.sort(edgeList);
		
		double cost = 0.0;
		initSet();
		
		for (int i = 0; i < N; ++i)
			for (int j = 0; j < N; ++j)
				if (isCity[i] && isCity[j] && !isSameSet(i, j))
					unionSet(i, j);
		
		for (Edge e : edgeList) {
			int u = e.u; int v = e.v; double w = e.w;
			if (!isSameSet(u, v)) {
				unionSet(u, v);
				cost += w;
			}
		}
		return cost;
	}
	
    public double determineLength(int[] cityX, int[] cityY, int[] villageX, int[] villageY) {
        N = cityX.length + villageX.length;
        isCity = new boolean[N];
        int[] X = new int[N];
        int[] Y = new int[N];
        
        for (int i = 0; i < cityX.length; ++i) {
        	isCity[i] = true;
        	X[i] = cityX[i];
        	Y[i] = cityY[i];
        }
        for (int i = 0; i < villageX.length; ++i) {
        	X[i + cityX.length] = villageX[i];
        	Y[i + cityX.length] = villageY[i];
        }
        
        edgeList = new ArrayList<Edge>();
        for (int i = 0; i < N; ++i)
        	for (int j = 0; j < N; ++j)
        		if (i != j) {
        			long dx = X[i] - X[j];
        			long dy = Y[i] - Y[j];
        			double d = Math.sqrt(dx * dx + dy * dy);
        			edgeList.add(new Edge(i, j, d));
        		}
        
        return kruskal();
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(KingdomXCitiesandVillagesAnother.class, "test.*");
    }

	public void test0() {
		RETester.eq(determineLength(new int[] {1}, new int[] {1}, new int[] {2,3}, new int[] {1,1}), 2.0);
	}

	public void test1() {
		RETester.eq(determineLength(new int[] {1,2}, new int[] {1,1}, new int[] {1,2}, new int[] {2,2}), 2.0);
	}

	public void test2() {
		RETester.eq(determineLength(new int[] {0}, new int[] {0}, new int[] {2}, new int[] {2}), 2.8284271247461903);
	}

// END CUT HERE
}
