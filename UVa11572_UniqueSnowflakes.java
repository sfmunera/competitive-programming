package uva;

import java.io.*;
import java.util.*;

public class UVa11572_UniqueSnowflakes {
	public static void main(String[] args) throws IOException {
		InputReader in = new InputReader(System.in);
		
		int T = in.nextInt();
		while (T-- > 0) {
			int N = in.nextInt();
			HashMap<Integer, Integer> set = new HashMap<Integer, Integer>();
			int ans = 0;
			int first = 0;
			for (int i = 0; i < N; ++i) {
				int x = in.nextInt();
				if (set.containsKey(x) && set.get(x) >= first) {
					ans = Math.max(ans, i - first);
					first = set.get(x) + 1;
				}
				set.put(x, i);
			}
			ans = Math.max(ans, N - first);
			System.out.println(ans);
		}
	}
	
	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream));
			tokenizer = null;
		}

		public String next() throws IOException {
			while (tokenizer == null || !tokenizer.hasMoreTokens())
				tokenizer = new StringTokenizer(reader.readLine());
			
			return tokenizer.nextToken();
		}
		
		public String nextLine() throws IOException {
			tokenizer = null;
			return reader.readLine();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
		
		public double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}
		
		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}
	}
}
