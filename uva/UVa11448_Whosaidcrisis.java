package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2443 (11448 - Who said crisis?) */
/* SUBMISSION: 09120691 */
/* SUBMISSION TIME: 2011-08-06 15:13:00 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;
import java.math.*;

public class UVa11448_Whosaidcrisis {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		while (T-- > 0) {
			String line = in.readLine();
			StringTokenizer stk = new StringTokenizer(line);
			BigInteger A = new BigInteger(stk.nextToken());
			BigInteger B = new BigInteger(stk.nextToken());
			
			System.out.println(A.subtract(B));
		}
		
		in.close();
		System.exit(0);
	}
}