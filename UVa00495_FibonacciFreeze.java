package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 436 (495 - Fibonacci Freeze) */
/* SUBMISSION: 08932822 */
/* SUBMISSION TIME: 2011-06-09 16:52:07 */
/* LANGUAGE: 2 */

import java.math.*;
import java.io.*;

public class UVa00495_FibonacciFreeze {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		BigInteger[] fib = new BigInteger[5001];
		fib[0] = BigInteger.ZERO;
		fib[1] = BigInteger.ONE;
		
		for (int i = 2; i <= 5000; ++i)
			fib[i] = fib[i - 1].add(fib[i - 2]);
		//System.out.println("Done");
		
		String line;
		while ((line = in.readLine()) != null) {
			int n = Integer.parseInt(line);
			
			System.out.println("The Fibonacci number for " + n + " is " + fib[n]);
		}
	}
}