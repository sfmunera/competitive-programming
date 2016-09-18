package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1136 (10195 - The Knights Of The Round Table) */
/* SUBMISSION: 09301883 */
/* SUBMISSION TIME: 2011-09-26 16:45:47 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa10195_TheKnightsOfTheRoundTable {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String line;
		StringTokenizer stk;
		while ((line = in.readLine()) != null) {
			stk = new StringTokenizer(line);
			double a = Double.parseDouble(stk.nextToken());
			double b = Double.parseDouble(stk.nextToken());
			double c = Double.parseDouble(stk.nextToken());
			
			double r = 0.0;
			
			if (Math.abs(a) >= 1e-9 && Math.abs(b) >= 1e-9 && Math.abs(c) >= 1e-9) {
				double s = (a + b + c) / 2.0;
				double A = Math.sqrt(s * (s - a) * (s - b) * (s - c));
				r = 2.0 * A / (a + b + c);
			}
			System.out.printf(Locale.ENGLISH, "The radius of the round table is: %.3f%n", r);
		}
		
		in.close();
		System.exit(0);
	}
}