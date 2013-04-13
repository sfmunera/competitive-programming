package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1932 (10991 - Region) */
/* SUBMISSION: 09302247 */
/* SUBMISSION TIME: 2011-09-26 18:10:39 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa10991_Region {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		while (T-- > 0) {
			StringTokenizer stk = new StringTokenizer(in.readLine());
			double R1 = Double.parseDouble(stk.nextToken());
			double R2 = Double.parseDouble(stk.nextToken());
			double R3 = Double.parseDouble(stk.nextToken());
			
			double a = R2 + R3;
			double b = R1 + R3;
			double c = R1 + R2;
			
			double alpha = Math.acos((b * b + c * c - a * a) / (2.0 * b * c));
			double beta = Math.acos((a * a + c * c - b * b) / (2.0 * a * c));
			double gamma = Math.acos((a * a + b * b - c * c) / (2.0 * a * b));
			
			double s = (a + b + c) / 2.0;
			double A = Math.sqrt(s * (s - a) * (s - b) * (s - c));
			
			double slice1 = alpha * R1 * R1 / 2.0;
			double slice2 = beta * R2 * R2 / 2.0;
			double slice3 = gamma * R3 * R3 / 2.0;
			
			double res = A - slice1 - slice2 - slice3;
			System.out.printf(Locale.ENGLISH, "%.6f%n", res);
		}
		
		in.close();
		System.exit(0);
	}
}