package uva;

import java.util.*;
import java.io.*;

public class UVa11195_AnothernQueenProblem {
	static int N;
	static char[][] bad;
	
	static int go(int r, int colTaken, int d1Taken, int d2Taken) {
		if (r == N)
			return 1;
		int ans = 0;
		for (int tmp = colTaken; tmp > 0; tmp -= (tmp & -tmp)) {
			int c = Integer.bitCount((tmp & -tmp) - 1);
			if (bad[r][c] == '*')
				continue;
			int d1 = c - r + N - 1;
			int d2 = c + r;
			if ((d1Taken & (1 << d1)) > 0 || (d2Taken & (1 << d2)) > 0)
				continue;
			
			ans += go(r + 1, colTaken & ~(1 << c), d1Taken | (1 << d1), d2Taken | (1 << d2));
		}
		return ans;
	}

	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);

		int t = 1;
		while (true) {
			N = in.nextInt();
			if (N == 0)
				break;
			
			bad = new char[N][N];
			for (int i = 0; i < N; ++i)
				bad[i] = in.nextLine().toCharArray();

			System.out.println("Case " + t + ": " + go(0, (1 << N) - 1, 0, 0));

			++t;
		}
		
		System.exit(0);
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
