package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 3166 (12015 - Google is Feeling Lucky) */
/* SUBMISSION: 09163784 */
/* SUBMISSION TIME: 2011-08-17 22:03:46 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa12015_GoogleisFeelingLucky {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; ++t) {
			String[] web = new String[10];
			int[] rank = new int[10];
			
			int max = 0;
			for (int i = 0; i < 10; ++i) {
				String line = in.readLine();
				StringTokenizer stk = new StringTokenizer(line);
				web[i] = stk.nextToken();
				rank[i] = Integer.parseInt(stk.nextToken());
				max = Math.max(max, rank[i]);
			}
			
			System.out.println("Case #" + t + ":");
			for (int i = 0; i < 10; ++i)
				if (rank[i] == max)
					System.out.println(web[i]);
		}
		
		in.close();
		System.exit(0);
	}
}
