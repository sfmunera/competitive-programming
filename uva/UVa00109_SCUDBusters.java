package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 45 (109 - SCUD Busters) */
/* SUBMISSION: 09305546 */
/* SUBMISSION TIME: 2011-09-27 15:22:11 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;
import java.awt.*;

public class UVa00109_SCUDBusters {

	static int signedTriangleArea(Point a, Point b, Point c) {
		return a.x * b.y - a.y * b.x + a.y * c.x -
			   a.x * c.y + b.x * c.y - c.x * b.y;
	}
	
	static boolean ccw(Point a, Point b, Point c) {
		return signedTriangleArea(a, b, c) > 0;
	}
	
	static boolean collinear(Point a, Point b, Point c) {
		return signedTriangleArea(a, b, c) == 0;
	}
	
	static double distance(Point p1, Point p2) {
		double dx = p1.x - p2.x;
		double dy = p1.y - p2.y;
		
		return Math.sqrt(dx * dx + dy * dy);
	}
	
	static Polygon graham(Polygon poly) {
		int N = poly.npoints;
		int[] x = poly.xpoints;
		int[] y = poly.ypoints;
		
		Point[] in = new Point[N];
		for (int i = 0; i < N; ++i)
			in[i] = new Point(x[i], y[i]);
		
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
		int[] hullx = new int[M];
		int[] hully = new int[M];
		
		int k = M - 1;
		while (!S.isEmpty()) {
			Point q = S.pop();
			hullx[k] = q.x;
			hully[k] = q.y;
			k--;
		}
		
		return new Polygon(hullx, hully, M);
	}
	
	static double area(Polygon poly) {
		int N = poly.npoints;
		int[] x = poly.xpoints;
		int[] y = poly.ypoints;
		
		Point[] p = new Point[N];
		for (int i = 0; i < N; ++i)
			p[i] = new Point(x[i], y[i]);
		
		final Point first;
		
		int min = 0;
		for (int i = 1; i < N; ++i)
			if (p[i].y < p[min].y)
				min = i;
			else if (p[i].y == p[min].y)
				if (p[i].x < p[min].x)
					min = i;
		
		first = p[min];
		p[min] = p[0];
		p[0] = first;
				
		Arrays.sort(p, 1, N, new Comparator<Point>() {

			public int compare(Point p1, Point p2) {
				if (collinear(first, p1, p2))
					return Double.compare(distance(first, p1), distance(first, p2));
				if (ccw(first, p1, p2))
					return -1;
				else
					return 1;
			}
			
		});
		
		double A = 0.0;
		for (int i = 0; i < N; ++i) {
			int j = (i + 1) % N;
			A += p[i].x * p[j].y - p[j].x * p[i].y;
		}
		
		return A / 2.0;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		ArrayList<Polygon> polygons = new ArrayList<Polygon>();
		while (true) {
			int N = Integer.parseInt(in.readLine());
			
			if (N == -1)
				break;
			
			int[] x = new int[N];
			int[] y = new int[N];
			
			for (int i = 0; i < N; ++i) {
				StringTokenizer stk = new StringTokenizer(in.readLine());
				x[i] = Integer.parseInt(stk.nextToken());
				y[i] = Integer.parseInt(stk.nextToken());
			}
			
			polygons.add(new Polygon(x, y, N));
		}
		
		double total = 0.0;
		int M = polygons.size();
		
		double[] areas = new double[M];
		boolean[] visited = new boolean[M];
		for (int i = 0; i < M; ++i) {
			Polygon hull = graham(polygons.get(i));
			areas[i] = area(hull);
			polygons.set(i, hull);
		}
		
		for (int i = 0; i < M; ++i) {
			
		}
		
		String line;
		StringTokenizer stk;
		while ((line = in.readLine()) != null) {
			stk = new StringTokenizer(line);
			int qx = Integer.parseInt(stk.nextToken());
			int qy = Integer.parseInt(stk.nextToken());
			Point q = new Point(qx, qy);
			
			for (int i = 0; i < M; ++i) {
				Polygon p = polygons.get(i);
				if (p.contains(q)) {
					if (!visited[i]) {
						total += areas[i];
						visited[i] = true;
					}
					break;
				}
			}
		}
		System.out.printf(Locale.ENGLISH, "%.2f%n", total);
		
		in.close();
		System.exit(0);
	}
}