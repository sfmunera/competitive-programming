package codeforces;

import java.io.*;
import java.util.*;

public class MagicSquares {
	
	static int n;
	static long[][] mat;
	static long[] numbers;
	static boolean done;
	static Long[] sumRows, sumCols;
	
	static long sumColumn(long[][] mat, int c) {
		int n = mat.length;
		long sum = 0;
		for (int i = 0; i < n; ++i)
			sum += mat[i][c];
		
		return sum;
	}
	
	static long sumRow(long[][] mat, int r) {
		int n = mat.length;
		long sum = 0;
		for (int i = 0; i < n; ++i)
			sum += mat[r][i];
		
		return sum;
	}
	
	static long sumDiagonal1(long[][] mat) {
		int n = mat.length;
		long sum = 0;
		for (int i = 0; i < n; ++i)
			sum += mat[i][i];
		
		return sum;
	}
	
	static long sumDiagonal2(long[][] mat) {
		int n = mat.length;
		long sum = 0;
		for (int i = 0; i < n; ++i)
			sum += mat[i][n - 1 - i];
		
		return sum;
	}
	
	static boolean check(long[][] mat) {
		int n = mat.length;
		long s = sumRows[0];

		if (sumRow(mat, n - 1) != s || sumColumn(mat, n - 1) != s ||
				sumDiagonal1(mat) != s || sumDiagonal2(mat) != s) 
			return false;

		return true;
	}
	
	static void go(int r, int c, int seen) {
		if (done) return;
		
		if (r == n) {
			if (check(mat)) {
				System.out.println(sumRows[0]);
				for (int i = 0; i < n; ++i) {
					for (int j = 0; j < n; ++j)
						System.out.print((j > 0 ? " " : "") + mat[i][j]);
					System.out.println();
				}
				done = true;
			}
			return;
		}
		
		if (c == 0 && r > 0) {
			long sum = sumRow(mat, r - 1);
			if (r > 1 && sum != sumRows[r - 2])
				return;
			sumRows[r - 1] = sum;
		}
		
		if (c > 0 && r == n - 1) {
			long sum = sumColumn(mat, c - 1);
			if (c > 1 && sum != sumCols[c - 2])
				return;
			sumCols[c - 1] = sum;
		}
		
		int nr = c < n - 1 ? r : r + 1;
		int nc = c < n - 1 ? c + 1 : 0;
		for (int i = 0; i < n * n; ++i)
			if ((seen & (1 << i)) == 0) {
				mat[r][c] = numbers[i];
				go(nr, nc, seen | (1 << i));
			}
	}
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		n = in.nextInt();
		numbers = new long[n * n];
		
		for (int i = 0; i < n * n; ++i)
			numbers[i] = in.nextInt();

		if (n == 1) {
			System.out.println(numbers[0]);
			System.out.println(numbers[0]);
		} else {
			mat = new long[n][n];
			
			done = false;
			sumRows = new Long[n];
			sumCols = new Long[n];
			go(0, 0, 0);
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
