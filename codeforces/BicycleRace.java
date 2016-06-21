package codeforces;

import java.util.*;

public class BicycleRace {
	
	static class Point {
		int x, y;
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static boolean isHorizontal(Point p0, Point p1) {
		return p0.y == p1.y;
	}
	
	static boolean isLeftTurn(Point p0, Point p1, Point p2) {
		if (isHorizontal(p0, p1)) {
			if (p0.x < p1.x) return p2.y > p1.y;
			else return p2.y < p1.y;
		} else {
			if (p0.y < p1.y) return p2.x < p1.x;
			else return p2.x > p1.x;
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		Point[] points = new Point[n];
		for (int i = 0; i <= n; ++i) {
			int x0 = in.nextInt();
			int y0 = in.nextInt();
			
			if (i < n)
				points[i] = new Point(x0, y0);
		}
		
		int ans = 0;
		for (int i = 1; i < n - 1; ++i) {
			if (isLeftTurn(points[i - 1], points[i], points[i + 1])) {
				++ans;
			}
		}
		
		System.out.println(ans);
		
		in.close();
		System.exit(0);
	}
}
