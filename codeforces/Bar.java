package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Bar {
	
	static boolean isNumber(String x) {
		for (int i = 0; i < x.length(); ++i)
			if (x.charAt(i) < '0' || x.charAt(i) > '9')
				return false;
		return true;
	}
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		HashSet<String> alcohol = new HashSet<String>();
		alcohol.add("ABSINTH");
		alcohol.add("BEER");
		alcohol.add("BRANDY");
		alcohol.add("CHAMPAGNE");
		alcohol.add("GIN");
		alcohol.add("RUM");
		alcohol.add("SAKE");
		alcohol.add("TEQUILA");
		alcohol.add("VODKA");
		alcohol.add("WHISKEY");
		alcohol.add("WINE");

		int n = in.nextInt();
		int ans = 0;
		for (int i = 0; i < n; ++i) {
			String x = in.next();
			if (isNumber(x)) {
				int y = Integer.parseInt(x);
				if (y < 18)
					++ans;
			} else {
				if (alcohol.contains(x))
					++ans;
			}
		}
		System.out.println(ans);
		
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
