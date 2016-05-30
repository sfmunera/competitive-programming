package codeforces;

import java.util.*;

public class Archer {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int a = in.nextInt();
		int b = in.nextInt();
		int c = in.nextInt();
		int d = in.nextInt();
		
		// Pr[SmallR wins] = p + (1-p)(1-q)*p + (1-p)^2(1-q)^2*p + ...
		double p = (double) a / b;
		double q = (double) c / d;
		
		double prob = 1.0;
		double r = 1.0;
		while (r > 1e-9) {
			r *= (1.0 - p) * (1.0 - q);
			prob += r;
		}
		prob *= p;
		
		System.out.printf("%.9f\n", prob);
		
		in.close();
		System.exit(0);
	}
}
