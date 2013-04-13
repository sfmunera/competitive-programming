package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2986 (11875 - Brick Game) */
/* SUBMISSION: 09109078 */
/* SUBMISSION TIME: 2011-08-03 01:55:34 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa11875_BrickGame {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; ++t) {
			String line = in.readLine();
			StringTokenizer stk = new StringTokenizer(line);
			
			int N = Integer.parseInt(stk.nextToken());
			int[] players = new int[N];
			
			for (int i = 0; i < N; ++i)
				players[i] = Integer.parseInt(stk.nextToken());
			
			Arrays.sort(players);
			System.out.println("Case " + t + ": " + players[N / 2]);
		}
		
		in.close();
		System.exit(0);
	}
}