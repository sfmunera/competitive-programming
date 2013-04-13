package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2736 (11689 - Soda Surpler) */
/* SUBMISSION: 11312652 */
/* SUBMISSION TIME: 2013-02-19 21:37:17 */
/* LANGUAGE: 2 */

import java.io.*;
import java.util.*;

public class UVa11689_SodaSurpler {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		while (T-- > 0) {
			StringTokenizer stk = new StringTokenizer(in.readLine());
			int e = Integer.parseInt(stk.nextToken());
			e += Integer.parseInt(stk.nextToken());
			int c = Integer.parseInt(stk.nextToken());
			
			int ans = 0;
			while (e >= c) {
				ans += e / c;
				e = e / c + e % c;
			}
			System.out.println(ans);
		}
		
		in.close();
		System.exit(0);
	}
}
