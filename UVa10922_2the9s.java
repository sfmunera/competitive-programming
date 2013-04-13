package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1863 (10922 - 2 the 9s) */
/* SUBMISSION: 09171315 */
/* SUBMISSION TIME: 2011-08-19 18:17:42 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa10922_2the9s {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			String number = in.readLine();
			if (number.equals("0"))
				break;
			
			int sum = 0;
			for (char c : number.toCharArray())
				sum += c - '0';
			
			int degree = 0;
			if (sum % 9 == 0) {
				degree = 1;
				while (sum > 9 && sum % 9 == 0) {
					int tmp = 0;
					
					while (sum > 0) {
						tmp += sum % 10;
						sum /= 10;
					}
					sum = tmp;
					++degree;
				}
			}
			if (degree > 0)
				System.out.println(number + " is a multiple of 9 and has 9-degree " + degree + ".");
			else
				System.out.println(number + " is not a multiple of 9.");
		}
		
		in.close();
		System.exit(0);
	}
}