package codeforces;

import java.io.*;
import java.util.*;

public class PlayingWithDice {
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		int a = in.nextInt();
		int b = in.nextInt();
		
		int wins = 0;
		int losses = 0;
		int draws = 0;
		for (int i = 1; i <= 6; ++i) {
			if (Math.abs(a - i) > Math.abs(b - i))
				++losses;
			else if (Math.abs(a - i) < Math.abs(b - i))
				++wins;
			else
				++draws;
		}
		
		System.out.println(wins + " " + draws + " " + losses);
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
