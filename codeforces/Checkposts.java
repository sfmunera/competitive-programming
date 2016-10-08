package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Checkposts {
	
	static class Pair {
		int f, s;
		Pair(int f, int s) { this.f = f; this.s = s; }
		
		public String toString() {
			return "(" + f + ", " + s + ")";
		}
	}
	
	static final int MOD = (int) 1e9 + 7;
	
	static void dfs(int u, List<List<Integer>> graph, Set<Integer> seen, Stack<Integer> sort) {
		seen.add(u);
		
		for (int v : graph.get(u)) {
			if (!seen.contains(v)) {
				dfs(v, graph, seen, sort);
			}
		}
		
		sort.push(u);
	}
	
	static Stack<Integer> toposort(List<List<Integer>> graph) {
		int n = graph.size();
		Stack<Integer> sort = new Stack<>();
		Set<Integer> seen = new HashSet<>();
		
		for (int i = 0; i < n; ++i) {
			if (!seen.contains(i)) {
				dfs(i, graph, seen, sort);
			}
		}
		
		return sort;
	}
	
	static void dfs2(int u, int lead, List<List<Integer>> graph, Set<Integer> seen, int[] leaders) {
		seen.add(u);
		leaders[u] = lead;
		
		for (int v : graph.get(u)) {
			if (!seen.contains(v)) {
				dfs2(v, lead, graph, seen, leaders);
			}
		}
	}
	
	static void scc(List<List<Integer>> graph, List<List<Integer>> graphTransposed, int[] leaders) {
		Stack<Integer> sort = toposort(graph);
		Set<Integer> seen = new HashSet<>();
		
		while (!sort.isEmpty()) {
			int u = sort.pop();
			if (!seen.contains(u)) {
				dfs2(u, u, graphTransposed, seen, leaders);
			}
		}
	}
		
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		int n = in.nextInt();
		
		List<List<Integer>> graph = new ArrayList<>(n);
		List<List<Integer>> graphTransposed = new ArrayList<>(n);
		int[] values = new int[n];
		
		for (int i = 0; i < n; ++i) {
			graph.add(new ArrayList<Integer>());
			graphTransposed.add(new ArrayList<Integer>());
			values[i] = in.nextInt();
		}
		
		int m = in.nextInt();
		for (int i = 0; i < m; ++i) {
			int u = in.nextInt() - 1;
			int v = in.nextInt() - 1;
			
			graph.get(u).add(v);
			graphTransposed.get(v).add(u);
		}
		
		int[] leaders = new int[n];
		scc(graph, graphTransposed, leaders);
				
		Map<Integer, Pair> map = new HashMap<>();
		for (int i = 0; i < n; ++i) {
			if (!map.containsKey(leaders[i])) map.put(leaders[i], new Pair(values[i], 0));
			Pair pair = map.get(leaders[i]);
			if (values[i] < pair.f) {
				pair.f = values[i];
				pair.s = 1;
			} else if (values[i] == pair.f) {
				pair.s++;
			}
			
			map.put(leaders[i], pair);
		}
				
		long sum = 0;
		long count = 1;
		for (int x : map.keySet()) {
			Pair pair = map.get(x);
			sum += (long)pair.f;
			count *= (long)pair.s;
			count %= MOD;
		}
		
		System.out.println(sum + " " + count);
		
		System.exit(0);
	}
	
	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream));
			tokenizer = new StringTokenizer("");
		}

		public String next() {
			try {
				while (!tokenizer.hasMoreTokens())
					tokenizer = new StringTokenizer(reader.readLine());
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			
			return tokenizer.nextToken();
		}
		
		public String nextLine() {
			String line = null;
			try {
				tokenizer = new StringTokenizer("");
				line =  reader.readLine();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			return line;
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}
		
		public double nextDouble() {
			return Double.parseDouble(next());
		}
		
		public long nextLong() {
			return Long.parseLong(next());
		}
		
		boolean hasNext() {
            while (!tokenizer.hasMoreTokens()) {
                String line = nextLine();
                if (line == null) return false;
                tokenizer = new StringTokenizer(line);
            }
            return true;
        }
	}
}
