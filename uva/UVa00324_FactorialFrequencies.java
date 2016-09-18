package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 260 (324 - Factorial Frequencies) */
/* SUBMISSION: 08927899 */
/* SUBMISSION TIME: 2011-06-07 23:42:32 */
/* LANGUAGE: 2 */

import java.util.*;
import java.math.*;

public class UVa00324_FactorialFrequencies {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		while (true) {
			int n = in.nextInt();
			if (n == 0)
				break;
			
			BigInteger fact = BigInteger.ONE;
			for (int i = 2; i <= n; ++i)
				fact = fact.multiply(BigInteger.valueOf(i));
			
			int[] freq = new int[10];
			String str = fact.toString();
			for (int i = 0; i < str.length(); ++i)
				++freq[str.charAt(i) - '0'];
			
			System.out.println(n + "! --");
			
			for (int i = 0; i < 10; ++i) {
				if (i != 0 && i != 5)
					System.out.printf(" ");
				System.out.printf("   (%d)", i);
				System.out.printf("%5d", freq[i]);
				if (i == 4 || i == 9)
					System.out.println();
			}
		}
	}
}