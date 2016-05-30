package codeforces;

import java.io.*;
import java.util.*;

public class GeorgeAndTheJob {

	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		int n = in.nextInt();
		int m = in.nextInt();
		int K = in.nextInt();
		
		int[] p = new int[n];
		for (int i = 0; i < n; ++i)
			p[i] = in.nextInt();
		
		long[] dpcur = new long[n + 1];
		long[] dpprev = new long[n + 1];
		for (int i = 0; i <= n; ++i)
			dpprev[i] = 0;
		
		for (int k = 1; k <= K; ++k) {
			Arrays.fill(dpcur, 0);
			for (int i = n - m; i >= 0; --i) {
				dpcur[i] = dpcur[i + 1];
				long sum = 0;
				for (int j = i; j < i + m; ++j)
					sum += p[j];
				dpcur[i] = Math.max(dpcur[i], dpprev[i + m] + sum);
			}
			dpprev = dpcur.clone();
		}
		System.out.println(dpcur[0]);
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
