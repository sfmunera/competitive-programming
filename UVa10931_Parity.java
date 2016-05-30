package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1872 (10931 - Parity) */
/* SUBMISSION: 09170956 */
/* SUBMISSION TIME: 2011-08-19 16:26:19 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa10931_Parity {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			int N = Integer.parseInt(in.readLine());
			
			if (N == 0)
				break;
			
			int P = Integer.bitCount(N);
			
			System.out.println("The parity of " + Integer.toBinaryString(N) + " is " + P + " (mod 2).");
		}
		
		in.close();
		System.exit(0);
	}
}