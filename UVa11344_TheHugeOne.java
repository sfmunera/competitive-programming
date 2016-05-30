package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2319 (11344 - The Huge One) */
/* SUBMISSION: 09174625 */
/* SUBMISSION TIME: 2011-08-20 19:36:27 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa11344_TheHugeOne {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		StringBuilder res = new StringBuilder();
		while (T-- > 0) {
			String M = in.readLine();
			int n = M.length();
			String[] parts = in.readLine().split("[ ]");
			int[] set = new int[parts.length - 1];
			
			for (int i = 1; i < parts.length; ++i)
				set[i - 1] = Integer.parseInt(parts[i]);
			
			boolean[] isMultipleOf = new boolean[13];
			
			int sum = 0;
			for (char c : M.toCharArray())
				sum += c - '0';
			int lastDigit = M.charAt(n - 1) - '0';
			
			isMultipleOf[1] = true;
			isMultipleOf[2] = lastDigit % 2 == 0;
			isMultipleOf[3] = sum % 3 == 0;
			if (n > 1)
				isMultipleOf[4] = Integer.parseInt(M.substring(n - 2, n)) % 4 == 0;
			else
				isMultipleOf[4] = lastDigit % 4 == 0;
			isMultipleOf[5] = lastDigit == 0 || lastDigit == 5;
			isMultipleOf[6] = isMultipleOf[2] && isMultipleOf[3];
			int altSum = 0;
			int[] pattern = {1, 3, 2, -1, -3, -2};
			int j = 0;
			for (int i = n - 1; i >= 0; --i) {
				altSum += pattern[j] * (M.charAt(i) - '0');
				j = (j + 1) % 6;
			}
			isMultipleOf[7] = Math.abs(altSum) % 7 == 0;
			if (n > 2)
				isMultipleOf[8] = Integer.parseInt(M.substring(n - 3, n)) % 8 == 0;
			else
				isMultipleOf[8] = Integer.parseInt(M) % 8 == 0;
			isMultipleOf[9] = sum % 9 == 0;
			isMultipleOf[10] = lastDigit == 0;
			altSum = 0;
			int s = 1;
			for (int i = n - 1; i >= 0; --i) {
				altSum += s * (M.charAt(i) - '0');
				s = -s;
			}
			isMultipleOf[11] = Math.abs(altSum) % 11 == 0;
			isMultipleOf[12] = isMultipleOf[3] && isMultipleOf[4];
			
			boolean ok = true;
			for (int i = 0; i < set.length && ok; ++i)
				ok &= isMultipleOf[set[i]];
			
			res.append(M + " - " + (ok ? "Wonderful" : "Simple") + ".\n");
		}
		System.out.print(res);
		
		in.close();
		System.exit(0);
	}
}