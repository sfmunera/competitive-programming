package codeforces;

import java.io.*;
import java.util.*;

public class C {
	
	static double dist(long x1, long y1, long x2, long y2) {
		long dx = x1 - x2;
		long dy = y1 - y2;
		return Math.sqrt(dx * dx + dy * dy);
	}
	
	static double getMinDist(long[] x, long[] y, long[] xp, long[] yp, long tx, long ty) {
		int n = x.length;
		double ans = 0.0;
		int which = -1;
		
		double min = Double.MAX_VALUE;
		for (int i = 0; i < n; ++i) {
			double d = dist(x[i], y[i], xp[0], yp[0]) - dist(x[i], y[i], tx, ty);
			if (d - 1e-9 < min) {
				min = d;
				which = i;
			}
		}
		
		ans += min;
			
		min = Double.MAX_VALUE;
		for (int i = 0; i < n; ++i) {
			double d = dist(x[i], y[i], xp[1], yp[1]) - dist(x[i], y[i], tx, ty);
			if (i != which && d - 1e-9 < min) {
				min = d;
			}
		}
		
		ans += min;
		
		return ans;
	}
		
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		long ax = in.nextLong();
		long ay = in.nextLong();
		long bx = in.nextLong();
		long by = in.nextLong();
		long tx = in.nextLong();
		long ty = in.nextLong();
		
		int n = in.nextInt();
		double S = 0.0;
		long[] x = new long[n];
		long[] y = new long[n];
		for (int i = 0; i < n; ++i) {
			x[i] = in.nextLong();
			y[i] = in.nextLong();
			
			S += dist(x[i], y[i], tx, ty);
		}

		double min = Math.min(getMinDist(x, y, new long[]{ax, bx}, new long[]{ay, by}, tx, ty),
				getMinDist(x, y, new long[]{bx, ax}, new long[]{by, ay}, tx, ty));
		
		double ans = 2.0 * S + min;
		
		System.out.printf("%.9f\n", ans);
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
