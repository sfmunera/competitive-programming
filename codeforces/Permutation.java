package codeforces;

import java.util.*;

public class Permutation {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int k = in.nextInt();
		
		// start with sequence 1, 2, ..., 2*n, and invert first k pairs to obtain 2*k diff
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= 2 * k; i += 2) {
			if (i > 1) sb.append(" ");
			sb.append(i + 1);
			sb.append(" ");
			sb.append(i);
		}
		for (int i = 2 * k + 1; i <= 2 * n; ++i) {
			if (i > 1) sb.append(" ");
			sb.append(i);
		}
		System.out.println(sb);
		
		in.close();
		System.exit(0);
	}
}
