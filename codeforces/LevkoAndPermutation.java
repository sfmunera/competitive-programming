package codeforces;

import java.util.*;

public class LevkoAndPermutation {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int k = in.nextInt();
		// Property: gcd(1, x) = 1, gcd(x, x + 1) = 1 -> shift first n-k elements 1 position
		// Property: k == n, impossible
		
		if (k == n) {
			System.out.println(-1);
		} else {
			int[] permutation = new int[n + 1];
			
			for (int i = 2; i <= n - k; ++i)
				permutation[i] = i - 1;
			permutation[1] = n - k;
			for (int i = n - k + 1; i <= n; ++i)
				permutation[i] = i;
			
			StringBuilder sb = new StringBuilder();
			for (int i = 1; i <= n; ++i) {
				if (i > 1) sb.append(" ");
				sb.append(permutation[i]);
			}
			System.out.println(sb);
		}
		
		in.close();
		System.exit(0);
	}
}
