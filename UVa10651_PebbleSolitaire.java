package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1592 (10651 - Pebble Solitaire) */
/* SUBMISSION: 10534250 */
/* SUBMISSION TIME: 2012-08-28 15:28:16 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa10651_PebbleSolitaire {
	
	static int ans;
	
	static boolean isSet(int s, int i) {
		return (s & (1 << i)) != 0;
	}
	
	static void solve(int s) {
		if (s == (1 << 12) - 1) return;
		
		boolean moved = false;
		for (int i = 0; i < 11; ++i) {
			if (isSet(s, i) && isSet(s, i + 1)) {
				if (i > 0 && !isSet(s, i - 1)) {
					int nxt = s;
					nxt ^= (1 << i - 1);
					nxt ^= (1 << i);
					nxt ^= (1 << i + 1);
					moved = true;
					solve(nxt);
				}
				if (i < 10 && !isSet(s, i + 2)) {
					int nxt = s;
					nxt ^= (1 << i);
					nxt ^= (1 << i + 1);
					nxt ^= (1 << i + 2);
					moved = true;
					solve(nxt);
				}
			}
		}
		if (!moved)
			ans = Math.min(ans, Integer.bitCount(s));
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		while (T-- > 0) {
			char[] board = in.readLine().toCharArray();
			int s = 0;
			for (int i = 0; i < 12; ++i)
				if (board[i] == 'o')
					s |= (1 << i);
			ans = 12;
			solve(s);
			
			System.out.println(ans);
		}
		
		in.close();
		System.exit(0);
	}
}
