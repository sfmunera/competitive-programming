package codeforces;

import java.io.*;
import java.util.*;

public class TShirtsFromSponsor {
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);

		String[] sizes = {"S", "M", "L", "XL", "XXL"};
		int[] number = new int[5];
		for (int i = 0; i < 5; ++i)
			number[i] = in.nextInt();
		
		int K = in.nextInt();
		
		for (int i = 0; i < K; ++i) {
			String size = in.next();
			int ind = 0;
			for (int j = 0; j < 5; ++j)
				if (size.equals(sizes[j])) {
					ind = j;
					break;
				}
			
			for (int d = 0; d < 5; ++d) {
				if (ind + d < 5 && number[ind + d] > 0) {
					--number[ind + d];
					System.out.println(sizes[ind + d]);
					break;
				}
				if (ind - d >= 0 && number[ind - d] > 0) {
					--number[ind - d];
					System.out.println(sizes[ind - d]);
					break;
				}
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
