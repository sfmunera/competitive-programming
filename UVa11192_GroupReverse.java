package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2133 (11192 - Group Reverse) */
/* SUBMISSION: 09246671 */
/* SUBMISSION TIME: 2011-09-10 19:33:53 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa11192_GroupReverse {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			String line = in.readLine();
			if (line.equals("0"))
				break;
			StringTokenizer stk = new StringTokenizer(line);
			int G = Integer.parseInt(stk.nextToken());
			char[] s = stk.nextToken().toCharArray();
			int n = s.length;
			
			int len = n / G;
			for (int i = 0; i < n; i += len) {
				int ini = i;
				int end = i + len - 1;
				for (int j = ini; j < (ini + end + 1) / 2; ++j) {
					char t = s[j];
					s[j] = s[end - j + ini];
					s[end - j + ini] = t;
				}
			}
			System.out.println(s);
		}
		
		in.close();
		System.exit(0);
	}
}