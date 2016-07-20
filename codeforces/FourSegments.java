package codeforces;

import java.util.*;

public class FourSegments {
	
	static class Line {
		Point start, end;
		Line(Point start, Point end) {
			this.start = start;
			this.end = end;
		}
		
		Line inverted() {
			return new Line(end, start);
		}
		
		@Override
		public String toString() {
			return start + " --> " + end;
		}
	}
	
	static class Point {
		int x, y;
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public int hashCode() {
			return x + y;
		}
		@Override
		public boolean equals(Object o) {
			if (o == null) return false;
			if (this == o) return true;
			if (!(o instanceof Point)) return false;
			
			Point that = (Point) o;
			return this.x == that.x && this.y == that.y;
		}
		
		@Override
		public String toString() {
			return "(" + x + ", " + y + ")";
		}
	}
	
	static boolean isPoint(Line l) {
		return l.start.x == l.end.x && l.start.y == l.end.y;
	}
	
	static boolean isRectangle(Line l1, Line l2, Line l3, Line l4) {
		//System.out.println("isRectangle " + l1 + " " + l2 + " " + l3 + " " + l4);
		if (isPoint(l1) || isPoint(l2) || isPoint(l3) || isPoint(l4)) return false;
		
		if (!(l1.end.equals(l2.start) && l2.end.equals(l3.start) && l3.end.equals(l4.start) && l4.end.equals(l1.start)))
			return false;
		
		if (!(l1.end.y == l3.start.y && l1.start.y == l3.end.y && l2.start.x == l4.end.x && l2.end.x == l4.start.x))
			return false;
		
		return true;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		Line[] lines = new Line[4];
		for (int i = 0; i < 4; ++i) {
			int x1 = in.nextInt();
			int y1 = in.nextInt();
			int x2 = in.nextInt();
			int y2 = in.nextInt();
			
			lines[i] = new Line(new Point(x1, y1), new Point(x2, y2));
		}
			
		boolean isRectangle = false;
		for (int a = 0; a < 4; ++a) {
			for (int b = 0; b < 4; ++b) {
				if (a == b) continue;
				for (int c = 0; c < 4; ++c) {
					if (a == c || b == c) continue;
					for (int d = 0; d < 4; ++d) {
						if (a == d || b == d || c == d) continue;
						int[] pos = {a, b, c, d};
						for (int mask = 0; mask < (1 << 4); ++mask) {
							Line[] permutation = new Line[4];
							for (int i = 0; i < 4; ++i) {
								if ((mask & (1 << i)) > 0) permutation[i] = lines[pos[i]].inverted();
								else permutation[i] = lines[pos[i]];
							}
							
							if (isRectangle(permutation[0],
									permutation[1],
									permutation[2],
									permutation[3])) {
								isRectangle = true;
							}
						}
					}
				}
			}
		}
		
		System.out.println(isRectangle ? "YES" : "NO");
		
		in.close();
		System.exit(0);
	}
}
