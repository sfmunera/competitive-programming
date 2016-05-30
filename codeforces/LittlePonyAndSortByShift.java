package codeforces;

import java.util.*;

public class LittlePonyAndSortByShift {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int[] a = new int[n];
		
		for (int i = 0; i < n; ++i) {
			a[i] = in.nextInt();
		}

		int cnt = 0;
		int turningPoint = n;
		for (int i = 0; i < n - 1; ++i) {
			if (a[i] > a[i + 1]) {
				++cnt;
				turningPoint = i + 1;
			}
		}
		
		if (cnt == 0) {
			System.out.println(0);
		} else if (cnt == 1 && a[n - 1] <= a[0]) {
			System.out.println(n - turningPoint);
		} else {
			System.out.println(-1);
		}
		
		in.close();
		System.exit(0);
	}
}
