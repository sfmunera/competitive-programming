import java.util.*;

public class Watchmen {
	
	static class Point implements Comparable<Point> {
		int x, y;
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public int compareTo(Point that) {
			if (this.x != that.x) return this.x - that.x;
			return this.y - that.y;
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		Point[] points = new Point[n];
		Map<Integer, Integer> xCount = new HashMap<>();
		Map<Integer, Integer> yCount = new HashMap<>();
		
		for (int i = 0; i < n; i++) {
			points[i] = new Point(in.nextInt(), in.nextInt());
			if (!xCount.containsKey(points[i].x)) xCount.put(points[i].x, 0);
			if (!yCount.containsKey(points[i].y)) yCount.put(points[i].y, 0);
			xCount.put(points[i].x, xCount.get(points[i].x) + 1);
			yCount.put(points[i].y, yCount.get(points[i].y) + 1);
		}
		long ans = 0;
		for (int k : xCount.keySet()) {
			long count = (long)xCount.get(k);
			ans += count * (count - 1L) / 2L;
		}
		for (int k : yCount.keySet()) {
			long count = (long)yCount.get(k);
			ans += count * (count - 1L) / 2L;
		}
		
		Arrays.sort(points);
		Point prev = null;
		long count = 0L;
		for (Point point : points) {
			if (prev == null || (point.x != prev.x || point.y != prev.y)) {
				ans -= count * (count - 1L) / 2L;
				count = 1L;
			} else {
				count++;
			}
			prev = point;
		}
		ans -= count * (count - 1L) / 2L;
		System.out.println(ans);
		
		in.close();
		System.exit(0);
	}
}
