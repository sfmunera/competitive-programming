package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Array {
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		int n = in.nextInt();
		int[] numbers = new int[n];
		
		for (int i = 0; i < n; ++i) {
			numbers[i] = in.nextInt();
		}
		
		Arrays.sort(numbers);
		
		List<Integer> negative = new ArrayList<Integer>();
		List<Integer> positive = new ArrayList<Integer>();
		List<Integer> zero = new ArrayList<Integer>();

		int posZero = 0;
		
		for (int i = 0; i < n; ++i) {
			if (numbers[i] == 0)
				posZero = i;
		}
		
		negative.add(numbers[0]);
		
		for (int i = posZero + 1; i < n; ++i) {
			positive.add(numbers[i]);
		}
		int last = posZero % 2 == 0 ? 1 : 0;
		for (int i = posZero - 1; i > last; --i) {
			positive.add(numbers[i]);
		}
		
		zero.add(0);
		if (last == 1) {
			zero.add(numbers[last]);
		}
		
		System.out.print(negative.size());
		for (int x : negative)
			System.out.print(" " + x);
		System.out.println();
		
		System.out.print(positive.size());
		for (int x : positive)
			System.out.print(" " + x);
		System.out.println();
		
		System.out.print(zero.size());
		for (int x : zero)
			System.out.print(" " + x);
		System.out.println();
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
