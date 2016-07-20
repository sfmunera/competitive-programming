package codeforces;

import java.util.*;

public class Steps {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int m = in.nextInt();
		int xc = in.nextInt() - 1;
		int yc = in.nextInt() - 1;
		int k = in.nextInt();

		long ans = 0;
		for (int i = 0; i < k; ++i) {
			int dx = in.nextInt();
			int dy = in.nextInt();
			
			int stepsHor = (int) 1e9;
			int stepsVer = (int) 1e9;
			if (dx > 0) {
				stepsHor = Math.abs((n - 1 - xc) / dx);
			} else if (dx < 0) {
				stepsHor = Math.abs(xc / dx);
			}
			
			if (dy > 0) {
				stepsVer = Math.abs((m - 1 - yc) / dy);
			} else if (dy < 0) {
				stepsVer = Math.abs(yc / dy);
			}
			
			int steps = Math.min(stepsHor, stepsVer);
			ans += (long) steps;
			
			xc += dx * steps;
			yc += dy * steps;
			
			//System.out.println(steps + " steps to (" + xc + ", " + yc + ")");
		}
		
		System.out.println(ans);
		
		in.close();
		System.exit(0);
	}
}
