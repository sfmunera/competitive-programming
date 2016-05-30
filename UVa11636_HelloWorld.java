package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2683 (11636 - Hello World!) */
/* SUBMISSION: 09141761 */
/* SUBMISSION TIME: 2011-08-12 13:55:26 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa11636_HelloWorld {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int t = 1;
		while (true) {
			int N = Integer.parseInt(in.readLine());
			if (N < 0)
				break;
			
			System.out.println("Case " + t + ": " + (int)Math.ceil(Math.log(N) / Math.log(2)));
			++t;
		}
		
		in.close();
		System.exit(0);
	}
}