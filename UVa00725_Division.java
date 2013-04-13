package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 666 (725 - Division) */
/* SUBMISSION: 10116446 */
/* SUBMISSION TIME: 2012-05-15 14:18:58 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa00725_Division {
	
	static class Fraction implements Comparable<Fraction> {
		int num, den;
		
		public Fraction(int num, int den) {
			this.num = num;
			this.den = den;
		}

		public int compareTo(Fraction f) {
			if (this.num != f.num)
				return this.num - f.num;
			return this.den - f.den;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		boolean first = true;
		while (true) {
			int N = Integer.parseInt(in.readLine());
			if (N == 0)
				break;
			
			List<Fraction> fractions = new ArrayList<Fraction>();
			for (int a = 0; a < 10; ++a)
				for (int b = 0; b < 10; ++b)
					for (int c = 0; c < 10; ++c)
						for (int d = 0; d < 10; ++d)
							for (int e = 0; e < 10; ++e) {
								int den = e + 10 * d + 100 * c + 1000 * b + 10000 * a;
								int num = den * N;
								
								if (num > 98765)
									continue;
								
								int[] cnt = new int[10];
												
								int tmp = num;
								for (int i = 0; i < 5; ++i) {
									int dig = tmp % 10;
									++cnt[dig];
									tmp /= 10;
								}
								tmp = den;
								for (int i = 0; i < 5; ++i) {
									int dig = tmp % 10;
									++cnt[dig];
									tmp /= 10;
								}
								boolean ok = true;
								for (int i = 0; i < 10 && ok; ++i)
									if (cnt[i] != 1)
										ok = false;
												
								if (ok) {
									fractions.add(new Fraction(num, den));
								}
							}
			if (first)
				first = false;
			else
				System.out.println();
			
			if (fractions.isEmpty())
				System.out.println("There are no solutions for " + N + ".");
			else {
				Collections.sort(fractions);
				for (Fraction f : fractions)
					System.out.printf("%05d / %05d = %d\n", f.num, f.den, N);
			}
		}
		
		in.close();
		System.exit(0);
	}
}
