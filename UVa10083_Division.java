package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1024 (10083 - Division) */
/* SUBMISSION: 10939855 */
/* SUBMISSION TIME: 2012-11-25 23:03:54 */
/* LANGUAGE: 2 */

import java.math.*;
import java.io.*;

public class UVa10083_Division {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder ans = new StringBuilder();
		
		String line;
		while ((line = in.readLine()) != null) {
			String[] parts = line.split("[ ]+");
			int t = Integer.parseInt(parts[0]);
			int a = Integer.parseInt(parts[1]);
			int b = Integer.parseInt(parts[2]);
			
			ans.append("(" + t + "^" + a + "-1)/(" + t + "^" + b + "-1) ");
			if (t == 1)
				ans.append("is not an integer with less than 100 digits.");
			else if (a == b)
				ans.append("1");
			else if (a < b)
				ans.append("is not an integer with less than 100 digits.");
			else if(Math.floor((a - b) * Math.log10(t)) + 1 >= 100)
				ans.append("is not an integer with less than 100 digits.");
			else if (a % b != 0)
				ans.append("is not an integer with less than 100 digits.");
			else {
				BigInteger tb = BigInteger.valueOf(t);
				BigInteger div = tb.pow(a).subtract(BigInteger.ONE).divide(
						         tb.pow(b).subtract(BigInteger.ONE));
				ans.append(div);
			}
			ans.append("\n");
		}
		System.out.print(ans);
		
		in.close();
		System.exit(0);
	}
}
