package codeforces;

import java.util.*;
import java.io.*;

public class LuckyTransformation {
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		int n = in.nextInt();
		int k = in.nextInt();
		
		char[] d = in.next().toCharArray();
		
		for (int i = 0; i < n - 1 && k > 0; ++i) {
			if (i + 2 < n && i % 2 == 0 && d[i] == '4' && (d[i + 1] == '4' || d[i + 1] == '7') && d[i + 2] == '7') {
				if (d[i + 1] == '4') {
					d[i + 1] = k % 2 == 1 ? '7' : '4';
				} else {
					d[i + 1] = k % 2 == 1 ? '4' : '7';
				}
				break;
			}
			
			if (d[i] == '4' && d[i + 1] == '7') {
				if (i % 2 == 0) {
					d[i + 1] = '4';
				} else {
					d[i] = '7';
				}
				i = Math.max(-1, i - 2);
				--k;
			}
		}
		
		System.out.println(String.valueOf(d));
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
