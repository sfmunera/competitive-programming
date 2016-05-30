package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 947 (10006 - Carmichael Numbers) */
/* SUBMISSION: 08926937 */
/* SUBMISSION TIME: 2011-06-07 15:36:40 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa10006_CarmichaelNumbers {
	
	static boolean isPrime(int n) {
		if (n == 2)
			return true;
		if (n == 1 || n % 2 == 0)
			return false;
		for (int i = 3; i * i <= n; i += 2)
			if (n % i == 0)
				return false;
		return true;
	}
	
	static boolean isCarmichael(int n) {
		
		if (isPrime(n))
			return false;
		
		for (int a = 2; a < n; ++a) {
			long pow = 1;
			long exp = n;
			long base = a;
			
			// Fast exponentiation
			while (exp > 0) {
				if ((exp & 1) == 1)
					pow = (pow * base) % n;
				exp = exp >> 1;
				base = (base * base) % n;
			}
			if (pow != a)
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		boolean[] carmichael = new boolean[65000];
		for (int i = 3; i < 65000; ++i)
			carmichael[i] = isCarmichael(i);
		
		while (true) {
			int n = in.nextInt();
			if (n == 0)
				break;
			
			if (carmichael[n])
				System.out.println("The number " + n + " is a Carmichael number.");
			else
				System.out.println(n + " is normal.");
		}
	}
}