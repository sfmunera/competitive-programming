package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 3976 (12531 - Hours and Minutes) */
/* SUBMISSION: 10875763 */
/* SUBMISSION TIME: 2012-11-12 17:10:22 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa12531_HoursandMinutes {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		/*boolean[] occurs = new boolean[181];
		for (int i = 0; i < 12 * 60; ++i) {
			int h = i / 60;
			int m = i % 60;
			int hpos = 5 * h + m / 12;
			int mpos = m;
			
			int diff = Math.abs(hpos - mpos);
			if (diff > 30)
				diff = 60 - diff;
			int angle = 6 * diff;
			
			occurs[angle] = true;
		}*/

		String line;
		while ((line = in.readLine()) != null) {
			int A = Integer.parseInt(line);
			
			// System.out.println(occurs[A] ? "Y" : "N");
			System.out.println(A % 6 == 0 ? "Y" : "N");
		}
		
		in.close();
		System.exit(0);
	}
}
