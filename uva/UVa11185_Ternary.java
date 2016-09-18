package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2126 (11185 - Ternary) */
/* SUBMISSION: 09141817 */
/* SUBMISSION TIME: 2011-08-12 14:11:15 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa11185_Ternary {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			long N = Integer.parseInt(in.readLine());
			if (N < 0)
				break;
			
			String ternary = "";
			
			if (N == 0)
				ternary = "0";
			while (N > 0) {
				ternary = N % 3 + ternary;
				N /= 3;
			}
			System.out.println(ternary);
		}
		
		in.close();
		System.exit(0);
	}
}