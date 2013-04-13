package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2823 (11723 - Numbering Roads) */
/* SUBMISSION: 10112434 */
/* SUBMISSION TIME: 2012-05-14 13:47:40 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa11723_NumberingRoads {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int t = 1;
		StringBuilder sb = new StringBuilder();
		while (true) {
			String[] parts = in.readLine().split("[ ]+");
			int R = Integer.parseInt(parts[0]);
			int N = Integer.parseInt(parts[1]);
			
			if (R == 0 &&  N == 0)
				break;
			
			int res = (R - 1) / N;
			sb.append("Case " + t + ": ");
			
			if (res <= 26)
				sb.append(res + "\n");
			else
				sb.append("impossible\n");
			
			++t;
		}
		System.out.print(sb);
		
		in.close();
		System.exit(0);
	}
}
