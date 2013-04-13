package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2930 (11830 - Contract Revision) */
/* SUBMISSION: 09120792 */
/* SUBMISSION TIME: 2011-08-06 15:45:14 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa11830_ContractRevision {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			String line = in.readLine();
			StringTokenizer stk = new StringTokenizer(line);
			
			char D = stk.nextToken().charAt(0);
			String N = stk.nextToken();
			
			if (D == '0' && N.equals("0"))
				break;
			
			String res = "";
			for (char c : N.toCharArray())
				if (c != D)
					res += c;
			if (res.isEmpty())
				res = "0";
			while (res.length() > 1 && res.charAt(0) == '0')
				res = res.substring(1);
			System.out.println(res);
		}
		
		in.close();
		System.exit(0);
	}
}