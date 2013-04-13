package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2614 (11567 - Moliu Number Generator) */
/* SUBMISSION: 10534744 */
/* SUBMISSION TIME: 2012-08-28 17:18:27 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa11567_MoliuNumberGenerator {

	static int solve(long S) {
		if (S == 0)
			return 0;
		if (S == 1)
			return 1;
		if (S % 2 == 0)
			return 1 + solve(S / 2);
		else
			return 1 + Math.min(solve(S - 1), solve(S + 1));
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String line;
		while ((line = in.readLine()) != null) {
			long T = Long.parseLong(line);
			
			System.out.println(solve(T));
		}
		
		in.close();
		System.exit(0);
	}
}
