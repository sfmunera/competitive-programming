package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1209 (10268 - 498-bis) */
/* SUBMISSION: 10142116 */
/* SUBMISSION TIME: 2012-05-22 14:36:26 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa10268_498bis {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
				
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = in.readLine()) != null) {
			int x = Integer.parseInt(line);
			String[] cstr = in.readLine().split("[ ]+");
			
			int n = cstr.length - 1;
			int[] c = new int[n + 1];
			
			for (int i = 0; i <= n; ++i)
				c[i] = Integer.parseInt(cstr[i]);
			
			int res = 0;
			int pow = 1;
			for (int j = 0; j < n; ++j) {
				int term = c[n - j - 1] * pow * (j + 1);
				res += term;
				pow *= x;
			}
			sb.append(res + "\n");
		}
		System.out.print(sb);
		
		in.close();
		System.exit(0);
	}
}
