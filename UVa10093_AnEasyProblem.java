package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1034 (10093 - An Easy Problem!) */
/* SUBMISSION: 10418747 */
/* SUBMISSION TIME: 2012-08-01 13:47:11 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa10093_AnEasyProblem {
	public static void main(String[] args) throws IOException {
		String system = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String number;
		while ((number = in.readLine()) != null) {
			number = number.trim();
			if (number.charAt(0) == '+' || number.charAt(0) == '-')
				number = number.substring(1);
			int minbase = 0;
			for (int i = 0; i < number.length(); ++i)
				minbase = Math.max(minbase, system.indexOf(number.charAt(i)) + 1);
			
			boolean found = false;
			if (minbase >= 2)
				for (int b = minbase; b <= 62 && !found; ++b) {
					int num = 0;
					int pow = 1;
					for (int i = number.length() - 1; i >= 0; --i) {
						num = (num + ((pow % (b - 1)) * system.indexOf(number.charAt(i))) % (b - 1)) % (b - 1);
						pow = (pow % (b - 1) * b % (b - 1)) % (b - 1);
					}
					
					if (num % (b - 1) == 0) {
						System.out.println(b);
						found = true;
					}
				}
			else {
				System.out.println("2");
				found = true;
			}
				
			if (!found)
				System.out.println("such number is impossible!");
		}
		
		in.close();
		System.exit(0);
	}
}
