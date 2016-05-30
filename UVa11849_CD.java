package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2949 (11849 - CD) */
/* SUBMISSION: 11388561 */
/* SUBMISSION TIME: 2013-03-05 22:42:39 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa11849_CD {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			StringTokenizer stk = new StringTokenizer(in.readLine());
			int N = Integer.parseInt(stk.nextToken());
			int M = Integer.parseInt(stk.nextToken());
			
			if (N == 0 && M == 0) break;
			
			Set<Integer> jack = new HashSet<Integer>();
			for (int i = 0; i < N; ++i)
				jack.add(Integer.parseInt(in.readLine()));
			
			int ans = 0;
			for (int i = 0; i < M; ++i)
				if (jack.contains(Integer.parseInt(in.readLine())))
					++ans;
			System.out.println(ans);
		}
		
		in.close();
		System.exit(0);
	}
}
