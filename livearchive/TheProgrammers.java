package livearchive;

import java.util.*;

public class TheProgrammers {
	
	static int size;
	static int[][] residual;
	static int[] prev;
	static List<List<Integer>> graph;
	
	static int maxFlow(int s, int t) {
		int ans = 0;
		while (true) {
			Arrays.fill(prev, -1);
			Queue<Integer> Q = new LinkedList<Integer>();
			Q.offer(s);
			while (!Q.isEmpty() && prev[t] == -1) {
				int u = Q.poll();
				for (int v : graph.get(u)) {
					if (v != s && prev[v] == -1 && residual[u][v] > 0) {
						prev[v] = u;
						Q.offer(v);
					}
				}
			}
			
			if (prev[t] == -1) break;
			
			int bottleneck = Integer.MAX_VALUE;
			for (int v = t, u = prev[v]; u != -1; v = u, u = prev[v]) {
				bottleneck = Math.min(bottleneck, residual[u][v]);
			}
			for (int v = t, u = prev[v]; u != -1; v = u, u = prev[v]) {
				residual[u][v] -= bottleneck;
				residual[v][u] += bottleneck;
			}
			
			ans += bottleneck;
		}
		return ans;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt();
		while (T-- > 0) {
			int P = in.nextInt();
			int S = in.nextInt();
			int C = in.nextInt();
			int m = in.nextInt();
			
			size = P + S + 2;
			residual = new int[size][size];
			prev = new int[size];
			
			graph = new ArrayList<List<Integer>>();
			for (int i = 0; i < size; ++i) {
				graph.add(new ArrayList<Integer>());
			}
			// Connect source to all contestants, with weight 1
			for (int i = 1; i <= P; ++i) {
				graph.get(0).add(i);
				graph.get(i).add(0);
				residual[0][i] = 1;
			}
			// Connect all sites to sink, with weight C
			for (int i = 1; i <= S; ++i) {
				graph.get(i + P).add(size - 1);
				graph.get(size - 1).add(i + P);
				residual[i + P][size - 1] = C;
			}
			// Connect contestants to sites
			for (int i = 0; i < m; ++i) {
				int p = in.nextInt();
				int s = in.nextInt();
				
				s += P;
				graph.get(p).add(s);
				graph.get(s).add(p);
				residual[p][s] = 1;
			}
			
			System.out.println(maxFlow(0, size - 1));
		}
		
		in.close();
		System.exit(0);
	}
}
