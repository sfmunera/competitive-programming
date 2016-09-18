package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 3667 (1226 - Numerical surprises) */
/* SUBMISSION: 09951886 */
/* SUBMISSION TIME: 2012-04-03 22:04:33 */
/* LANGUAGE: 2 */

import java.io.*;
import java.math.*;

public class UVa01226_Numericalsurprises {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		while (T-- > 0) {
			BigInteger N = new BigInteger(in.readLine());
			BigInteger P = new BigInteger(in.readLine());
			
			System.out.println(P.mod(N));
		}
		
		in.close();
		System.exit(0);
	}
}
