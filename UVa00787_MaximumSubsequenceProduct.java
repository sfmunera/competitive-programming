package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 728 (787 - Maximum Sub-sequence Product) */
/* SUBMISSION: 10168693 */
/* SUBMISSION TIME: 2012-05-29 18:11:23 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;
import java.math.*;

public class UVa00787_MaximumSubsequenceProduct {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String line;
		while ((line = in.readLine()) != null) {
			String[] parts = line.split("[ ]+");
			int N = parts.length - 1;
			
			BigInteger[] prod = new BigInteger[N];
			Arrays.fill(prod, BigInteger.ZERO);
			
			prod[0] = new BigInteger(parts[0]);
			for (int i = 1; i < N; ++i) {
				if (!prod[i - 1].equals(BigInteger.ZERO))
					prod[i] = prod[i - 1].multiply(new BigInteger(parts[i]));
				else
					prod[i] = new BigInteger(parts[i]);
			}
			//System.out.println(Arrays.toString(prod));
			
			BigInteger max = BigInteger.valueOf(-999999);
			for (int i = 0; i < N; ++i) {
				max = max.max(prod[i]);
				for (int j = i - 1; j >= 0 && !prod[j].equals(BigInteger.ZERO); --j) {
					max = max.max(prod[i].divide(prod[j]));
				}
			}
			System.out.println(max);
		}
		
		in.close();
		System.exit(0);
	}
}
