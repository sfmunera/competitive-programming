package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 654 (713 - Adding Reversed Numbers) */
/* SUBMISSION: 09120588 */
/* SUBMISSION TIME: 2011-08-06 14:45:41 */
/* LANGUAGE: 2 */

import java.io.*;
import java.math.*;

public class UVa00713_AddingReversedNumbers {
		
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		while (T-- > 0) {
			String[] parts = in.readLine().split("[ ]");
			BigInteger n1 = new BigInteger(new StringBuffer(parts[0]).reverse().toString());
			BigInteger n2 = new BigInteger(new StringBuffer(parts[1]).reverse().toString());
			
			String res = new StringBuffer(n1.add(n2).toString()).reverse().toString();
			while (res.length() > 1 && res.charAt(0) == '0')
				res = res.substring(1);
			System.out.println(res);
		}
		
		in.close();
		System.exit(0);
	}
}