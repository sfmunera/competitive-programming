package codeforces;

import java.io.*;
import java.util.*;

public class ThreeBaseStations {

	static boolean check(int[] pos, int d) {
		int j = 0;
		for (int i = 0; i < 3 && j < pos.length; ++i) {
			double l = pos[j];
			double r = l + d;
			while (j < pos.length && pos[j] <= r) {
				++j;
			}
		}
		
		return j == pos.length;// true if d can cover the range
	}
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		int N = in.nextInt();
		int[] pos = new int[N];
		
		for (int i = 0; i < N; ++i)
			pos[i] = in.nextInt();
		
		Arrays.sort(pos);

		int lo = 0;
		int hi = pos[N - 1] - pos[0];
		while (lo < hi) {
			int mid = (lo + hi) / 2;
			if (check(pos, mid)) {
				hi = mid;
			} else {
				lo = mid + 1;
			}
		}
		
		int d = lo;
		double[] t = {pos[0], pos[0], pos[0]};
		int j = 0;
		for (int i = 0; i < 3 && j < pos.length; ++i) {
			int l = pos[j];
			double r = l + d;
			int rr = l;
			while (j < pos.length && pos[j] <= r) {
				rr = pos[j];
				++j;
			}
			//System.out.println(l + " " + rr + " " + r + " " + d);
			t[i] = (l + rr) / 2.0;
		}
		Arrays.sort(t);
		
		System.out.format(Locale.ENGLISH, "%.6f\n", d / 2.0);
		System.out.format(Locale.ENGLISH, "%.6f %.6f %.6f\n", t[0], t[1], t[2]);
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
