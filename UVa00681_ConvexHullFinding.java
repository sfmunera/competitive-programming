package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 622 (681 - Convex Hull Finding) */
/* SUBMISSION: 09178631 */
/* SUBMISSION TIME: 2011-08-21 22:53:51 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa00681_ConvexHullFinding {
	
	static final double EPS = 1e-9;
	
	static class Point {
		int x;
		int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public String toString() {
			return this.x + " " + this.y;
		}
	}
	
	static int signedTriangleArea(Point a, Point b, Point c) {
		return a.x * b.y - a.y * b.x + a.y * c.x - a.x * c.y + b.x * c.y - c.x * b.y;
	}
	
	// Counterclockwise predicate. Says whether c is to the right of the line formed by a and b
	static boolean ccw(Point a, Point b, Point c) {
		return signedTriangleArea(a, b, c) > 0;
	}
	
	// Clockwise predicate. Says whether c is to the left of the line formed by a and b
	static boolean cw(Point a, Point b, Point c) {
		return signedTriangleArea(a, b, c) < 0;
	}
	
	// Says whether a, b, c are collinear
	static boolean collinear(Point a, Point b, Point c) {
		return signedTriangleArea(a, b, c) == 0;
	}
	
	static double distance(Point p1, Point p2) {
		int dx = p1.x - p2.x;
		int dy = p1.y - p2.y;
		return Math.sqrt(dx * dx + dy * dy);  
	}
	
	static Point[] graham(Point[] in) {
		int N = in.length;
		final Point first;
		
		// Choose the point with the least y coordinate, or least x coordinate in case of a tie
		int min = 0;
		for (int i = 1; i < N; ++i) {
			if (in[i].y < in[min].y)
				min = i;
			else if (in[i].y == in[min].y)
				if (in[i].x < in[min].x)
					min = i;
		}
		
		first = in[min];
		in[min] = in[0];
		in[0] = first;
		
		// Sort by angle with first
		Arrays.sort(in, 1, N, new Comparator<Point>() {
			public int compare(Point p1, Point p2) {
				if (collinear(first, p1, p2))
					return Double.compare(distance(first, p1), distance(first, p2));
				if (ccw(first, p1, p2))
					return -1;
				else
					return 1;
			}
			
		});
		if (N < 3)
			return in;
				
		Stack<Point> S = new Stack<Point>();
		S.push(in[0]);
		S.push(in[1]);
		
		for (int i = 2; i < N; ++i) {
			while (S.size() > 1) {
				Point top = S.pop();
				Point nextTop = S.pop();
				S.push(nextTop);
				S.push(top);
				
				if (!ccw(nextTop, top, in[i]))
					S.pop();
				else
					break;
			}
			S.push(in[i]);
		}
		
		int M = S.size();
		Point[] hull = new Point[M + 1];
		
		int k = M - 1;
		while (!S.isEmpty())
			hull[k--] = S.pop();
		hull[M] = hull[0];
		return hull;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		StringBuilder res = new StringBuilder();
		res.append(T + "\n");
		while (T-- > 0) {
			int N = Integer.parseInt(in.readLine());
			Point[] poly = new Point[N - 1];
			
			for (int i = 0; i < N - 1; ++i) {
				String line = in.readLine();
				StringTokenizer stk = new StringTokenizer(line);
				poly[i] = new Point(Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken()));
			}
			in.readLine();
			String delimiter = null;
			if (T > 0)
				delimiter = in.readLine();
			
			Point[] hull = graham(poly);
			res.append(hull.length + "\n");
			for (int i = 0; i < hull.length; ++i)
				res.append(hull[i] + "\n");
			if (T > 0)
				res.append(delimiter + "\n");
		}
		System.out.print(res);
		
		in.close();
		System.exit(0);
	}
}