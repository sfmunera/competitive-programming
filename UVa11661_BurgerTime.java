package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2708 (11661 - Burger Time?) */
/* SUBMISSION: 09232979 */
/* SUBMISSION TIME: 2011-09-07 02:14:16 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa11661_BurgerTime {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			int L = Integer.parseInt(in.readLine());
			if (L == 0)
				break;
			
			String highway = in.readLine();
			int res = Integer.MAX_VALUE;
			if (!highway.contains("Z")) {
				int indD = -1;
				int indR = -1;
				for (int i = 0; i < highway.length(); ++i) {
					if (highway.charAt(i) == 'D')
						indD = i;
					else if (highway.charAt(i) == 'R')
						indR = i;
					if (indD != -1 && indR != -1)
						res = Math.min(res, Math.abs(indR - indD));
				}
			} else
				res = 0;
			System.out.println(res);
		}
		
		in.close();
		System.exit(0);
	}
}
