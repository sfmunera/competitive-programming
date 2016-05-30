package codeforces;

import java.util.*;

public class NonSquareEquation {

	static long sumDigits(long x) {
		long sum = 0;
		while (x > 0) {
			sum += x % 10;
			x /= 10;
		}
		
		return sum;
	}
	
	static long findRoot(long s, long n) {
		// solve x = (-b +/- sqrt(b*b - 4ac)) / 2a
		// b = s; a = 1; c = -n
		long x = Long.MAX_VALUE;
		long det = s * s + 4 * n;
		long detSqrt = Math.round(Math.sqrt(det));
		if (detSqrt * detSqrt != det) {
			return -1;
		}
		
		for (int k = -1; k <= 1; k += 2) {
			long tmp = -s + k * detSqrt;
			if (tmp > 0 && tmp % 2 == 0) {
				x = Math.min(x,tmp / 2);
			}
		}
		
		return x == Long.MAX_VALUE ? -1 : x;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		long n = in.nextLong();
		long ans = Long.MAX_VALUE;
		long maxSum = 100; // ~sumDigits(1e9)
		for (int s = 1; s <= maxSum; ++s) {
			long x = findRoot(s, n);
			if (x > 0 && s == sumDigits(x)) {
				ans = Math.min(ans, x);
			}
		}
		
		System.out.println(ans == Long.MAX_VALUE ? -1 : ans);
		
		in.close();
		System.exit(0);
	}
}
