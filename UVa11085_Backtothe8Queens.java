package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2026 (11085 - Back to the 8-Queens) */
/* SUBMISSION: 11038892 */
/* SUBMISSION TIME: 2012-12-17 01:31:01 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa11085_Backtothe8Queens {
	
	static int[] rows;
	
	static boolean valid(int r, int c) {
		for (int i = 0; i < c; ++i) {
			if (rows[i] == r)
				return false;
			if (Math.abs(r - rows[i]) == Math.abs(c - i))
				return false;
		}
		return true;
	}
	
	static int solve(int c) {
		if (c == 8)
			return 0;
		int r = rows[c];
		int min = (int)1e9;
		for (int nr = 0; nr < 8; ++nr) {
			if (valid(nr, c)) {
				rows[c] = nr;
				min = Math.min(min, (nr == r ? 0 : 1) + solve(c + 1));
				rows[c] = r;
			}
		}
		return min;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String line;
		int t = 1;
		while ((line = in.readLine()) != null) {
			String[] parts = line.split("[ ]+");
			rows = new int[8];
			for (int i = 0; i < 8; ++i)
				rows[i] = Integer.parseInt(parts[i]) - 1;
			System.out.println("Case " + t + ": " + solve(0));
			++t;
		}
		
		in.close();
		System.exit(0);
	}
}
