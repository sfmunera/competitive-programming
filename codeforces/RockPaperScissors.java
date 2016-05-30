package codeforces;

import java.io.*;
import java.util.*;

public class RockPaperScissors {
	
	static boolean firstWins(String first, String second) {
		return (first.equals("rock") && second.equals("scissors")) ||
			   (first.equals("scissors") && second.equals("paper")) ||
			   (first.equals("paper") && second.equals("rock"));
	}
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		String fyodor = in.next();
		String matroskin = in.next();
		String sharic = in.next();
		
		if (firstWins(fyodor, matroskin) && firstWins(fyodor, sharic)) {
			System.out.println("F");
		} else if (firstWins(matroskin, fyodor) && firstWins(matroskin, sharic)) {
			System.out.println("M");
		} else if (firstWins(sharic, fyodor) && firstWins(sharic, matroskin)) {
			System.out.println("S");
		} else {
			System.out.println("?");
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
