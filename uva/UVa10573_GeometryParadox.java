package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1514 (10573 - Geometry Paradox) */
/* SUBMISSION: 09299837 */
/* SUBMISSION TIME: 2011-09-26 03:16:11 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa10573_GeometryParadox {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		while (T-- > 0) {
			StringTokenizer stk = new StringTokenizer(in.readLine());
			int n = stk.countTokens();
			
			double A = 0.0;
			if (n == 1) {
				int t = Integer.parseInt(stk.nextToken());
				double R = t / 2.0;
				A = Math.PI * R * R / 2.0;
			} else {
				int r1 = Integer.parseInt(stk.nextToken());
				int r2 = Integer.parseInt(stk.nextToken());
				A = 2.0 * Math.PI * r1 * r2;
			}
			System.out.printf(Locale.ENGLISH, "%.4f%n", A);
		}
		
		in.close();
		System.exit(0);
	}
}
