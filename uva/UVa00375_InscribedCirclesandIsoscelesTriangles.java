package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 311 (375 - Inscribed Circles and Isosceles Triangles) */
/* SUBMISSION: 11465637 */
/* SUBMISSION TIME: 2013-03-18 19:01:33 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa00375_InscribedCirclesandIsoscelesTriangles {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		boolean first = true;
		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			in.readLine();
			StringTokenizer stk = new StringTokenizer(in.readLine());
			double B = Double.parseDouble(stk.nextToken());
			double H = Double.parseDouble(stk.nextToken());
			
			double ans = 0.0;
			while (true) {
				double alpha = Math.atan(2.0 * H / B);
				double r = B / 2.0 * Math.tan(alpha / 2.0);
				
				if (r < 0.000001) break;
				
				ans += 2.0 * Math.PI * r;
				H -= 2.0 * r;
				B = 2.0 * H / Math.tan(alpha);
			}
			
			if (first) first = false; else sb.append("\n");
			sb.append(String.format(Locale.ENGLISH, "%13.6f\n", ans));
		}
		System.out.print(sb);
		
		in.close();
		System.exit(0);
	}
}
