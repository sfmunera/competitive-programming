package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1162 (10221 - Satellites) */
/* SUBMISSION: 09299455 */
/* SUBMISSION TIME: 2011-09-25 23:30:01 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa10221_Satellites {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String line;
		StringTokenizer stk;
		while ((line = in.readLine()) != null) {
			stk = new StringTokenizer(line);
			double s = Double.parseDouble(stk.nextToken());
			double a = Double.parseDouble(stk.nextToken());
			String unit = stk.nextToken();
			
			if (unit.equals("min"))
				a /= 60;
			
			if (a > 180.0)
				a = 360.0 - a;
			
			double r = s + 6440.0;
			
			double l = 2.0 * r * Math.sin((a * Math.PI / 180.0) / 2.0);
			double x = 2.0 * Math.PI * r * a / 360.0;
			
			System.out.printf(Locale.ENGLISH, "%.6f %.6f%n", x, l);
		}
		
		in.close();
		System.exit(0);
	}
}
