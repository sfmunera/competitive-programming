import java.util.*;
import java.io.*;

public class RoadNetwork {
	
	static List<List<Integer>> graph;
	static List<List<Integer>> graphReversed;
	
	static boolean[] visited;
	static Stack<Integer> sort;
	static void dfs(int u) {
		visited[u] = true;
		for (int e : graph.get(u))
			if (!visited[e])
				dfs(e);
		sort.push(u);
	}
	static void topsort() {
		visited = new boolean[graph.size()];
		sort = new Stack<Integer>();
		for (int i = 0; i < graph.size(); ++i)
			if (!visited[i])
				dfs(i);
	}
	
	static int[] leader; // Leader of the SCC containing node i
	static void dfs2(int u, int l) {
		visited[u] = true;
		leader[u] = l;
		for (int e : graphReversed.get(u))
			if (!visited[e])
				dfs2(e, l);
	}
	static int scc() {
		topsort();
		visited = new boolean[graph.size()];
		leader = new int[graph.size()];
		int numComps = 0;
		while (!sort.isEmpty()) {
			int u = sort.pop();
			if (!visited[u]) {
				++numComps;
				dfs2(u, u);
			}
		}
		return numComps;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt();
		while (T-- > 0) {
			int N = in.nextInt();
			int M = in.nextInt();
			
			graph = new ArrayList<List<Integer>>();
			graphReversed = new ArrayList<List<Integer>>();
			for (int i = 0; i < N; ++i) {
				graph.add(new ArrayList<Integer>());
				graphReversed.add(new ArrayList<Integer>());
			}
			
			for (int i = 0; i < M; ++i) {
				int from = in.nextInt() - 1;
				int to = in.nextInt() - 1;
				
				graph.get(from).add(to);
				graphReversed.get(to).add(from);
			}
			
			in.next();
			
			System.out.println(scc());
		}
		
		in.close();
		System.exit(0);
	}
}
