package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1597 (10656 - Maximum Sum (II)) */
/* SUBMISSION: 10190200 */
/* SUBMISSION TIME: 2012-06-04 16:52:49 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa10656_MaximumSumII {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		while (true) {
			int N = Integer.parseInt(in.readLine());
			if (N == 0)
				break;
			
			List<Integer> list = new ArrayList<Integer>();
			for (int i = 0; i < N; ++i) {
				int x = Integer.parseInt(in.readLine());
				if (x > 0)
					list.add(x);
			}
			
			if (!list.isEmpty()) {
				sb.append(list.get(0));
				for (int i = 1; i < list.size(); ++i)
					sb.append(" " + list.get(i));
				sb.append("\n");
			} else {
				sb.append("0\n");
			}
		}
		System.out.print(sb);
		
		in.close();
		System.exit(0);
	}
}
