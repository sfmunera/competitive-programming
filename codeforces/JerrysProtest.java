package codeforces;

import java.io.*;
import java.util.*;

public class JerrysProtest {
	
	static final int MAX = 5007;
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		int n = in.nextInt();
		int[] a = new int[n];
		
		for (int i = 0; i < n; ++i) {
			a[i] = in.nextInt();
		}
		
		// The constraints are:
		// (a1-j1)>0, (a2-j2)>0, (j3-a3)>0, j1+j2+j3>a1+a2+a3
		// => (a1-j1) + (a2-j2) < (j3-a3)
		// In the end, what matters is the differences that are > 0
		//
		// So, the problem boils down to:
		// d1 + d2 < d3, where di > 0 (1)
		//
		// the probability is X/Y, where:
		// Y = number of di > 0, cubed: (n(n-1)/2)^3
		// X = number of d3, such that (1) holds
		
		// 0 < di < 5000
		// => 0 < d1+d2 < 10000
		// keep a count on the frequency of each d1+d2
		
		Arrays.sort(a);
		long[] f = new long[MAX];
		
		for (int i = 0; i < n; ++i)
			for (int j = i + 1; j < n; ++j) {
				int d = a[j] - a[i];
				
				assert d > 0 && d < MAX;
				++f[d];
			}
		
		double[] p = new double[2 * MAX];
		for (int d1 = 1; d1 < MAX; ++d1)
			for (int d2 = 1; d2 < MAX; ++d2)
				p[d1 + d2] += (double) f[d1] * f[d2];
		
		// accumulate frequencies
		for (int i = 1; i < p.length; ++i)
			p[i] += p[i - 1];
		
		// count how many pairs satisfy (1)
		double prob = 0;
		for (int i = 0; i < n; ++i)
			for (int j = i + 1; j < n; ++j) {
				int d3 = a[j] - a[i];				
				prob += p[d3 - 1];
			}
		
		int numPairs = n * (n - 1) / 2;
		for (int i = 0; i < 3; ++i) prob /= (double) numPairs;
		
		System.out.printf("%.10f\n", prob);
		
		System.exit(0);
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
