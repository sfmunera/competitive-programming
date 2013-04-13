package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2750 (11703 - sqrt log sin) */
/* SUBMISSION: 10228942 */
/* SUBMISSION TIME: 2012-06-16 02:19:57 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa11703_sqrtlogsin {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int MAXN = 1000005;
		int[] x = new int[MAXN];
		x[0] = 1;
		for (int i = 1; i < MAXN; ++i) {
			int ind1 = (int)((double)i - Math.sqrt(i));
			int ind2 = (int)(Math.log(i));
			int ind3 = (int)((double)i * Math.sin(i) * Math.sin(i));
			
			x[i] = (x[ind1] + x[ind2] + x[ind3]) % 1000000;
		}
		
		StringBuilder sb = new StringBuilder();
		while (true) {
			int n = Integer.parseInt(in.readLine());
			if (n == -1)
				break;
			
			sb.append(x[n] + "\n");
		}
		System.out.print(sb);
		
		in.close();
		System.exit(0);
	}
}
