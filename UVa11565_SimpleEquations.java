package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2612 (11565 - Simple Equations) */
/* SUBMISSION: 09196255 */
/* SUBMISSION TIME: 2011-08-27 17:09:09 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa11565_SimpleEquations {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		while (T-- > 0) {
			String line = in.readLine();
			StringTokenizer stk = new StringTokenizer(line);
			int A = Integer.parseInt(stk.nextToken());
			int B = Integer.parseInt(stk.nextToken());
			int C = Integer.parseInt(stk.nextToken());
			
			int sx = 1000000;
			int sy = 1000000;
			int sz = 1000000;
			for (int x = -100; x <= 100; ++x)
				for (int y = -100; y <= 100; ++y) {
					int z = A - x - y;
					if (x == y || x == z || y == z)
						continue;
					if (x * y * z == B && x * x + y * y + z * z == C)
						if (x < sx) {
							sx = x;
							sy = y;
							sz = z;
						} else if (x == sx && y < sy) {
							sx = x;
							sy = y;
							sz = z;
						}
				}
			if (sx == 1000000)
				System.out.println("No solution.");
			else
				System.out.println(sx + " " + sy + " " + sz);
		}
		
		in.close();
		System.exit(0);
	}
}