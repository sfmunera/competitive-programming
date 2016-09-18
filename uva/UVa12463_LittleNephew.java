package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 3906 (12463 - Little Nephew) */
/* SUBMISSION: 10187124 */
/* SUBMISSION TIME: 2012-06-03 19:05:10 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa12463_LittleNephew {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			String[] parts = in.readLine().split("[ ]+");
			int a = Integer.parseInt(parts[0]);
			int b = Integer.parseInt(parts[1]);
			int c = Integer.parseInt(parts[2]);
			int d = Integer.parseInt(parts[3]);
			int e = Integer.parseInt(parts[4]);
			
			if (a == 0 && b == 0 && c == 0 && d == 0 && e == 0)
				break;
			
			System.out.println(a * b * c * d * d * e * e);
		}
		
		in.close();
		System.exit(0);
	}
}
