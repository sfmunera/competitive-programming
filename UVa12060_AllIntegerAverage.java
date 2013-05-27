package uva;

import java.io.*;
import java.util.*;

public class UVa12060_AllIntegerAverage {
	
	static int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a % b);
	}
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		int t = 1;
		while (true) {
			int N = in.nextInt();
			
			if (N == 0)
				break;
			
			int sum = 0;
			for (int i = 0; i < N; ++i)
				sum += in.nextInt();
			
			System.out.println("Case " + t++ + ":");
			if (sum % N == 0) {
				if (sum / N >= 0)
					System.out.println(sum / N);
				else
					System.out.println("- " + (-sum / N));
			} else {
				boolean negative = false;
				if (sum * N < 0)
					negative = true;
				sum = Math.abs(sum);
				N = Math.abs(N);
				
				int g = gcd(sum, N);
				sum /= g;
				N /= g;
				
				int leading = sum / N;
				sum -= leading * N;
				
				int nHyphen = 0;
				int tmp = N;
				while (tmp > 0) {
					++nHyphen;
					tmp /= 10;
				}
				int spaces = negative ? 2 : 0;
				tmp = leading;
				while (tmp > 0) {
					++spaces;
					tmp /= 10;
				}
				
				for (int i = 0; i < spaces; ++i)
					System.out.print(" ");
				System.out.printf("%" + nHyphen + "d\n", sum);
				
				System.out.print(negative ? "- " : "");
				if (leading > 0)
					System.out.print(leading);
				for (int i = 0; i < nHyphen; ++i)
					System.out.print("-");
				System.out.println();
				
				for (int i = 0; i < spaces; ++i)
					System.out.print(" ");
				System.out.println(N);
			}
		}
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
