package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 575 (634 - Polygon) */
/* SUBMISSION: 09307462 */
/* SUBMISSION TIME: 2011-09-28 03:05:59 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;
import java.awt.*;

public class UVa00634_Polygon {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			int N = Integer.parseInt(in.readLine());
			if (N == 0)
				break;
			
			int[] x = new int[N];
			int[] y = new int[N];
			
			StringTokenizer stk;
			for (int i = 0; i < N; ++i) {
				stk = new StringTokenizer(in.readLine());
				x[i] = Integer.parseInt(stk.nextToken());
				y[i] = Integer.parseInt(stk.nextToken());
			}
			Polygon p = new Polygon(x, y, N);
			stk = new StringTokenizer(in.readLine());
			Point q = new Point(Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken()));
			if (p.contains(q))
				System.out.println("T");
			else
				System.out.println("F");
		}
		
		in.close();
		System.exit(0);
	}
}