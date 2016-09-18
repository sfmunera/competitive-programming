package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 214 (278 - Chess) */
/* SUBMISSION: 11080258 */
/* SUBMISSION TIME: 2012-12-27 19:48:01 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa00278_Chess {
	
	static int[] rows;
	static int R, C;
	
	static int ways(int col) {
		if (col == C) return 0;
		
		int max = 0;
		boolean moved = false;
		for (int r = 0; r < R; ++r) {
			boolean valid = true;
			for (int c = 0; c < col; ++c)
				if (rows[c] == r || Math.abs(rows[c] - r) == Math.abs(c - col)) {
					valid = false;
					break;
				}
			if (valid) {
				moved = true;
				rows[col] = r;
				max = Math.max(max, ways(col + 1));
			}
		}
		if (!moved) return 0;
		
		return 1 + max;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		while (T-- > 0) {
			StringTokenizer stk = new StringTokenizer(in.readLine());
			char piece = stk.nextToken().charAt(0);
			R = Integer.parseInt(stk.nextToken());
			C = Integer.parseInt(stk.nextToken());
			
			int ans = 0;
			if (piece == 'r')
				ans = Math.min(R, C);
			else if (piece == 'K')
				ans = ((R + 1) / 2) * ((C + 1) / 2);
			else if (piece == 'k') {
				int min = Math.min(R, C);
				int max = Math.max(R, C);
				if (min == 1)
					ans = max;
				else if (min == 2)
					ans = 2 + 4 * (max / 4) + (max % 4 > 0 ? 2 : 0);
				else
					ans = (R * C + 1) / 2;
			} else if (piece == 'Q') {
				rows = new int[R];
				ans = ways(0);
			}
			System.out.println(ans);
		}
		
		in.close();
		System.exit(0);
	}
}
