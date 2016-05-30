package codeforces;

import java.util.*;

public class WalkingInTheRain {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int[] a = new int[n];
		
		for (int i = 0; i < n; ++i) {
			a[i] = in.nextInt();
		}
		
		int time = 0;
		while (true) {
			if (a[0] - time <= 0 || a[n - 1] - time <= 0)
				break;
			boolean done = false;
			for (int i = 0; i < n - 1; ++i) {
				if (a[i] - time <= 0) continue;
				if (a[i + 1] - time <= 0 && (i + 2 >= n || a[i + 2] - time <= 0)) {
					done = true;
					break;
				}
			}
			if (done) break;
			++time;
		}
		
		System.out.println(time);
		
		in.close();
		System.exit(0);
	}
}
