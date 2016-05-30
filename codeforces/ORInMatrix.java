package codeforces;

import java.io.*;
import java.util.*;

public class ORInMatrix {
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		int m = in.nextInt();
		int n = in.nextInt();
		
		int[][] B = new int[m][n];
		for (int i = 0; i < m; ++i)
			for (int j = 0; j < n; ++j)
				B[i][j] = in.nextInt();
		
		int[][] A = new int[m][n];
		boolean valid = true;	
		for (int i = 0; i < m; ++i)
			for (int j = 0; j < n; ++j) {
				if (B[i][j] == 1) {
					boolean validRow = true;
					for (int k = 0; k < m; ++k) {
						if (B[k][j] != 1)
							validRow = false;
					}
					boolean validCol = true;
					for (int k = 0; k < n; ++k) {
						if (B[i][k] != 1)
							validCol = false;
					}
					
					valid &= validRow || validCol;
					if (validRow && validCol)
						A[i][j] = 1;
				}
			}
		
		
		boolean allZerosA = true;
		boolean allZerosB = true;
		
		for (int i = 0; i < m; ++i)
			for (int j = 0; j < n; ++j) {
				if (A[i][j] == 1)
					allZerosA = false;
				if (B[i][j] == 1)
					allZerosB = false;
			}
		
		if (valid && allZerosA && !allZerosB)
			valid = false;
		
		System.out.println(valid ? "YES" : "NO");
		if (valid) {
			for (int i = 0; i < m; ++i) {
				for (int j = 0; j < n; ++j) {
					if (j > 0)
						System.out.print(" ");
					System.out.print(A[i][j]);
				}
				System.out.println();
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
