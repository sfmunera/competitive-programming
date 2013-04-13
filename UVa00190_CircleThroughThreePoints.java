package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 126 (190 - Circle Through Three Points) */
/* SUBMISSION: 09301728 */
/* SUBMISSION TIME: 2011-09-26 16:13:17 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa00190_CircleThroughThreePoints {
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
			
			double h = 0.0;
			double k = 0.0;
			double r = 0.0;
			
			boolean isRight = false;
			
			double d12 = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
			double d13 = Math.sqrt((x3 - x1) * (x3 - x1) + (y3 - y1) * (y3 - y1));
			double d23 = Math.sqrt((x2 - x3) * (x2 - x3) + (y2 - y3) * (y2 - y3));
			
			if (Math.abs(d12 * d12 + d13 * d13 - d23 * d23) < 1e-6) {
				isRight = true;
				h = (x2 + x3) / 2.0;
				k = (y2 + y3) / 2.0;
			}
			if (Math.abs(d12 * d12 + d23 * d23 - d13 * d13) < 1e-6) {
				isRight = true;
				h = (x1 + x3) / 2.0;
				k = (y1 + y3) / 2.0;
			}
			if (Math.abs(d23 * d23 + d13 * d13 - d12 * d12) < 1e-6) {
				isRight = true;
				h = (x2 + x1) / 2.0;
				k = (y2 + y1) / 2.0;
			}
			
			if (!isRight) {
				if (Double.compare(x2, x1) == 0 || Double.compare(y2, y1) == 0) {
					double t = x2;
					x2 = x3;
					x3 = t;
					
					t = y2;
					y2 = y3;
					y3 = t;
				}
				
				// Line between A and B
				double m12 = (y2 - y1) / (x2 - x1);
				double b12 = y1 - m12 * x1;
				
				// Line bisectriz to 12
				double m12b = -1.0 / m12;
				double xm = (x1 + x2) / 2.0;
				
				double b12b = b12 + m12 * xm - m12b * xm;
				
				
				if (Double.compare(x3, x2) == 0 || Double.compare(y3, y2) == 0) {
					double t = x2;
					x2 = x1;
					x1 = t;
					
					t = y2;
					y2 = y1;
					y1 = t;
				}
				
				// Line between B and C
				double mBC = (y3 - y2) / (x3 - x2);
				double bBC = y2 - mBC * x2;
				
				// Line bisectriz to BC
				double mBCb = -1.0 / mBC;
				xm = (x2 + x3) / 2.0;
				
				double bBCb = bBC + mBC * xm - mBCb * xm;
			
			
				// Where both bisectrices intersect is the center of the circle
				h = (bBCb - b12b) / (m12b - mBCb);
				k = m12b * h + b12b;
			}
			r = Math.sqrt((h - x1) * (h - x1) + (k - y1) * (k - y1));
			double c = -2.0 * h;
			double d = -2.0 * k;
			double e = h * h + k * k - r * r;
			
			if (Math.abs(h - 0.0) < 1e-6 && Math.abs(k - 0.0) < 1e-6)
				System.out.printf(Locale.ENGLISH, "x^2 + y^2 = %.3f^2%n", r);
			else if (Math.abs(h - 0.0) < 1e-6)
				System.out.printf(Locale.ENGLISH, "x^2 + (y " + (k < 0 ? "+" : "-") + " %.3f)^2 = %.3f^2%n", Math.abs(k), r);
			else if (Math.abs(k - 0.0) < 1e-6)
				System.out.printf(Locale.ENGLISH, "(x " + (h < 0 ? "+" : "-") + " %.3f)^2 + y^2 = %.3f^2%n", Math.abs(h), r);
			else
				System.out.printf(Locale.ENGLISH, "(x " + (h < 0 ? "+" : "-") + " %.3f)^2 + (y " + (k < 0 ? "+" : "-") + " %.3f)^2 = %.3f^2%n", Math.abs(h), Math.abs(k), r);
			
			
			
			if (Math.abs(c - 0.0) < 1e-6 && Math.abs(d - 0.0) < 1e-6 && Math.abs(e - 0.0) < 1e-6)
				System.out.printf(Locale.ENGLISH, "x^2 + y^2 = 0%n");
			else if (Math.abs(d - 0.0) < 1e-6 && Math.abs(e - 0.0) < 1e-6)
				System.out.printf(Locale.ENGLISH, 
						"x^2 + y^2 " + (c < 0 ? "-" : "+") + " %.3fx = 0%n", Math.abs(c));
			else if (Math.abs(c - 0.0) < 1e-6 && Math.abs(e - 0.0) < 1e-6)
				System.out.printf(Locale.ENGLISH, 
						"x^2 + y^2 " + (d < 0 ? "-" : "+") + " %.3fy = 0%n", Math.abs(d));
			else if (Math.abs(c - 0.0) < 1e-6 && Math.abs(d - 0.0) < 1e-6)
				System.out.printf(Locale.ENGLISH, 
						"x^2 + y^2 " + (e < 0 ? "-" : "+") + " %.3f = 0%n", Math.abs(e));
			else if (Math.abs(c - 0.0) < 1e-6)
				System.out.printf(Locale.ENGLISH, 
						"x^2 + y^2 " + 
						(d < 0 ? "-" : "+") + " %.3fy " + 
						(e < 0 ? "-" : "+") + " %.3f = 0%n", Math.abs(d), Math.abs(e));
			else if (Math.abs(d - 0.0) < 1e-6)
				System.out.printf(Locale.ENGLISH, 
						"x^2 + y^2 " + 
						(c < 0 ? "-" : "+") + " %.3fx " + 
						(e < 0 ? "-" : "+") + " %.3f = 0%n", Math.abs(c), Math.abs(e));
			else if (Math.abs(e - 0.0) < 1e-6)
				System.out.printf(Locale.ENGLISH, 
						"x^2 + y^2 " + 
						(c < 0 ? "-" : "+") + " %.3fx " + 
						(d < 0 ? "-" : "+") + " %.3fy = 0%n", Math.abs(c), Math.abs(d));
			else
				System.out.printf(Locale.ENGLISH, 
						"x^2 + y^2 " + 
						(c < 0 ? "-" : "+") + " %.3fx " + 
						(d < 0 ? "-" : "+") + " %.3fy " + 
						(e < 0 ? "-" : "+") + " %.3f = 0%n", Math.abs(c), Math.abs(d), Math.abs(e));
			System.out.println();
		}
		
		in.close();
		System.exit(0);
	}
}