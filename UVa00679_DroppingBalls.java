package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 620 (679 - Dropping Balls) */
/* SUBMISSION: 09252477 */
/* SUBMISSION TIME: 2011-09-12 18:03:29 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa00679_DroppingBalls {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		while (T-- > 0) {
			String line = in.readLine();
			StringTokenizer stk = new StringTokenizer(line);
			
			int D = Integer.parseInt(stk.nextToken());
			int I = Integer.parseInt(stk.nextToken());
			
			int res = 1;
			while (res < 1 << D) {
				if (I % 2 == 1)
					res = 2 * res;
				else
					res = 2 * res + 1;
				I = (int)Math.ceil((double)I / 2.0);
			}
			System.out.println(res / 2);
		}
		in.readLine();
		
		in.close();
		System.exit(0);
	}
}