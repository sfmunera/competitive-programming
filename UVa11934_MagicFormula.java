package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 3085 (11934 - Magic Formula) */
/* SUBMISSION: 09168614 */
/* SUBMISSION TIME: 2011-08-19 02:51:49 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa11934_MagicFormula {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			String line = in.readLine();
			StringTokenizer stk = new StringTokenizer(line);
			int a = Integer.parseInt(stk.nextToken());
			int b = Integer.parseInt(stk.nextToken());
			int c = Integer.parseInt(stk.nextToken());
			int d = Integer.parseInt(stk.nextToken());
			int L = Integer.parseInt(stk.nextToken());
			
			if (a == 0 && b == 0 && c == 0 && d == 0 && L == 0)
				break;
			
			int cnt = 0;
			for (int x = 0; x <= L; ++x) {
				int f = a * x * x + b * x + c;
				if (f % d == 0)
					++cnt;
			}
			System.out.println(cnt);
		}
		
		in.close();
		System.exit(0);
	}
}