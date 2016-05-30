package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1870 (10929 - You can say 11) */
/* SUBMISSION: 09171329 */
/* SUBMISSION TIME: 2011-08-19 18:27:54 */
/* LANGUAGE: 2 */

import java.io.*;
import java.math.*;

public class UVa10929_Youcansay11 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			String line = in.readLine();
			if (line.equals("0"))
				break;
			BigInteger n = new BigInteger(line);
			boolean ok = n.mod(BigInteger.valueOf(11)).compareTo(BigInteger.ZERO) == 0;
			
			System.out.println(line + " is " + (ok ? "" : "not ") + "a multiple of 11.");
		}
		
		in.close();
		System.exit(0);
	}
}