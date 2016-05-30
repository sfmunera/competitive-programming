package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 3909 (12465 - The Turanga Leela Problem) */
/* SUBMISSION: 10187132 */
/* SUBMISSION TIME: 2012-06-03 19:06:33 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa12465_TheTurangaLeelaProblem {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			String[] parts = in.readLine().split("[ ]+");
			int a = Integer.parseInt(parts[0]);
			int b = Integer.parseInt(parts[1]);
			
			if (a == 0 && b == 0)
				break;
			
			int diff = Math.abs(a - b);
			
			int ans = 0;
			for (int d = 1; d * d <= diff; ++d) {
				if (diff % d == 0) {
					++ans;
					if (diff / d != d)
						++ans;
				}
			}
			System.out.println(ans);
		}
		
		in.close();
		System.exit(0);
	}
}
