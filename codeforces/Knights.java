package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Knights {
	
	static class Circle {
		long x, y, r;
		public Circle(long x, long y, long r) {
			this.x = x; 
			this.y = y;
			this.r = r;
		}
		
		public boolean inside(Point p) {
			long dx = this.x - p.x;
			long dy = this.y - p.y;
			
			return dx * dx + dy * dy < this.r * this.r;
		}
	}
	
	static class Point {
		long x, y;
		BitSet circles = new BitSet();
		public Point(long x, long y) {
			this.x = x; 
			this.y = y;
		}
	}
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		int N = in.nextInt();
		int M = in.nextInt();
		int K = in.nextInt();
		
		Point[] points = new Point[N];
		for (int i = 0; i < N; ++i) {
			long x = in.nextLong();
			long y = in.nextLong();
			points[i] = new Point(x, y);
		}
		
		Circle[] circles = new Circle[M];
		for (int i = 0; i < M; ++i) {
			long r = in.nextLong();
			long x = in.nextLong();
			long y = in.nextLong();
			circles[i] = new Circle(x, y, r);
		}
		
		for (int i = 0; i < N; ++i)
			for (int j = 0; j < M; ++j)
				if (circles[j].inside(points[i]))
					points[i].circles.set(j);
		
		for (int i = 0; i < K; ++i) {
			int a = in.nextInt() - 1;
			int b = in.nextInt() - 1;
			
			BitSet tmpOr = (BitSet) points[a].circles.clone();
			tmpOr.or(points[b].circles);
			int cnt = tmpOr.cardinality();
			
			BitSet tmpAnd = (BitSet) points[a].circles.clone();
			tmpAnd.and(points[b].circles);
			cnt -= tmpAnd.cardinality();
			
			System.out.println(cnt);
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
