package codeforces;

import java.io.*;
import java.util.*;

public class SetOfStrings {
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		int k = in.nextInt();
		String q = in.next();
		
		boolean[] seen = new boolean[26];
		List<String> ans = new ArrayList<String>();
		
		seen[q.charAt(0) - 'a'] = true;
		int first = 0;
		for (int i = 1, len = q.length(); i <= len && k > 0; ++i) {
			if (i == len || !seen[q.charAt(i) - 'a']) {
				if (i < len) {
					seen[q.charAt(i) - 'a'] = true;
				}
				ans.add(q.substring(first, k == 1 ? len : i));
				--k;
				first = i;
			}
		}
		
		if (k > 0) {
			System.out.println("NO");
		} else {
			System.out.println("YES");
			for (String x : ans) {
				System.out.println(x);
			}
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
