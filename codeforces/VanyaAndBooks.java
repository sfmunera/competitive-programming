package codeforces;

import java.io.*;
import java.util.*;

public class VanyaAndBooks {
	
	static long solve(long num) {
		long cnt = 1;
		long ans = 0;
		long d = 1;
		while (num >= 10) {
			ans += d * 9 * cnt;
			++d;
			cnt *= 10;
			num /= 10;
		}
		ans += d * (num * cnt - cnt + 1);
		
		return ans;
	}
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		long n = in.nextInt();
		long tmp = n;
		long pow = 1;
		long cnt = 0;
		while (tmp >= 10) {
			tmp /= 10;
			pow *= 10;
			++cnt;
		}
		long ans = solve(tmp * pow) + (cnt + 1) * (n % pow);
		
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
