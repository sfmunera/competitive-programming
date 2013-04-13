package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1349 (10408 - Farey sequences) */
/* SUBMISSION: 08927385 */
/* SUBMISSION TIME: 2011-06-07 19:04:35 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa10408_Fareysequences {
	
	static class Fraction implements Comparable<Fraction> {

		int num;
		int den;
		
		public Fraction(int n, int d) {
			this.num = n;
			this.den = d;
		}
		
		public int compareTo(Fraction f) {
			double dif = (double)this.num / (double)this.den - (double)f.num / (double)f.den;
			if (dif < 0)
				return -1;
			else if (dif > 0)
				return 1;
			return 0;
		}
		
		public String toString() {
			return this.num + "/" + this.den;
		}
		
	}
	
	static int gcd(int a, int b) {
		while (b != 0) {
			int t = b;
			b = a % b;
			a = t;
		}
		return a;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		while (in.hasNextInt()) {
			int n = in.nextInt();
			int k = in.nextInt();
			
			List<Fraction> seq = new ArrayList<Fraction>();
			
			for (int num = 1; num < n; ++num)
				for (int den = num + 1; den <= n; ++den) {
					if (gcd(num, den) == 1)
						seq.add(new Fraction(num, den));
				}
			seq.add(new Fraction(1, 1));
			Collections.sort(seq);
			//System.out.println(seq);
			System.out.println(seq.get(k - 1));
		}
	}
}
