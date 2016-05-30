package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 3764 (12342 - Tax Calculator) */
/* SUBMISSION: 10217544 */
/* SUBMISSION TIME: 2012-06-12 18:54:14 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa12342_TaxCalculator {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder ans = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; ++t) {
			int income = Integer.parseInt(in.readLine());
			double tax = 0.0;
			
			if (income > 180000) {
				income -= 180000;
				if (income > 0) {
					int diff = Math.min(income, 300000);
					income -= diff;
					tax += 0.10 * diff;
				}
				if (income > 0) {
					int diff = Math.min(income, 400000);
					income -= diff;
					tax += 0.15 * diff;
				}
				if (income > 0) {
					int diff = Math.min(income, 300000);
					income -= diff;
					tax += 0.20 * diff;
				}
				if (income > 0)
					tax += 0.25 * income;
				
				tax = Math.max(2000.0, tax);
			}
			ans.append(String.format("Case %d: %d\n", t, (int)Math.ceil(tax)));
		}
		System.out.print(ans);
		
		in.close();
		System.exit(0);
	}
}
