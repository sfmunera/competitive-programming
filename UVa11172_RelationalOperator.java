package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2113 (11172 - Relational Operator) */
/* SUBMISSION: 09163749 */
/* SUBMISSION TIME: 2011-08-17 21:47:20 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa11172_RelationalOperator {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		while (T-- > 0) {
			String line = in.readLine();
			StringTokenizer stk = new StringTokenizer(line);
			int a = Integer.parseInt(stk.nextToken());
			int b = Integer.parseInt(stk.nextToken());
			
			char res = ' ';
			if (a < b)
				res = '<';
			else if (a > b)
				res = '>';
			else
				res = '=';
			System.out.println(res);
		}
		
		in.close();
		System.exit(0);
	}
}