package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class SchoolMarks {

	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		int n = in.nextInt();
		int k = in.nextInt();
		int p = in.nextInt();
		int x = in.nextInt();
		int y = in.nextInt();
		
		int[] a = new int[n];
		int sum = 0;
		int belowMedian = 0;
		int aboveEqualMedian = 0;
		int totalBelow = n / 2;
		int totalAboveEqual = n - totalBelow;
		for (int i = 0; i < k; ++i) {
			a[i] = in.nextInt();
			if (a[i] < y) {
				++belowMedian;
			} else {
				++aboveEqualMedian;
			}
			sum += a[i];
		}
		
		boolean valid = true;
		int numOnes = 0;
		int numY = 0;
		if (belowMedian > totalBelow) {
			valid = false;
		} else {
			numOnes = totalBelow - belowMedian - Math.max(0, aboveEqualMedian - totalAboveEqual);
			if (aboveEqualMedian < totalAboveEqual) {
				numY = totalAboveEqual - aboveEqualMedian;
			}
			
			sum += numOnes + numY * y;
			if (sum > x) {
				valid = false;
			}
		}
		
		if (!valid) {
			System.out.println(-1);
		} else {
			boolean first = true;
			for (int i = 0; i < numOnes; ++i) {
				if (first) first = false; else System.out.print(" ");
				System.out.print(1);
			}
			for (int i = 0; i < numY; ++i) {
				if (first) first = false; else System.out.print(" ");
				System.out.print(y);
			}
			System.out.println();
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
