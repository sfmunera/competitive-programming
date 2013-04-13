package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2484 (11489 - Integer Game) */
/* SUBMISSION: 09142494 */
/* SUBMISSION TIME: 2011-08-12 17:50:30 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa11489_IntegerGame {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; ++t) {
			String number = in.readLine();
			
			int sum = 0;
			int[] freq = new int[10];
			for (char c : number.toCharArray()) {
				int d = c - '0';
				sum += d;
				++freq[d];
			}
			
			int nMoves = freq[3] + freq[6] + freq[9];
			boolean canWin = true;
			if (sum % 3 == 0) {
				if (nMoves % 2 == 0)
					canWin = false;
			} else if (sum % 3 == 1) {
				if (freq[1] > 0 || freq[4] > 0 || freq[7] > 0) {
					if (nMoves % 2 == 1)
						canWin = false;
				} else
					canWin = false;
			} else {
				if (freq[2] > 0 || freq[5] > 0 || freq[8] > 0) {
					if (nMoves % 2 == 1)
						canWin = false;
				} else
					canWin = false;
			}
			
			System.out.println("Case " + t + ": " + (canWin || number.length() == 1 ? "S" : "T"));
		}
		
		in.close();
		System.exit(0);
	}
}