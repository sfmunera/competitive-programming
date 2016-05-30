package codeforces;

import java.util.*;

public class PaintingPebbles {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int k = in.nextInt();
		int[] a = new int[n];
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; ++i) {
			a[i] = in.nextInt();
			min = Math.min(min, a[i]);
			max = Math.max(max, a[i]);
		}
		
		// put first color in each pile min times
		// then put once every color
		// this is not possible when max - min > k
		if (max - min > k) {
			System.out.println("NO");
		} else {
			System.out.println("YES");
			for (int i = 0; i < n; ++i) {
				for (int j = 0; j < min; ++j) {
					if (j > 0) System.out.print(" ");
					System.out.print(1);
				}
				for (int l = 1; l <= k && l + min <= a[i]; ++l) {
					System.out.print(" " + l);
				}
				System.out.println();
			}
		}
		
		in.close();
		System.exit(0);
	}
}
