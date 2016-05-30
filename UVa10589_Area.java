package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1530 (10589 - Area) */
/* SUBMISSION: 09299852 */
/* SUBMISSION TIME: 2011-09-26 03:30:34 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa10589_Area {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer stk;
		while (true) {
			stk = new StringTokenizer(in.readLine());
			int N = Integer.parseInt(stk.nextToken());
			
			if (N == 0)
				break;
			
			int a = Integer.parseInt(stk.nextToken());
			int M = 0;
			for (int i = 0; i < N; ++i) {
				stk = new StringTokenizer(in.readLine());
				double x = Double.parseDouble(stk.nextToken());
				double y = Double.parseDouble(stk.nextToken());
				
				if (Double.compare(Math.sqrt(x * x + y * y), a) <= 0 &&
					Double.compare(Math.sqrt((x - a) * (x - a) + y * y), a) <= 0 &&
					Double.compare(Math.sqrt(x * x + (y - a) * (y - a)), a) <= 0 &&
					Double.compare(Math.sqrt((x - a) * (x - a) + (y - a) * (y - a)), a) <= 0)
					++M;
			}
			
			double A = (double)M * a * a / N;
			System.out.printf(Locale.ENGLISH, "%.5f%n", A);
		}
		
		in.close();
		System.exit(0);
	}
}