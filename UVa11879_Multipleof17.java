package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 3001 (11879 - Multiple of 17) */
/* SUBMISSION: 09120826 */
/* SUBMISSION TIME: 2011-08-06 15:54:22 */
/* LANGUAGE: 2 */

import java.io.*;
import java.math.*;

public class UVa11879_Multipleof17 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			String line = in.readLine();
			if (line.equals("0"))
				break;
			
			BigInteger N = new BigInteger(line);

			if (N.mod(BigInteger.valueOf(17)).compareTo(BigInteger.ZERO) == 0)
				System.out.println(1);
			else
				System.out.println(0);
		}
		
		in.close();
		System.exit(0);
	}
}