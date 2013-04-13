package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 637 (696 - How Many Knights) */
/* SUBMISSION: 09338918 */
/* SUBMISSION TIME: 2011-10-06 04:13:13 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa00696_HowManyKnights {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		while (true) {
			StringTokenizer stk = new StringTokenizer(in.readLine());
			int M = Integer.parseInt(stk.nextToken());
			int N = Integer.parseInt(stk.nextToken());
			
			if (M == 0 && N == 0)
				break;
			
			int cnt = 0;
			
			if (M == 1 || N == 1)
				cnt = Math.max(M, N);
			else if (M == 2 || N == 2) {
				for (int i = 0; i < Math.max(M, N); ++i)
					if (i % 4 == 0 || (i - 1) % 4 == 0)
						cnt += 2;
			} else {
				cnt = (M * N + 1) / 2;
			}
			sb.append(cnt + " knights may be placed on a " + M + " row " + N + " column board.\n");
		}
		System.out.print(sb);
		
		in.close();
		System.exit(0);
	}
}