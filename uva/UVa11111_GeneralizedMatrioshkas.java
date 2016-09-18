package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2052 (11111 - Generalized Matrioshkas) */
/* SUBMISSION: 11382603 */
/* SUBMISSION TIME: 2013-03-05 03:02:48 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa11111_GeneralizedMatrioshkas {
	
	static boolean isMatrioshka(ArrayList<Long> seq) {
		Stack<Long> S = new Stack<Long>();
		for (long x : seq) {
			if (x < 0)
				S.push(x);
			else {
				int sum = 0;
				while (!S.isEmpty() && S.peek() != -x)
					sum += -S.pop();
				if (S.isEmpty() || sum >= x)
					return false;
			}
		}
		return S.size() == 1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String line;
		while ((line = in.readLine()) != null) {
			ArrayList<Long> seq = new ArrayList<Long>();
			StringTokenizer stk = new StringTokenizer(line);
			
			while (stk.hasMoreTokens())
				seq.add(Long.parseLong(stk.nextToken()));			
			
			if (isMatrioshka(seq)) System.out.println(":-) Matrioshka!");
			else System.out.println(":-( Try again.");
		}
	}
}
