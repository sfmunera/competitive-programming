package codeforces;

import java.util.Scanner;

public class DZYLovesHash {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int p = in.nextInt();
		int n = in.nextInt();
		
		
		boolean[] seen = new boolean[p];
		int ans = -1;
		for (int i = 0; i < n; ++i) {
			int x = in.nextInt();
			if (seen[x % p]) {
				if (ans < 0) ans = i + 1;
			} else {
				seen[x % p] = true;
			}
		}
		
		System.out.println(ans);
		
		in.close();
		System.exit(0);
	}
}
