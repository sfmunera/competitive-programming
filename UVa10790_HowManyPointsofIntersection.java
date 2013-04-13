package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1731 (10790 - How Many Points of Intersection?) */
/* SUBMISSION: 10797045 */
/* SUBMISSION TIME: 2012-10-26 02:28:08 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa10790_HowManyPointsofIntersection {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int t = 1;
		while (true) {
			String[] parts = in.readLine().split("[ ]+");
			long a = Long.parseLong(parts[0]);
			long b = Long.parseLong(parts[1]);
			
			if (a == 0 && b == 0) break;
			
			long ans = (a * (a - 1) / 2) * (b * (b - 1) / 2);
			System.out.println("Case " + t + ": " + ans);
			++t;
		}
		
		in.close();
		System.exit(0);
	}
}
