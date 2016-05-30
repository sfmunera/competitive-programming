package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 3961 (12516 - Cinema-cola) */
/* SUBMISSION: 11466807 */
/* SUBMISSION TIME: 2013-03-19 00:21:12 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa12516_Cinemacola {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		while (true) {
			stk = new StringTokenizer(in.readLine());
			int R = Integer.parseInt(stk.nextToken());
			int C = Integer.parseInt(stk.nextToken());
			
			if (R == 0 && C == 0) break;
			
			boolean[][] left = new boolean[R][C];
			boolean[][] right = new boolean[R][C];
			boolean[][] change = new boolean[R][C];
			
			int P = Integer.parseInt(in.readLine());
			for (int i = 0; i < P; ++i) {
				stk = new StringTokenizer(in.readLine());
				String seat = stk.nextToken();
				int r = seat.charAt(0) - 'A';
				int c = Integer.parseInt(seat.substring(1)) - 1;
				
				char side = stk.nextToken().charAt(0);
				
				if (side == '-') {
					left[r][c] = true;
					if (c > 0) right[r][c - 1] = true;
				} else {
					right[r][c] = true;
					if (c < C - 1) left[r][c + 1] = true;
				}
			}
			
			int Z = Integer.parseInt(in.readLine());
			for (int i = 0; i < Z; ++i) {
				
				stk = new StringTokenizer(in.readLine());
				String seat = stk.nextToken();
				int r = seat.charAt(0) - 'A';
				int c = Integer.parseInt(seat.substring(1)) - 1;
				
				change[r][c] = true;
			}
			
			boolean ok = true;
			for (int r = 0; r < R; ++r)
				for (int c = 0; c < C; ++c)
					if (change[r][c]) {
						if (!left[r][c]) {
							left[r][c] = true;
							if (c > 0) right[r][c - 1] = true;
						} else if (!right[r][c]) {
							right[r][c] = true;
							if (c < C - 1) left[r][c + 1] = true;
						} else ok = false;
					}
			
			System.out.println(ok ? "YES" : "NO");
		}
		
		in.close();
		System.exit(0);
	}
}
