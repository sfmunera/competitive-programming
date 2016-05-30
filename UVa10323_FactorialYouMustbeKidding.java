package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1264 (10323 - Factorial! You Must be Kidding!!!) */
/* SUBMISSION: 08932521 */
/* SUBMISSION TIME: 2011-06-09 15:32:11 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa10323_FactorialYouMustbeKidding {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		while (in.hasNextInt()) {
			int n = in.nextInt();
			long fact = 1;
			
			if (n >= 8 && n <= 13) {
				for (int i = 2; i <= n; ++i)
					fact *= i;
				System.out.println(fact);
			} else if (n > 13 || (n < 0 && (-n) % 2 == 1))
				System.out.println("Overflow!");
			else if ((n >= 0 && n < 8) || (n < 0 && (-n) % 2 == 0))
				System.out.println("Underflow!");				
		}
	}
}