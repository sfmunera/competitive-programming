package codeforces;

import java.util.*;

public class SpecialOfferSuperPrice999Bourles {
	
	static boolean valid(long x, long p, long d) {
		return x >= p - d && x <= p;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		long p = in.nextLong();
		long d = in.nextLong();
		
		long powerOf10 = 1;
		long suffix = 0;
		long prefix = p;
		long ans = p;
		while (prefix > 0) {
			prefix /= 10;
			suffix += powerOf10 * 9;
			powerOf10 *= 10;
			if (!valid(prefix * powerOf10 + suffix, p, d)) {
				--prefix;
			}
			if (!valid(prefix * powerOf10 + suffix, p, d)) {
				break;
			}
			ans = prefix * powerOf10 + suffix;
		}
		
		System.out.println(ans);
		
		in.close();
		System.exit(0);
	}
}
