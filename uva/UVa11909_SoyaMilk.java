package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 3060 (11909 - Soya Milk) */
/* SUBMISSION: 09302374 */
/* SUBMISSION TIME: 2011-09-26 18:47:35 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa11909_SoyaMilk {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String line;
		StringTokenizer stk;
		while ((line = in.readLine()) != null) {
			stk = new StringTokenizer(line);
			double l = Double.parseDouble(stk.nextToken());
			double w = Double.parseDouble(stk.nextToken());
			double h = Double.parseDouble(stk.nextToken());
			double th = Double.parseDouble(stk.nextToken()) * Math.PI / 180.0;
			
			double V = 0.0;
			if (l * Math.tan(th) - h <= 1e-9)
				V = w * (l * h - 0.5 * l * l * Math.tan(th));
			else
				V = 0.5 * w * h * h / Math.tan(th);
			System.out.printf(Locale.ENGLISH, "%.3f mL%n", V);
		}
	}
}