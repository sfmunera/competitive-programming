package codeforces;

import java.io.*;
import java.util.*;

public class VanyaAndTable {
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		int n = in.nextInt();
		int[][] cells = new int[100][100];
		
		for (int i = 0; i < n; ++i) {
			int x1 = in.nextInt() - 1;
			int y1 = in.nextInt() - 1;
			int x2 = in.nextInt() - 1;
			int y2 = in.nextInt() - 1;
			
			for (int x = x1; x <= x2; ++x) {
				for (int y = y1; y <= y2; ++y) {
					++cells[x][y];
				}
			}
		}
		
		int sum = 0;
		for (int i = 0; i < 100; ++i) {
			for (int j = 0; j < 100; ++j) {
				sum += cells[i][j];
			}
		}
		System.out.println(sum);
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
