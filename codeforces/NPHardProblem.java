package codeforces;

import java.io.*;
import java.util.*;

public class NPHardProblem {
	
	static List<List<Integer>> graph;
	static int[] color;
	
	static boolean dfs(int u, int c) {
		color[u] = c;
		
		boolean possible = true;
		for (int v : graph.get(u)) {
			if (color[v] < 0) {
				possible &= dfs(v, 1 - c);
			} else if (color[v] == c) {
				return false;
			}
		}
		
		return possible;
	}
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		int n = in.nextInt();
		int m = in.nextInt();
		
		graph = new ArrayList<List<Integer>>();
		for (int i = 0; i < n; ++i) {
			graph.add(new ArrayList<Integer>());
		}
		
		for (int i = 0; i < m; ++i) {
			int u = in.nextInt() - 1;
			int v = in.nextInt() - 1;
			
			graph.get(u).add(v);
			graph.get(v).add(u);
		}
		
		color = new int[n];
		Arrays.fill(color, -1);
		
		boolean possible = true;
		for (int i = 0; i < n; ++i) {
			if (color[i] < 0) {
				possible = dfs(i, 0);
				if (!possible) break;
			}
		}
		
		if (!possible) {
			System.out.println(-1);
		} else {
			StringBuilder sb = new StringBuilder();
			List<Integer> black = new ArrayList<Integer>();
			List<Integer> white = new ArrayList<Integer>();
			
			for (int i = 0; i < n; ++i) {
				if (color[i] == 0) {
					black.add(i + 1);
				} else {
					white.add(i + 1);
				}
			}
			
			sb.append(black.size() + "\n");
			for (int i = 0; i < black.size(); ++i) {
				if (i > 0) sb.append(" ");
				sb.append(black.get(i));
			}
			sb.append("\n");
			
			sb.append(white.size() + "\n");
			for (int i = 0; i < white.size(); ++i) {
				if (i > 0) sb.append(" ");
				sb.append(white.get(i));
			}
			sb.append("\n");
			
			System.out.print(sb);
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
