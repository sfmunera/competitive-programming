package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2056 (11115 - Uncle Jack) */
/* SUBMISSION: 08731277 */
/* SUBMISSION TIME: 2011-04-10 02:06:40 */
/* LANGUAGE: 2 */

import java.util.*;
import java.math.*;

public class UVa11115_UncleJack {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
			
		while (true) {
			int N = in.nextInt();
			int D = in.nextInt();
			if (N == 0 && D == 0) break;
			BigInteger res = BigInteger.valueOf(N).pow(D);
			
			System.out.println(res);
		}
	}
}