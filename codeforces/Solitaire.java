package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Solitaire {
	
	static Set<String> seen;
	
	static boolean dfs(String s) {
		if (s.length() == 2)
			return true;
		seen.add(s);
		
		String last = s.substring(s.length() - 2);
		s = s.substring(0, s.length() - 2);
		if (s.length() >= 2) {
			String toDelete = s.substring(s.length() - 2);
			if (toDelete.charAt(0) == last.charAt(0) || toDelete.charAt(1) == last.charAt(1)) {
				String next = s.substring(0, s.length() - 2) + last;
				if (!seen.contains(next) && dfs(next))
					return true;
			}
		}
		
		if (s.length() >= 6) {
			String toDelete = s.substring(s.length() - 6, s.length() - 4);
			if (toDelete.charAt(0) == last.charAt(0) || toDelete.charAt(1) == last.charAt(1)) {
				String next = s.substring(0, s.length() - 6) + last + s.substring(s.length() - 4);
				if (!seen.contains(next) && dfs(next))
					return true;
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		int N = in.nextInt();
		String initialState = "";
		for (int i = 0; i < N; ++i)
			initialState += in.next();
		
		seen = new HashSet<String>();
		
		System.out.println(dfs(initialState) ? "YES" : "NO");
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
