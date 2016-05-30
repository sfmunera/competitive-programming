package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 3097 (11946 - Code Number) */
/* SUBMISSION: 09232949 */
/* SUBMISSION TIME: 2011-09-07 01:54:29 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa11946_CodeNumber {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		char[] map = {'O', 'I', 'Z', 'E', 'A', 'S', 'G', 'T', 'B', 'P'};
		boolean first = true;
		while (T-- > 0) {
			StringBuilder res = new StringBuilder();
			while (true) {
				String line = in.readLine();
				if (line == null)
					break;
				if (line.isEmpty())
					break;
				char[] code = line.toCharArray();
				int n = code.length;
				char[] decode = new char[n];
				for (int i = 0; i < n; ++i)
					if (Character.isDigit(code[i]))
						decode[i] = map[code[i] - '0'];
					else
						decode[i] = code[i];
				res.append(String.valueOf(decode) + "\n");
			}
			if (first)
				first = false;
			else
				System.out.println();
			System.out.print(res);
		}
		
		in.close();
		System.exit(0);
	}
}
