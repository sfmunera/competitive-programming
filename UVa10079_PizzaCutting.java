package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1020 (10079 - Pizza Cutting) */
/* SUBMISSION: 09853300 */
/* SUBMISSION TIME: 2012-03-13 14:13:11 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa10079_PizzaCutting {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			int N = Integer.parseInt(in.readLine());
			if (N < 0)
				break;
			
			long res = 1;
			for (int i = 0; i <= N; ++i)
				res += i;
			System.out.println(res);
		}
		
		in.close();
		System.exit(0);
	}
}