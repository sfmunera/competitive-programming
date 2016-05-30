package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class TanyaAndPassword {
	
	static class MutableInt {
		int x;
		public MutableInt(int x) {
			this.x = x;
		}
		public void increment() {
			this.x = this.x + 1;
		}
		public void decrement() {
			this.x = this.x - 1;
		}
	}

	static class Vertex {
		int id;
		String str;
		MutableInt cnt;
		public Vertex(int id, String str, MutableInt cnt) {
			this.id = id;
			this.str = str;
			this.cnt = cnt;
		}
		@Override public String toString() {
			return "" + this.id + "(" + this.str + "," + this.cnt.x + ")";
		}
	}
	
	static boolean check(List<Integer> toposort, Map<Integer, List<Integer>> graph) {
		for (int i = toposort.size() - 1; i > 0; --i) {
			if (!graph.get(toposort.get(i)).contains(toposort.get(i - 1))) {
				return false;
			}
		}
		return true;
	}
	
	static void print(List<Integer> toposort, Map<Integer, Vertex> vertices) {
		for (int i = toposort.size() - 1; i >= 0; --i) {
			int x = toposort.get(i);
			System.out.print(vertices.get(x).str.charAt(0));
			if (i == 0) {
				System.out.print(vertices.get(x).str.substring(1));
			}
		}
		System.out.println();
	}
	
	static class NodeTopo {
		int id;
		boolean finished;
		public NodeTopo(int id, boolean finished) {
			this.id = id;
			this.finished = finished;
		}
	}
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		int n = in.nextInt();
		String[] input = new String[n];
		for (int i = 0; i < n; ++i) {
			input[i] = in.next();
		}
		
		Arrays.sort(input);
		
		// Load set of vertices and counters
		Map<Integer, Vertex> vertices = new HashMap<Integer, Vertex>();
		Vertex last = null;
		for (int i = 0; i < n; ++i) {
			if (i == 0 || !input[i].equals(input[i - 1])) {
				Vertex u = new Vertex(i, input[i], new MutableInt(1));
				vertices.put(i, u);
				last = u;
			} else {
				last.cnt.increment();
			}
		}
		//System.out.println("vertices = " + vertices);
		
		// Map possible suffixes to vertices that begin with every suffix
		Map<String, List<Integer>> suffixes = new HashMap<String, List<Integer>>();
		for (int id : vertices.keySet()) {
			Vertex u = vertices.get(id);
			String suffix = u.str.substring(1);
			if (!suffixes.containsKey(suffix)) {
				suffixes.put(suffix, new ArrayList<Integer>());
			}
			suffixes.get(suffix).add(u.id);
		}
		
		//System.out.println("suffixes = " + suffixes);
		
		Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
		for (int id : vertices.keySet()) {
			graph.put(id, new ArrayList<Integer>());
		}
		
		for (int id : vertices.keySet()) {
			Vertex v = vertices.get(id);
			String prefix = v.str.substring(0, 2);
			List<Integer> pred = suffixes.get(prefix);
			
			if (pred != null) {
				for (int u : pred) {
					graph.get(u).add(v.id);
				}
			}
		}
		suffixes.clear();
		//System.out.println("graph = " + graph);
		
		// Do topological sorting
		Set<Integer> seen = new HashSet<Integer>();
		List<Integer> toposort = new ArrayList<Integer>();
		for (int id : vertices.keySet()) {
			if (!seen.contains(id)) {
				Stack<NodeTopo> S = new Stack<NodeTopo>();
				S.push(new NodeTopo(id, false));
				while (!S.isEmpty()) {
					NodeTopo node = S.pop();
					int x = node.id;
					
					if (node.finished) {
						toposort.add(x);
						continue;
					} else {
						S.push(new NodeTopo(x, true));
					}
					
					if (vertices.get(x).cnt.x == 1) {
						seen.add(x);
					}
					vertices.get(x).cnt.decrement();
					
					for (int v : graph.get(x)) {
						if (!seen.contains(v)) {
							S.push(new NodeTopo(v, false));
						}
					}
				}
			}
		}
		
		//System.out.println(toposort);
		if (!check(toposort, graph)) {
			System.out.println("NO");
		} else {
			System.out.println("YES");
			print(toposort, vertices);
		}
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
