package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class AnyaAndGhosts {
	
	static void removeExpired(List<Integer> ft, int w) {
		List<Integer> temp = new ArrayList<Integer>();
		
		for (int x : ft) {
			if (x >= w) {
				temp.add(x);
			}
		}
		ft.clear();
		ft.addAll(temp);
	}
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		int m = in.nextInt();
		int t = in.nextInt();
		int r = in.nextInt();
		
		int[] w = new int[m];
		for (int i = 0; i < m; ++i) {
			w[i] = in.nextInt();
		}
		
		int ans = 0;
		boolean valid = true;
		List<Integer> finalTimes = new ArrayList<Integer>();
		for (int i = 0; i < m; ++i) {			
			// take out expired candles from the list
			removeExpired(finalTimes, w[i]);
			
			// add new candles to the list if necessary
			int size = finalTimes.size();
			for (int j = 1; j <= r - size; ++j) {
				int ft = w[i] - j + t;
				finalTimes.add(ft);
				++ans;
			}
			
			// check if there are enough candles
			removeExpired(finalTimes, w[i]);
			if (finalTimes.size() < r) {
				valid = false;
				break;
			}
		}
		
		if (valid) {
			System.out.println(ans);
		} else {
			System.out.println(-1);
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
