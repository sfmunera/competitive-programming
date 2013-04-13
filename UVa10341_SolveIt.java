package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1282 (10341 - Solve It) */
/* SUBMISSION: 10112894 */
/* SUBMISSION TIME: 2012-05-14 15:44:10 */
/* LANGUAGE: 2 */

import java.io.*;
import java.util.*;

public class UVa10341_SolveIt {
	
	static final double EPS = 1e-15;
	
	static int p, q, r, s, t, u;
	
	static double f(double x) {
		return  (double)p * Math.exp(-x) + q * Math.sin(x) + r * Math.cos(x) + s * Math.tan(x) + t * x * x + u;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String line;
		while ((line = in.readLine()) != null) {
			String[] parts = line.split("[ ]+");
			p = Integer.parseInt(parts[0]);
			q = Integer.parseInt(parts[1]);
			r = Integer.parseInt(parts[2]);
			s = Integer.parseInt(parts[3]);
			t = Integer.parseInt(parts[4]);
			u = Integer.parseInt(parts[5]);
			
			double lo = 0.0;
			double hi = 1.0;
			double res = 0.0;
			
			double a = f(lo);
			double b = f(hi);
			
			if (a * b > EPS)
				System.out.println("No solution");
			else if (Math.abs(a) < EPS)
				System.out.printf(Locale.ENGLISH, "0.0000\n");
			else if (Math.abs(b) < EPS)
				System.out.printf(Locale.ENGLISH, "1.0000\n");
			else {
				while (Math.abs(hi - lo) > EPS) {
					double mid = (lo + hi) / 2;
					
					if (f(mid) * f(hi) > EPS)
						hi = mid;
					else
						lo = mid;
					res = mid;
				}
				System.out.printf(Locale.ENGLISH, "%.4f\n", res);
			}
			
		}
		
		in.close();
		System.exit(0);
	}
}
