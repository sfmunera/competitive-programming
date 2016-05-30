package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 376 (435 - Block Voting) */
/* SUBMISSION: 09622763 */
/* SUBMISSION TIME: 2012-01-06 14:16:37 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa00435_BlockVoting {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		while (T-- > 0) {
			String[] parts = in.readLine().split("[ ]+");
			int P = Integer.parseInt(parts[0]);
			
			int[] parties = new int[P];
			int sum = 0;
			for (int i = 1; i <= P; ++i) {
				parties[i - 1] = Integer.parseInt(parts[i]);
				sum += parties[i - 1];
			}
			
			int[] powers = new int[P];
			
			for (int s = 0; s < (1 << P); ++s) {
				int S = 0;
				for (int i = 0; i < P; ++i)
					if ((s & (1 << i)) != 0)
						S += parties[i];
				
				for (int i = 0; i < P; ++i)
					if ((s & (1 << i)) != 0)
						if (S > sum / 2 && S - parties[i] <= sum / 2)
							++powers[i];
				
			}
			for (int i = 0; i < P; ++i)
				System.out.println("party " + (i + 1) + " has power index " + powers[i]);
			System.out.println();
		}
		
		in.close();
		System.exit(0);
	}
}