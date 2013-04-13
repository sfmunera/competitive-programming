package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1610 (10669 - Three powers) */
/* SUBMISSION: 09951990 */
/* SUBMISSION TIME: 2012-04-03 22:56:01 */
/* LANGUAGE: 2 */

import java.io.*;
import java.math.*;

public class UVa10669_Threepowers {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		BigInteger[] powers = new BigInteger[65];
		powers[0] = BigInteger.valueOf(1L);
		
		for (int i = 1; i < powers.length; ++i)
			powers[i] = powers[i - 1].multiply(BigInteger.valueOf(3L));
		//System.out.println(Arrays.toString(powers));
		while (true) {
			long n = Long.parseLong(in.readLine());
			if (n == 0)
				break;
			
			boolean first = true;
			System.out.print("{");
			for (int i = 0; i < Math.ceil(Math.log(n) / Math.log(2)); ++i)
				if (((n - 1) & (1L << i)) != 0) {
					if (first)
						first = false;
					else
						System.out.print(",");
					System.out.print(" " + powers[i]);
				}
			System.out.println(" }");
		}
		
		in.close();
		System.exit(0);
	}
}
