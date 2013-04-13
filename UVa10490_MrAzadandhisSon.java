package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1431 (10490 - Mr. Azad and his Son!!!!!) */
/* SUBMISSION: 10249388 */
/* SUBMISSION TIME: 2012-06-22 20:09:26 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa10490_MrAzadandhisSon {
	
	static boolean isPrime(int n) {
		if (n < 2) return false;
		if (n == 2) return true;
		if (n % 2 == 0) return false;
		
		for (int i = 3; i * i <= n; i += 2)
			if (n % i == 0)
				return false;
		return true;
	}
	
	static boolean isPerfect(long n) {
		/*long sum = 1;
		for (int p = 2; p <= n / p; ++p)
			if (n % p == 0) {
				sum += p;
				if (p != n / p)
					sum += n / p;
			}
		
		return sum == n;*/
		return n == 2 || n == 3 || n == 5 || n == 7 || n == 13 || n == 17 || n == 19 || n == 31;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			int n = Integer.parseInt(in.readLine());
			if (n == 0)
				break;
			
			boolean isPrime = isPrime(n);
			long p = (1L << (n - 1)) * ((1L << n) - 1);
			boolean hasPerfect = isPerfect(n);
			
			if (hasPerfect)
				System.out.println("Perfect: " + p + "!");
			else {
				if (isPrime)
					System.out.println("Given number is prime. But, NO perfect number is available.");
				else
					System.out.println("Given number is NOT prime! NO perfect number is available.");
			}
		}
		
		in.close();
		System.exit(0);
	}
}