package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2093 (11152 - Colourful Flowers) */
/* SUBMISSION: 09302279 */
/* SUBMISSION TIME: 2011-09-26 18:21:22 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa11152_ColourfulFlowers {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String line;
		StringTokenizer stk;
		while ((line = in.readLine()) != null) {
			stk = new StringTokenizer(line);
			double a = Double.parseDouble(stk.nextToken());
			double b = Double.parseDouble(stk.nextToken());
			double c = Double.parseDouble(stk.nextToken());
			
			double s = (a + b + c) / 2.0;
			double At = Math.sqrt(s * (s - a) * (s - b) * (s - c));
			
			double rc = (a * b * c) / (4.0 * At);
			double ri = 2.0 * At / (a + b + c);
			
			double Ac = Math.PI * rc * rc;
			double Ai = Math.PI * ri * ri;
			
			double sun = Ac - At;
			double violets = At - Ai;
			double roses = Ai;
			System.out.printf(Locale.ENGLISH, "%.4f %.4f %.4f%n", sun, violets, roses);
		}
		
		in.close();
		System.exit(0);
	}
}