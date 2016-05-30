package codeforces;

import java.io.*;
import java.util.*;

public class HotBath {
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		int t1 = in.nextInt();
		int t2 = in.nextInt();
		int x1 = in.nextInt();
		int x2 = in.nextInt();
		int t0 = in.nextInt();
		
		int bestY1 = 0;
		int bestY2 = 0;
		double minT = Double.MAX_VALUE;
		
		for (int y1 = 0; y1 <= x1; ++y1) {
			int lo = y1 == 0 ? 1 : 0;
			int hi = x2;
			
			while (lo < hi) {
				int mid = (lo + hi) / 2;
				double t = (double) (t1 * y1 + t2 * mid) / (y1 + mid);

				if (Double.compare(t, t0) < 0)
					lo = mid + 1;
				else
					hi = mid;
			}
			int y2 = lo;
			
			double t = (double) (t1 * y1 + t2 * y2) / (y1 + y2);
			
			if (Double.compare(t, t0) < 0) continue;
			
			if (Double.compare(t, minT) < 0) {
				bestY1 = y1;
				bestY2 = y2;
				minT = t;
			} else if (Double.compare(t, minT) == 0) {
				if (y1 + y2 > bestY1 + bestY2) {
					bestY1 = y1;
					bestY2 = y2;
				}
			}
		}
		
		System.out.println(bestY1 + " " + bestY2);
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
