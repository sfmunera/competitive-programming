package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 192 (256 - Quirksome Squares) */
/* SUBMISSION: 09208977 */
/* SUBMISSION TIME: 2011-08-31 13:57:55 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa00256_QuirksomeSquares {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String line;
		while ((line = in.readLine()) != null) {
			int d = Integer.parseInt(line);
			int mod = (int)Math.round(Math.pow(10, d / 2));
			
			List<Integer> quirk = new ArrayList<Integer>();
			for (int q = 0; q < mod * mod; ++q) {
				int first = q / mod;
				int second = q % mod;
				if ((first + second) * (first + second) == q) {
					quirk.add(q);
				}
			}
			for (int q : quirk)
				System.out.printf("%0" + d + "d%n", q);
		}
		
		in.close();
		System.exit(0);
	}
}