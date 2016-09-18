package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2734 (11687 - Digits) */
/* SUBMISSION: 09232958 */
/* SUBMISSION TIME: 2011-09-07 02:01:42 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa11687_Digits {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String x;
		while (!(x = in.readLine()).equals("END")) {
			int i = 1;
			
			while (true) {
				String xi = String.valueOf(x.length());
				if (xi.equals(x)) {
					System.out.println(i);
					break;
				}
				x = xi;
				++i;
			}
		}
		
		in.close();
		System.exit(0);
	}
}