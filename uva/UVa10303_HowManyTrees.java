package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1244 (10303 - How Many Trees?) */
/* SUBMISSION: 10805439 */
/* SUBMISSION TIME: 2012-10-27 20:26:29 */
/* LANGUAGE: 2 */

import java.io.*;
import java.math.*;

public class UVa10303_HowManyTrees {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		BigInteger ONE = BigInteger.ONE;
		BigInteger TWO = BigInteger.valueOf(2L);
		
		int MAXN = 1005;
		BigInteger[] C = new BigInteger[MAXN];
		
		C[0] = ONE;
		
		for (int i = 0; i < MAXN - 1; ++i)
			C[i + 1] = C[i].multiply(TWO).multiply(TWO.multiply(BigInteger.valueOf(i)).add(ONE)).divide(BigInteger.valueOf(i).add(TWO));

		String line;
		while ((line = in.readLine()) != null) {
			int N = Integer.parseInt(line);
			System.out.println(C[N]);
		}
		
		in.close();
		System.exit(0);
	}
}
