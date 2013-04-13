package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1161 (10220 - I Love Big Numbers !) */
/* SUBMISSION: 08932423 */
/* SUBMISSION TIME: 2011-06-09 15:11:49 */
/* LANGUAGE: 2 */

import java.util.*;
import java.math.*;

public class UVa10220_ILoveBigNumbers {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		while (in.hasNext()) {
			int n = in.nextInt();
			BigInteger fact = BigInteger.ONE;
			
			for (int i = 2; i <= n; ++i)
				fact = fact.multiply(BigInteger.valueOf(i));
			char[] sfact = fact.toString().toCharArray();
			
			int sum = 0;
			for (int i = 0; i < sfact.length; ++i)
				sum += sfact[i] - '0';
			System.out.println(sum);
		}
	}
}