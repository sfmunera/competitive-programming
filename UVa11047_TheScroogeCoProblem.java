package uva;

import java.io.*;
import java.util.*;

public class UVa11047_TheScroogeCoProblem {
	
	static final int INF = (int) 1e9;
	static int[][] adj;
	static int[][] p;
	static int P;
	static HashMap<String, Integer> map;
	static String[] names;
	
	static void printPath(int i, int j, boolean first) {
		if (i == j && !first) {
			System.out.print(names[i]);
			return;
		}

		printPath(i, p[i][j], false);
		System.out.print(" " + names[j]);
	}
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		int T = in.nextInt();
		while (T-- > 0) {
			P = in.nextInt();
			StringTokenizer stk = new StringTokenizer(in.nextLine());
			adj = new int[P][P];
			p = new int[P][P];
			names = new String[P];
			
			map = new HashMap<String, Integer>();
			for (int i = 0; i < P; ++i) {
				Arrays.fill(p[i], -1);
				String name = stk.nextToken();
				map.put(name, i);
				names[i] = name;
			}
			
			for (int i = 0; i < P; ++i) {
				for (int j = 0; j < P; ++j) {
					int l = in.nextInt();
					adj[i][j] = l == -1 ? INF : l;
					p[i][j] = i;
				}
			}
			
			for (int k = 0; k < P; ++k)
				for (int i = 0; i < P; ++i)
					for (int j = 0; j < P; ++j)
						if (adj[i][k] + adj[k][j] < adj[i][j]) {
							adj[i][j] = adj[i][k] + adj[k][j];
							p[i][j] = p[k][j];
						}

			int R = in.nextInt();
			for (int i = 0; i < R; ++i) {
				String name = in.next();
				String from = in.next();
				String to = in.next();
				
				int f = map.get(from);
				int t = map.get(to);
				
				if (adj[f][t] < INF) {
					System.out.println("Mr " + name + " to go from " + from + " to " + to + 
							", you will receive " + adj[f][t] + " euros");
					System.out.print("Path:");
					printPath(f, t, true);
					System.out.println();
				} else
					System.out.println("Sorry Mr " + name + " you can not go from " + from + " to " + to);
			}
		}
	}
	
	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream));
			tokenizer = null;
		}

		public String next() {
			try {
				while (tokenizer == null || !tokenizer.hasMoreTokens())
					tokenizer = new StringTokenizer(reader.readLine());
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			
			return tokenizer.nextToken();
		}
		
		public String nextLine() {
			String line = null;
			try {
				tokenizer = null;
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
	}
}
