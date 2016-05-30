package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1131 (10190 - Divide, But Not Quite Conquer!) */
/* SUBMISSION: 09299418 */
/* SUBMISSION TIME: 2011-09-25 23:01:54 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa10190_DivideButNotQuiteConquer {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String line;
		StringTokenizer stk;
		while ((line = in.readLine()) != null) {
			stk = new StringTokenizer(line.trim());
			long n = Long.parseLong(stk.nextToken());
			long m = Long.parseLong(stk.nextToken());
			
			StringBuilder sb = new StringBuilder();
			boolean boring = n < 2 || m < 2;
			
			sb.append(n);
			while (n > 1 && !boring) {
				if (n % m != 0)
					boring = true;
				n /= m;
				sb.append(" " + n);
 			}
			if (boring)
				System.out.println("Boring!");
			else
				System.out.println(sb);
		}
		
		in.close();
		System.exit(0);
	}
}
