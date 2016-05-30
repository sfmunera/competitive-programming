package codeforces;

import java.io.*;
import java.util.*;

public class EquidistantString {
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		String n1 = in.next();
		String n2 = in.next();
		int N = n1.length();

		StringBuilder sb = new StringBuilder();
		int bit10 = 0;
		int bit01 = 0;
		for (int i = 0; i < N; ++i) {
			char c1 = n1.charAt(i);
			char c2 = n2.charAt(i);
			if (c1 == c2) {
				sb.append(c1);
			} else {
				if (c1 == '1') {
					sb.append(bit10);
					bit10 = 1 - bit10;
				} else {
					sb.append(bit01);
					bit01 = 1 - bit01;
				}
			}
		}
		
		String ans = sb.toString();
		int dist1 = 0;
		int dist2 = 0;
		for (int i = 0; i < N; ++i) {
			if (ans.charAt(i) != n1.charAt(i)) {
				++dist1;
			}
			if (ans.charAt(i) != n2.charAt(i)) {
				++dist2;
			}
		}
		
		if (dist1 == dist2) {
			System.out.println(ans);
		} else {
			System.out.println("impossible");
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
