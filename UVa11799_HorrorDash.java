package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2899 (11799 - Horror Dash) */
/* SUBMISSION: 09246066 */
/* SUBMISSION TIME: 2011-09-10 15:49:20 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa11799_HorrorDash {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; ++t) {
			String line = in.readLine();
			StringTokenizer stk = new StringTokenizer(line);
			
			int max = 0;
			while (stk.hasMoreTokens())
				max = Math.max(max, Integer.parseInt(stk.nextToken()));
			
			System.out.println("Case " + t + ": " + max);
		}
		
		in.close();
		System.exit(0);
	}
}