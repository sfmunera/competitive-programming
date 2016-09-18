package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2655 (11608 - No Problem) */
/* SUBMISSION: 09587456 */
/* SUBMISSION TIME: 2011-12-23 20:15:24 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa11608_NoProblem {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int t = 1;
		while (true) {
			int S = Integer.parseInt(in.readLine());
			
			if (S < 0)
				break;
			
			int[] available = new int[12];
			int[] required = new int[12];
			
			String[] parts = in.readLine().split("[ ]+");
			for (int i = 0; i < 12; ++i)
				available[i] = Integer.parseInt(parts[i]);
			
			parts = in.readLine().split("[ ]+");
			for (int i = 0; i < 12; ++i)
				required[i] = Integer.parseInt(parts[i]);
			
			System.out.println("Case " + t++ + ":");
			for (int i = 0; i < 12; ++i) {
				if (S >= required[i]) {
					System.out.println("No problem! :D");
					S += available[i] - required[i];
				} else {
					System.out.println("No problem. :(");
					S += available[i];
				}
			}
		}
		
		in.close();
		System.exit(0);
	}
}