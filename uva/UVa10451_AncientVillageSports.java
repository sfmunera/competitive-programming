package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1392 (10451 - Ancient Village Sports) */
/* SUBMISSION: 09299559 */
/* SUBMISSION TIME: 2011-09-26 00:30:35 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa10451_AncientVillageSports {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int t = 1;
		while (true) {
			StringTokenizer stk = new StringTokenizer(in.readLine());
			int N = Integer.parseInt(stk.nextToken());
			if (N < 3)
				break;
			double A = Double.parseDouble(stk.nextToken());
			
			double alpha = 2 * Math.PI / N;
			double r = Math.sqrt(A / (N * Math.sin(alpha / 2.0) * Math.cos(alpha / 2.0)));
			double a = r * Math.cos(alpha / 2.0);
			
			double As = Math.PI * r * r - A;
			double Ao = A - Math.PI * a * a;
			
			System.out.printf(Locale.ENGLISH, "Case %d: %.5f %.5f%n", t++, As, Ao);
		}
		
		in.close();
		System.exit(0);
	}
}
