package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class PFASTInc {
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);

		int n = in.nextInt();
		int m = in.nextInt();
		
		String[] names = new String[n];
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		for (int i = 0; i < n; ++i)
			names[i] = in.next();
		Arrays.sort(names);
		
		for (int i = 0; i < n; ++i)
			map.put(names[i], i);
		
		boolean[][] bad = new boolean[n][n];
		for (int i = 0; i < m; ++i) {
			int n1 = map.get(in.next());
			int n2 = map.get(in.next());
			bad[n1][n2] = bad[n2][n1] = true;
		}
		
		int best = 0;
		int max = 0;
		for (int mask = 0; mask < (1 << n); ++mask)
			if (Integer.bitCount(mask) > max) {
				boolean ok = true;
				for (int i = 0; i < n && ok; ++i)
					for (int j = i + 1; j < n && ok; ++j)
						if ((mask & (1 << i)) > 0 && (mask & (1 << j)) > 0 && bad[i][j])
							ok = false;
				if (ok) {
					best = mask;
					max = Integer.bitCount(mask);
				}
			}
		
		System.out.println(max);
		for (int i = 0; i < n; ++i)
			if ((best & (1 << i)) > 0)
				System.out.println(names[i]);
		
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
