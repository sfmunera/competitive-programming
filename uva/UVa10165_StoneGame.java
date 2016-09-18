package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1106 (10165 - Stone Game) */
/* SUBMISSION: 10243670 */
/* SUBMISSION TIME: 2012-06-21 00:29:09 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa10165_StoneGame {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			int N = Integer.parseInt(in.readLine());
			
			if (N == 0)
				break;
			
			String[] parts = in.readLine().split("[ ]+");
			int ans = Integer.parseInt(parts[0]);
			for (int i = 1; i < N; ++i)
				ans ^= Integer.parseInt(parts[i]);
			
			if (ans == 0)
				System.out.println("No");
			else
				System.out.println("Yes");
		}
		
		in.close();
		System.exit(0);
	}
}
