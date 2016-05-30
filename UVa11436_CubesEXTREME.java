package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2431 (11436 - Cubes - EXTREME!!!) */
/* SUBMISSION: 10246195 */
/* SUBMISSION TIME: 2012-06-21 18:45:46 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa11436_CubesEXTREME {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while (true) {
			long N = Long.parseLong(in.readLine());
			if (N == 0)
				break;
			
			long bestx = Long.MAX_VALUE;
			long besty = Long.MAX_VALUE;
			
			for (long k = 1; k <= N / k && k * k * k <= 4 * N; ++k) {
				if (N % k == 0) {
					long D = -3 * k * k + 12 * N / k;
					long y = Math.round(Math.sqrt((double)D));
					
					if (y * y != D)
						continue;
					y -= 3 * k;
					if (y % 6 != 0)
						continue;
					y /= 6;
					
					if (y < besty && y > 0) {
						besty = y;
						bestx = k + y;
					}
				}
			}
			
			if (besty == Long.MAX_VALUE)
				sb.append("No solution\n");
			else
				sb.append(bestx + " " + besty + "\n");
		}
		System.out.print(sb);
		
		in.close();
		System.exit(0);
	}
}
