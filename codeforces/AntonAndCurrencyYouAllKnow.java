package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class AntonAndCurrencyYouAllKnow {
	
	static void swap(char[] n, int i, int j) {
		char t = n[i];
		n[i] = n[j];
		n[j] = t;
	}
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		String input = in.next();
		char[] n = input.toCharArray();
		
		int firstEvenLessAt = -1;
		int lastEven = -1;
		for (int i = 0; i < n.length - 1; ++i) {
			if ((n[i] - '0') % 2 == 0) {
				lastEven = i;
				if (firstEvenLessAt == -1 && n[i] < n[n.length - 1]) {
					firstEvenLessAt = i;
				}
			}
		}
		
		String ans = "-1";
		if (firstEvenLessAt >= 0) {
			swap(n, firstEvenLessAt, n.length - 1);
			ans = String.valueOf(n);
		} else if (lastEven >= 0) {
			swap(n, lastEven, n.length - 1);
			ans = String.valueOf(n);
		}
		
		System.out.println(ans);
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
