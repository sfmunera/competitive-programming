package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 668 (727 - Equation) */
/* SUBMISSION: 10081901 */
/* SUBMISSION TIME: 2012-05-06 15:33:23 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa00727_Equation {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		in.readLine();
		
		boolean first = true;
		while (T-- > 0) {
			Stack<Character> S = new Stack<Character>();
			String exp = "";
			String line;
			while ((line = in.readLine()) != null && !line.isEmpty()) {
				exp += line;
			}
			char[] expc = exp.toCharArray();
			String res = "";
			
			for (char c : expc) {
				if (Character.isDigit(c)) {
					res += c;
				} else if (c == '*' || c == '/' || c == '+' || c == '-') {
					while (!S.isEmpty()) {
						char op = S.peek();
						if ((c == '+' || c == '-') && (op == '+' || op == '-')) {
							res += S.pop();
						} else if (op == '*' || op == '/') {
							res += S.pop();
						} else
							break;
					}
					S.push(c);
				} else if (c == '(') {
					S.push(c);
				} else if (c == ')') {
					while (!S.isEmpty()) {
						char op = S.pop();
						if (op == '(')
							break;
						res += op;
					}
				}
				
			}
			while (!S.isEmpty())
				res += S.pop();
			
			if (first)
				first = false;
			else
				System.out.println();
			System.out.println(res);
		}
		
		in.close();
		System.exit(0);
	}
}
