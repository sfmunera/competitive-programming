package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 3391 (12239 - Bingo!) */
/* SUBMISSION: 09291229 */
/* SUBMISSION TIME: 2011-09-23 02:14:09 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa12239_Bingo {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			String line = in.readLine();
			StringTokenizer stk = new StringTokenizer(line);
			
			int N = Integer.parseInt(stk.nextToken());
			int B = Integer.parseInt(stk.nextToken());
			
			if (N == 0 && B == 0)
				break;
			
			int[] bingo = new int[B];
			boolean[] found = new boolean[N + 1];
			line = in.readLine();
			stk = new StringTokenizer(line);
			
			for (int i = 0; i < B; ++i)
				bingo[i] = Integer.parseInt(stk.nextToken());
			
			found[0] = true;
			boolean ok = true;
			
			for (int i = 0; i < B; ++i)
				for (int j = i + 1; j < B; ++j) {
					int diff = Math.abs(bingo[i] - bingo[j]);
					if (diff <= N)
						found[diff] = true;
				}
			
			for (int i = 0; i <= N; ++i)
				ok &= found[i];
			
			System.out.println(ok ? "Y" : "N");
		}
		
		in.close();
		System.exit(0);
	}
}
