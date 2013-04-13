package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2693 (11646 - Athletics Track) */
/* SUBMISSION: 10204975 */
/* SUBMISSION TIME: 2012-06-08 19:02:43 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa11646_AthleticsTrack {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String line;
		int t = 1;
		while ((line = in.readLine()) != null) {
			String[] parts = line.split("[: ]+");
			int a = Integer.parseInt(parts[0]);
			int b = Integer.parseInt(parts[1]);
			
			double k = 200.0 / (a + Math.sqrt(a * a + b * b) * Math.atan((double)b / a));
			System.out.printf(Locale.ENGLISH, "Case %d: %.10f %.10f\n", t, k * a, k * b);
			++t;
		}
		
		in.close();
		System.exit(0);
	}
}
