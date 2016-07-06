package codeforces;

import java.io.*;
import java.util.*;

public class MikeAndShortcuts {
	
	static int[] bfs(int[] a) {
		int n = a.length;
		List<List<Integer>> graph = new ArrayList<List<Integer>>();
		
		for (int i = 0; i < n; ++i) {
			graph.add(new ArrayList<Integer>());
		}
		
		for (int i = 0; i < n; ++i) {
			if (i < n - 1) graph.get(i).add(i + 1);
			if (i > 0) graph.get(i).add(i - 1);
			graph.get(i).add(a[i]);
		}
		
		Queue<Integer> Q = new LinkedList<Integer>();
		Set<Integer> seen = new HashSet<Integer>();
		int[] d = new int[n];
		
		d[0] = 0;
		Q.offer(0);
		seen.add(0);
		
		while (!Q.isEmpty()) {
			int u = Q.poll();
			
			for (int v : graph.get(u)) {
				if (!seen.contains(v)) {
					seen.add(v);
					Q.offer(v);
					d[v] = 1 + d[u];
				}
			}
		}
		
		return d;
	}
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		int n = in.nextInt();
		int[] a = new int[n];
		
		for (int i = 0; i < n; ++i) {
			a[i] = in.nextInt() - 1;
		}
		
		int[] d = bfs(a);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; ++i) {
			if (i > 0) sb.append(" ");
			sb.append(d[i]);
		}
		System.out.println(sb);
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
