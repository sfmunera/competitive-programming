package codeforces;

import java.io.*;
import java.util.*;

public class Shifts {
	
	static final int INF = (int) 1e9;
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		int n = in.nextInt();
		int m = in.nextInt();
		
		char[][] mat = new char[n][m];
		for (int i = 0; i < n; ++i)
			mat[i] = in.next().toCharArray();
		
		boolean valid = true;
		for (int i = 0; i < n && valid; ++i) {
			boolean ok = false;
			for (int j = 0; j < m; ++j)
				ok |= mat[i][j] == '1';
			if (!ok)
				valid = false;
		}
		
		int ans = -1;
		if (valid) {
			ans = INF;
			
			int[][] dist = new int[n][m];
			for (int i = 0; i < n; ++i) {
				int ind = -1;
				int first = -1;
				for (int j = 0; j < m; ++j) {
					if (mat[i][j] == '1') {
						dist[i][j] = 0;
						ind = j;
						if (first == -1)
							first = j;
					} else {
						dist[i][j] = m - (j - first);
						if (ind >= 0)
							dist[i][j] = Math.min(j - ind, dist[i][j]);
					}
				}
				ind = -1;
				int last = -1;
				for (int j = m - 1; j >= 0; --j) {
					if (mat[i][j] == '1') {
						ind = j;
						if (last == -1)
							last = j;
					} else {
						dist[i][j] = Math.min(dist[i][j], m - (last - j));
						if (ind >= 0)
							dist[i][j] = Math.min(ind - j, dist[i][j]);
					}
				}
			}
			
			
			for (int col = 0; col < m; ++col) {
				int cnt = 0;
				for (int i = 0; i < n; ++i) {
					cnt += dist[i][col];
				}
				ans = Math.min(ans, cnt);
			}
		}
		System.out.println(ans);
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
