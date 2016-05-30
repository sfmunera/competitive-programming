package codeforces;

import java.io.*;
import java.util.*;

public class ConvexShape {
	
	final static int[] dr = {1, 0, -1, 0}; // SWNE
	final static int[] dc = {0, -1, 0, 1};
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		int n = in.nextInt();
		int m = in.nextInt();
		
		char[][] grid = new char[n][m];
		for (int i = 0; i < n; ++i)
			grid[i] = in.next().toCharArray();
		
		boolean[][] seen = new boolean[n][m];
		Queue<Integer> Qr, Qc;
		int comps = 0;
		
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				if (grid[i][j] == 'B' && !seen[i][j]) {
					++comps;
					Qr = new LinkedList<Integer>();
					Qc = new LinkedList<Integer>();
					
					seen[i][j] = true;
					Qr.add(i);
					Qc.add(j);
					
					while (!Qr.isEmpty()) {
						int r = Qr.poll();
						int c = Qc.poll();
						
						for (int d = 0; d < 4; ++d) {
							int nr = r + dr[d];
							int nc = c + dc[d];
							if (nc >= 0 && nr >= 0 && nc < m && nr < n && grid[nr][nc] == 'B' && !seen[nr][nc]) {
								seen[nr][nc] = true;
								Qr.add(nr);
								Qc.add(nc);
							}
						}
					}
				}
			}
		}
		
		boolean isConvex = true;
		if (comps > 1) {
			isConvex = false;
		} else {
			 
		}
		System.out.println(isConvex ? "YES" : "NO");
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
