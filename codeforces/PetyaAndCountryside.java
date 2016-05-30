package codeforces;

import java.util.*;

public class PetyaAndCountryside {
	
	static int countIrrigated(int[] h, int pos) {
		int cnt = 1;
		// (pos, n)
		for (int i = pos + 1; i < h.length && h[i] <= h[i - 1]; ++i)
			++cnt;
		// [0, pos)
		for (int i = pos - 1; i >= 0 && h[i] <= h[i + 1]; --i)
			++cnt;
		return cnt;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int[] h = new int[n];
		
		for (int i = 0; i < n; ++i) {
			h[i] = in.nextInt();
		}
		
		int ans = 0;
		for (int i = 0; i < n; ++i) {
			ans = Math.max(ans, countIrrigated(h, i));
		}
		System.out.println(ans);
		
		in.close();
		System.exit(0);
	}
}
