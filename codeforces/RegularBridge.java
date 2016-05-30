package codeforces;

import java.io.*;
import java.util.*;

public class RegularBridge {

	static class Edge {
		int u, v;
		Edge(int u, int v) {
			this.u = u;
			this.v = v;
		}
	}
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		int k = in.nextInt();
		
		if (k % 2 == 0) {
			System.out.println("NO");
		} else if (k == 1) {
			System.out.println("YES");
			System.out.println("2 1");
			System.out.println("1 2");
		} else {
			List<Edge> edges = new ArrayList<Edge>();
			List<Edge> finalEdges = new ArrayList<Edge>();
			boolean[] touched = new boolean[k + 1];
			
			int toAdd = k - 1;
			for (int i = 0; i <= k; ++i) {
				for (int j = i + 1; j <= k; ++j) {
					if (!touched[i] && !touched[j] && toAdd > 0) {
						edges.add(new Edge(1, i + 2));
						edges.add(new Edge(1, j + 2));
						touched[i] = true;
						touched[j] = true;
						toAdd -= 2;
					} else {
						edges.add(new Edge(i + 2, j + 2));
					}
				}
			}
			
			for (Edge e : edges) {
				finalEdges.add(e);
				finalEdges.add(new Edge(e.u + k + 2, e.v + k +2));
			}
			finalEdges.add(new Edge(1, k + 3));
			
			System.out.println("YES");
			int n = 2 * (k + 1) + 2;
			int m = finalEdges.size();
			
			System.out.println(n + " " + m);
			for (Edge e : finalEdges) {
				System.out.println(e.u + " " + e.v);
			}
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
