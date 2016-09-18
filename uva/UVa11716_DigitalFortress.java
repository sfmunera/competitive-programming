package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2763 (11716 - Digital Fortress) */
/* SUBMISSION: 08955170 */
/* SUBMISSION TIME: 2011-06-15 22:26:20 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa11716_DigitalFortress {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int T = Integer.parseInt(in.nextLine());
		while (T-- > 0) {
			String code = in.nextLine();
			int n = code.length();
			int sqrt = (int)Math.round(Math.sqrt(n));
			
			if (sqrt * sqrt != n)
				System.out.println("INVALID");
			else {
				char[][] decode = new char[sqrt][sqrt];
				int k = 0;
				for (int i = 0; i < sqrt; ++i)
					for (int j = 0; j < sqrt; ++j)
						decode[i][j] = code.charAt(k++);
				char[] res = new char[n];
				k = 0;
				for (int j = 0; j < sqrt; ++j)
					for (int i = 0; i < sqrt; ++i)
						res[k++] = decode[i][j];
				System.out.println(String.valueOf(res));
			}
		}
	}
}