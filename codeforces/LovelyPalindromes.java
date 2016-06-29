package codeforces;

import java.io.*;
import java.util.*;

public class LovelyPalindromes {
	
	static String reverse(String n) {
		char[] tmp = n.toCharArray();
		
		for (int i = 0; i < tmp.length / 2; ++i) {
			char t = tmp[i];
			tmp[i] = tmp[tmp.length - 1 - i];
			tmp[tmp.length - 1 - i] = t;
		}
		
		return String.valueOf(tmp);
	}
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		String n = in.next();
		System.out.print(n);
		System.out.println(reverse(n));
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
