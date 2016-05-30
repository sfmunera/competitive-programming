package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2474 (11479 - Is this the easiest problem?) */
/* SUBMISSION: 09246657 */
/* SUBMISSION TIME: 2011-09-10 19:23:18 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa11479_Isthistheeasiestproblem {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		
		for (int t = 1; t <= T; ++t) {
			String line = in.readLine();
			StringTokenizer stk = new StringTokenizer(line);
			long[] side = new long[3];
			side[0] = Long.parseLong(stk.nextToken());
			side[1] = Long.parseLong(stk.nextToken());
			side[2] = Long.parseLong(stk.nextToken());
			
			Arrays.sort(side);
			
			String res = "";
			if (side[0] + side[1] <= side[2])
				res = "Invalid";
			else if (side[0] == side[1] && side[0] == side[2])
				res = "Equilateral";
			else if (side[0] == side[1] || side[0] == side[2] || side[1] == side[2])
				res = "Isosceles";
			else if (side[0] != side[1] && side[0] != side[2] && side[1] != side[2])
				res = "Scalene";
			
			System.out.println("Case " + t + ": " + res);
		}
		
		in.close();
		System.exit(0);
	}
}
