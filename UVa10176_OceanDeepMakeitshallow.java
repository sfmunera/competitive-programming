package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1117 (10176 - Ocean Deep ! - Make it shallow !!) */
/* SUBMISSION: 11068615 */
/* SUBMISSION TIME: 2012-12-24 15:00:11 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa10176_OceanDeepMakeitshallow {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int MOD = 131071;
		
		String line;
		while ((line = in.readLine()) != null) {
			String bin = line;
			while (!bin.endsWith("#")) {
				bin += in.readLine();
			}
			int mult = 0;
			int pow = 1;
			for (int i = bin.length() - 2; i >= 0; --i) {
				mult = (mult + pow * (bin.charAt(i) - '0')) % MOD;
				pow = (pow * 2) % MOD;
			}
			if (mult % MOD == 0)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
		
		in.close();
		System.exit(0);
	}
}
