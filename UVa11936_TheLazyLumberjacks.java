package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 3087 (11936 - The Lazy Lumberjacks) */
/* SUBMISSION: 09302437 */
/* SUBMISSION TIME: 2011-09-26 18:56:57 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa11936_TheLazyLumberjacks {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		while (T-- > 0) {
			StringTokenizer stk = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(stk.nextToken());
			int b = Integer.parseInt(stk.nextToken());
			int c = Integer.parseInt(stk.nextToken());
			
			boolean ok = a + b > c && a + c > b && b + c > a;
			System.out.println(ok ? "OK" : "Wrong!!");
		}
		
		in.close();
		System.exit(0);
	}
}