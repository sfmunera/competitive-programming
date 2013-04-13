package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1154 (10213 - How Many Pieces of Land ?) */
/* SUBMISSION: 10796898 */
/* SUBMISSION TIME: 2012-10-26 01:24:10 */
/* LANGUAGE: 2 */

import java.io.*;
import java.math.*;

public class UVa10213_HowManyPiecesofLand {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		while (T-- > 0) {
			int N = Integer.parseInt(in.readLine());
			
			BigInteger one = BigInteger.ONE;
			BigInteger two = BigInteger.valueOf(2L);
			BigInteger twoFour = BigInteger.valueOf(24L);
			BigInteger bigN = BigInteger.valueOf(N);
			BigInteger bigN1 = bigN.subtract(one);
			BigInteger bigN2 = bigN1.subtract(one);
			BigInteger bigN3 = bigN2.subtract(one);
			
			// 1 + C(N, 2) + C(N, 4)
			BigInteger ans = one.add(bigN.multiply(bigN1).divide(two)).add(bigN.multiply(bigN1).multiply(bigN2).multiply(bigN3).divide(twoFour));
			System.out.println(ans);
		}
	}
}
