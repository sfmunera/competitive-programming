package codeforces;

import java.util.*;

public class JzzhuAndSequences {
	
	static final int MODULO = (int) 1e9 + 7;
	
	static long mod(long x) {
		long ans = (x + MODULO) % MODULO;
		return ans < 0 ? ans + MODULO : ans;
	}
	
	static long[][] times(long[][] a, long[][] b) {
		long[][] mult = new long[2][2];
		for (int i = 0; i < 2; ++i) {
			for (int j = 0; j < 2; ++j) {
				for (int k = 0; k < 2; ++k) {
					mult[i][j] += mod(a[i][k] * b[k][j]);
				}
			}
		}
		return mult;
	}
	
	static long[][] fastPow(long[][] base, int exp) {
		if (exp == 0) {
			return new long[][]{ {1, 0}, {0, 1}};
		}
		if (exp == 1) {
			return base;
		}
		
		if (exp % 2 == 1) {
			return times(base, fastPow(base, exp - 1));
		} else {
			long[][] pow = fastPow(base, exp / 2);
			return times(pow, pow);
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int x = in.nextInt();
		int y = in.nextInt();
		int n = in.nextInt();
		
		if (n == 1) {
			System.out.println(mod(x));
		} else if (n == 2) {
			System.out.println(mod(y));
		} else {
			long[][] pow = fastPow(new long[][]{ {0, 1}, {-1, 1} }, n - 1);
			long ans = mod(pow[0][0] * x + pow[0][1] * y);
			System.out.println(ans);
		}
		
		in.close();
		System.exit(0);
	}
}
