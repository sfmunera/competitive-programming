package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class CielAndDancing {
	
	static class Pair {
		int first, second;
		public Pair(int first, int second) {
			this.first = first;
			this.second = second;
		}
		@Override public String toString() {
			return this.first + " " + this.second;
		}
	}
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		int n = in.nextInt(); // boys
		int m = in.nextInt(); // girls
		
		boolean invert = false;
		List<Pair> pairs = new ArrayList<Pair>();
		
		if (m < n) {
			invert = true;
			int t = m;
			m = n;
			n = t;
		}
		
		Map<Integer, Integer> count = new HashMap<Integer, Integer>();
		
		for (int i = 1; i <= n; ++i) {
			for (int j = 1; j <= m; ++j) {
				
				if (count.containsKey(j) && count.get(j) > 0 && count.get(j) < 2) {
					count.put(j, count.get(j) + 1);
					if (invert) {
						pairs.add(new Pair(j, i));
					} else {
						pairs.add(new Pair(i, j));
					}
					break;
				}
			}
			
			for (int j = 1; j <= m; ++j) {
				if (!count.containsKey(j)) {
					count.put(j, 1);
					if (invert) {
						pairs.add(new Pair(j, i));
					} else {
						pairs.add(new Pair(i, j));
					}
				}
			}
		}
		
		System.out.println(pairs.size());
		for (Pair p : pairs) {
			System.out.println(p);
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
