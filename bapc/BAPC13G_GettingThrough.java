package bapc;

import java.util.*;

public class BAPC13G_GettingThrough {
	
	static class Circle {
		int x, y, r;
		Circle(int x, int y, int r) {
			this.x = x;
			this.y = y;
			this.r = r;
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt();
		while (T-- > 0) {
			int w = in.nextInt();
			int n = in.nextInt();
			
			Circle[] sensors = new Circle[n];
			for (int i = 0; i < n; ++i) {
				sensors[i] = new Circle(in.nextInt(), in.nextInt(), in.nextInt());
			}
			
			double ans = 0.0;
			double low = 0.0;
			double high = 2.0 * 100000.0;
			while (high - low > 1e-6) {
				double mid = (low + high) / 2.0;
				if (can(mid)) {
					ans = mid;
					low = mid;
				} else {
					high = mid;
				}
			}
			
			System.out.printf("%.6f\n", ans);
		}
		
		in.close();
		System.exit(0);
	}
}
