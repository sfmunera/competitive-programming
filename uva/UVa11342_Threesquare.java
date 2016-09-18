package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2317 (11342 - Three-square) */
/* SUBMISSION: 10106069 */
/* SUBMISSION TIME: 2012-05-12 16:02:28 */
/* LANGUAGE: 2 */

import java.io.*;
import java.util.*;

public class UVa11342_Threesquare {
	
	static class Triple {
		int a, b, c;
		
		public Triple(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		Map<Integer, Triple> map = new HashMap<Integer, Triple>();
		for (int a = 0; a <= 224; ++a)
			for (int b = a; b <= 224; ++b)
				for (int c = b; c <= 224; ++c) {
					int K = a * a + b * b + c * c;
					if (!map.containsKey(K))
						map.put(K, new Triple(a, b, c));
				}
				
		int T = Integer.parseInt(in.readLine());
	
		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			int K = Integer.parseInt(in.readLine());
			
			if (map.containsKey(K)) {
				Triple t = map.get(K);
				sb.append(t.a + " " + t.b + " " + t.c + "\n");
			} else
				sb.append("-1\n");
		}
		System.out.print(sb);
		
		in.close();
		System.exit(0);
	}
}
