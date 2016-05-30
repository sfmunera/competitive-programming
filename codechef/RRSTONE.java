package codechef;

import java.io.*;
import java.util.*;


public class RRSTONE {
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		int N = in.nextInt();
		int K = in.nextInt();
		long[][] A = new long[3][N];
		
		for (int i = 0; i < N; ++i)
			A[0][i] = in.nextLong();
		
		for (int i = 1; i < 3; ++i) {
			long max = Long.MIN_VALUE;
			for (int j = 0; j < N; ++j)
				max = Math.max(max, A[i - 1][j]);
			for (int j = 0; j < N; ++j)
				A[i][j] = max - A[i - 1][j];
		}
		int ind = K == 0 ? 0 : K % 2 == 0 ? 2 : 1;
		for (int j = 0; j < N; ++j) {
			if (j > 0) System.out.print(" ");
			System.out.print(A[ind][j]);
		}
		System.out.println();
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
