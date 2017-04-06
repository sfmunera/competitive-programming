package codeforces;

import java.util.*;

public class MagicFormulas {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int[] p = new int[n + 1];
		
		for (int i = 1; i <= n; i++) {
			p[i] = in.nextInt();
		}
		
		int[] s = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			s[i] = i ^ s[i - 1];
		}
		
		int ans = 0;
		for (int i = 1; i <= n; i++) {
			int div = n / i;
			int mod = n % i;
			ans ^= p[i] ^ s[mod];
			if (div % 2 != 0) {
				ans ^= s[i - 1];
			}
		}
		
		System.out.println(ans);
		
		in.close();
		System.exit(0);
	}
}
