package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 509 (568 - Just the Facts) */
/* SUBMISSION: 08894496 */
/* SUBMISSION TIME: 2011-05-27 21:36:06 */
/* LANGUAGE: 2 */

import java.util.*;
import java.math.*;

public class UVa00568_JusttheFacts {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[] facts = new int[10001];
		
		facts[0] = facts[1] = 1;
		int fact = 1;
		for (int i = 2; i <= 10000; ++i) {
			fact *= i;
			while (fact % 10 == 0)
				fact /= 10;
			fact = fact % 100000;
			facts[i] = fact % 10;;
		}
		
		while (in.hasNextInt()) {
			int n = in.nextInt();

			System.out.printf("%5d -> %d%n", n, facts[n]);
			
		}
	}
}
