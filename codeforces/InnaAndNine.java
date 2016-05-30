package codeforces;

import java.io.*;
import java.util.*;

public class InnaAndNine {
	
	static long solve(char[] a, int d1, int d2) {
		int[] d = {d1, d2};
		
		// find odd-length sequences {d1,d2,d1,d2,...}
		// and add to the answer (len+1)/2
		long ans = 1L;
		for (int i = 0; i < a.length; ++i) {
			int turn = -1;
			for (int k = 0; k < 2; ++k) {
				if ((a[i] - '0') == d[k]) {
					turn = k;
				}
			}
			
			if (turn >= 0) {
				int j = i;
				while (j < a.length && (a[j] - '0') == d[turn]) {
					++j;
					turn = 1 - turn;
				}
				--j;
				
				int len = j - i + 1;
				if (len > 2 && len % 2 == 1) {
					ans *= (len + 1L) / 2L;
				}
				
				i = j;
			}
		}
		
		return ans;
	}

	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		char[] a = in.next().toCharArray();
		
		long ans = 1L;
		
		for (int i = 1; i <= 9 / 2; ++i)
			ans *= solve(a, i, 9 - i);
		
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
