package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 960 (10019 - Funny Encryption Method) */
/* SUBMISSION: 09228231 */
/* SUBMISSION TIME: 2011-09-06 01:31:23 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa10019_FunnyEncryptionMethod {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		while (T-- > 0) {
			int N = Integer.parseInt(in.readLine());
			int b1 = Integer.bitCount(N);
			N = Integer.parseInt(String.valueOf(N), 16);
			int b2 = Integer.bitCount(N);
			System.out.println(b1 + " " + b2);
		}
		
		in.close();
		System.exit(0);
	}
}
