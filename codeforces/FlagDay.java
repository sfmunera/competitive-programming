package codeforces;

import java.util.*;

public class FlagDay {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int m = in.nextInt();
		
		int[] color = new int[n];
		Arrays.fill(color, -1);
		for (int i = 0; i < m; ++i) {
			int[] d = new int[3];
			for (int j = 0; j < 3; ++j)
				d[j] = in.nextInt() - 1;
			
			for (int j = 0; j < 3; ++j) {
				if (color[d[j]] > 0) continue;
				for (int c = 1; c <= 3; ++c) {
					boolean can = true;
					for (int k = 0; k < 3; ++k) {
						if (k != j && color[d[k]] == c) {
							can = false;
						}
					}
					if (can) {
						color[d[j]] = c;
						break;
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; ++i) {
			if (i > 0) sb.append(" ");
			sb.append(color[i]);
		}
		System.out.println(sb);
		
		in.close();
		System.exit(0);
	}
}
