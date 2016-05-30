package codeforces;

import java.util.*;

public class CountingRhombi {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		long W = in.nextLong();
		long H = in.nextLong();
		
		long ans = 0L;
		for (long w = 2L; w <= W; w += 2L) {
			for (long h = 2L; h <= H; h += 2L) {
				ans += (W - w + 1) * (H - h + 1);
			}
		}
		
		System.out.println(ans);
		
		in.close();
		System.exit(0);
	}
}
