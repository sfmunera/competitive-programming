package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 3912 (12468 - Zapping) */
/* SUBMISSION: 10187135 */
/* SUBMISSION TIME: 2012-06-03 19:07:26 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa12468_Zapping {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			String[] parts = in.readLine().split("[ ]+");
			int a = Integer.parseInt(parts[0]);
			int b = Integer.parseInt(parts[1]);
			if (a == -1 && b == -1)
				break;
			
			System.out.println(Math.min(Math.abs(b - a), 100 - Math.abs(b - a)));
		}
		
		in.close();
		System.exit(0);
	}
}
