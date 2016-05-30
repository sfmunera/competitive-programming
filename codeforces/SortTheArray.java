package codeforces;

import java.util.*;

public class SortTheArray {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int[] a = new int[n + 1];
		for (int i = 0; i < n; ++i) {
			a[i] = in.nextInt();
		}
		a[n] = Integer.MAX_VALUE;
		
		int cnt = 0; // how many decreasing sequences?
		int start = 0;
		int end = 0;
		for (int i = 0; i < n; ++i) {
			if (a[i] > a[i + 1]) {
				start = i;
				while (i < n && a[i] > a[i + 1]) {
					++i;
				}
				end = i;
				++cnt;
			}
		}
		
		boolean yes = false;		
		if (cnt <= 1) {
			yes = true;
			if (start > 0 && a[start - 1] >= a[end]) yes = false;
			if (end < n && a[start] >= a[end + 1]) yes = false;
		}
		
		if (yes) {
			System.out.println("yes");
			System.out.println((start + 1) + " " + (end + 1));
		} else {
			System.out.println("no");
		}
		
		in.close();
		System.exit(0);
	}
}
