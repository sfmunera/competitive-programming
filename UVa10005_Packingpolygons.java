package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 946 (10005 - Packing polygons) */
/* SUBMISSION: 11466620 */
/* SUBMISSION TIME: 2013-03-18 23:13:38 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa10005_Packingpolygons {
	
	static boolean valid(double xc, double yc, double R, double[] x, double[] y) {
		int N = x.length;
		for (int k = 0; k < N; ++k) {
			double dx = x[k] - xc;
			double dy = y[k] - yc;
			if (dx * dx + dy * dy > R * R + 1e-9)
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			int N = Integer.parseInt(in.readLine());
			if (N == 0) break;
			
			double[] x = new double[N];
			double[] y = new double[N];
			
			for (int i = 0; i < N; ++i) {
				StringTokenizer stk = new StringTokenizer(in.readLine());
				x[i] = Double.parseDouble(stk.nextToken());
				y[i] = Double.parseDouble(stk.nextToken());
			}
			
			double R = Double.parseDouble(in.readLine());
			
			boolean found = false;
			
			if (N == 1) found = true;
			
			for (int i = 0; i < N && !found; ++i)
				for (int j = i + 1; j < N && !found; ++j) {
					double dx = x[i] - x[j];
					double dy = y[i] - y[j];
					double d = Math.sqrt(dx * dx + dy * dy);
					
					if (R * R < 0.25 * d * d - 1e-9) continue;
					
					double h = Math.sqrt(R * R - 0.25 * d * d);
					
					double xc1 = 0.5 * (x[i] + x[j]) + h / d * (y[i] - y[j]);
					double yc1 = 0.5 * (y[i] + y[j]) + h / d * (x[j] - x[i]);
					
					double xc2 = 0.5 * (x[i] + x[j]) - h / d * (y[i] - y[j]);
					double yc2 = 0.5 * (y[i] + y[j]) - h / d * (x[j] - x[i]);

					if (valid(xc1, yc1, R, x, y) || valid(xc2, yc2, R, x, y))
						found = true;
				}
			System.out.println(found ? "The polygon can be packed in the circle." : "There is no way of packing that polygon.");
		}
		
		in.close();
		System.exit(0);
	}
}
