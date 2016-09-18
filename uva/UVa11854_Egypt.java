package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2954 (11854 - Egypt) */
/* SUBMISSION: 09302300 */
/* SUBMISSION TIME: 2011-09-26 18:27:08 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa11854_Egypt {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			StringTokenizer stk = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(stk.nextToken());
			int b = Integer.parseInt(stk.nextToken());
			int c = Integer.parseInt(stk.nextToken());
			
			if (a == 0 && b == 0 && c == 0)
				break;
			
			boolean isRight = a * a + b * b == c * c || a * a + c * c == b * b || b * b + c * c == a * a;
			System.out.println(isRight ? "right" : "wrong");
		}
		
		in.close();
		System.exit(0);
	}
}