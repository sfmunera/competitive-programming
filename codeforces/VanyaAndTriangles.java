package codeforces;

import java.io.*;
import java.util.*;

public class VanyaAndTriangles {
	
	static class Point {
		int x, y;
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a % b);
	}
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);

		int n = in.nextInt();
		Point[] points = new Point[n];
		boolean[][] occupied = new boolean[201][201];
		
		for (int i = 0; i < n; ++i) {
			int x = in.nextInt() + 100;
			int y = in.nextInt() + 100;
			
			points[i] = new Point(x, y);
			occupied[x][y] = true;
		}
		
		int ans = 0;
		for (int i = 0; i < n; ++i) {
			for (int j = i + 1; j < n; ++j) {
				int dx = points[i].x - points[j].x;
				int dy = points[i].y - points[j].y;
				
				int cnt = 0;
				if (dx == 0) {
					for (int k = 0; k <= 200; ++k) {
						if (occupied[points[i].x][k]) {
							++cnt;
						}
					}
				} else if (dy == 0) {
					for (int k = 0; k <= 200; ++k) {
						if (occupied[k][points[i].y]) {
							++cnt;
						}
					}
				} else {
				
					int g = gcd(Math.abs(dx), Math.abs(dy));
					dx /= g;
					dy /= g;
					for (int k = 0; k <= 500; ++k) {
						for (int s = -1; s <= 1; s += 2) {
							int x = points[i].x + s * dx * k;
							int y = points[i].y + s * dy * k;
							
							if (x >= 0 && x <= 200 && y >= 0 && y <= 200 && occupied[x][y]) {
								++cnt;
							}
						}
						
					}
				}
				System.out.println(i + " " + j + " " + (n - cnt));
				ans += n - cnt;
			}
		}
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
