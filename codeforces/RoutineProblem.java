package codeforces;

import java.util.*;

public class RoutineProblem {
	
	static int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a % b);
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int a = in.nextInt();
		int b = in.nextInt();
		int c = in.nextInt();
		int d = in.nextInt();
		
		int p = 1;
		int q = 1;
		if (a * d >= b * c) {
			p = a * d - b * c;
			q = a * d;
		} else {
			p = b * c - a * d;
			q = b * c;
		}
		
		int g = gcd(p, q);
		p /= g;
		q /= g;
		
		System.out.println(p + "/" + q);
		
		in.close();
		System.exit(0);
	}
}
