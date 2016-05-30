package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 3671 (1230 - MODEX) */
/* SUBMISSION: 10414605 */
/* SUBMISSION TIME: 2012-07-31 14:51:50 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa01230_MODEX {
	
	static long fastPow(long B, long P, long M) {
		if (P == 0) return 1;
		if (P == 1) return B % M;
		if (P % 2 == 0) return fastPow(((B % M) * (B % M)) % M, P / 2, M);
		else return ((B % M) * fastPow(((B % M) * (B % M)) % M, (P - 1) / 2, M) % M) % M;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		while (T-- > 0) {
			String[] parts = in.readLine().split("[ ]+");
			long x = Long.parseLong(parts[0]);
			long y = Long.parseLong(parts[1]);
			long n = Long.parseLong(parts[2]);
			
			System.out.println(fastPow(x, y, n));
		}
		in.readLine();
		
		in.close();
		System.exit(0);
	}
}
