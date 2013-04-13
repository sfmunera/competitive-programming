package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 379 (438 - The Circumference of the Circle) */
/* SUBMISSION: 09301645 */
/* SUBMISSION TIME: 2011-09-26 15:47:01 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa00438_TheCircumferenceoftheCircle {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String line;
		StringTokenizer stk;
		while ((line = in.readLine()) != null) {
			stk = new StringTokenizer(line);
			double x1 = Double.parseDouble(stk.nextToken());
			double y1 = Double.parseDouble(stk.nextToken());
			double x2 = Double.parseDouble(stk.nextToken());
			double y2 = Double.parseDouble(stk.nextToken());
			double x3 = Double.parseDouble(stk.nextToken());
			double y3 = Double.parseDouble(stk.nextToken());
			
			double a = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
			double b = Math.sqrt((x1 - x3) * (x1 - x3) + (y1 - y3) * (y1 - y3));
			double c = Math.sqrt((x3 - x2) * (x3 - x2) + (y3 - y2) * (y3 - y2));
			
			double s = (a + b + c) / 2.0;
			double A = Math.sqrt(s * (s - a) * (s - b) * (s - c));
			double r = (a * b * c) / (4.0 * A);
			
			System.out.printf(Locale.ENGLISH, "%.2f%n", 2.0 * Math.PI * r);
		}
		
		in.close();
		System.exit(0);
	}
}