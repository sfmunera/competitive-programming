package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1373 (10432 - Polygon Inside A Circle) */
/* SUBMISSION: 09121652 */
/* SUBMISSION TIME: 2011-08-06 20:48:28 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa10432_PolygonInsideACircle {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String line;
		while ((line = in.readLine()) != null) {
			StringTokenizer stk = new StringTokenizer(line);
			double r = Double.parseDouble(stk.nextToken());
			int n = Integer.parseInt(stk.nextToken());
			
			double alpha = 2 * Math.PI / n;
			double x = 2 * Math.sin(alpha / 2.0) * r;
			double h = Math.sqrt(r * r - x * x / 4);
			
			double area = n * x * h / 2.0;
			System.out.printf(Locale.ENGLISH, "%.3f%n", area);
		}
		
		in.close();
		System.exit(0);
	}
}
