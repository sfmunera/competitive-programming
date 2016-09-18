package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1619 (10678 - The Grazing Cow) */
/* SUBMISSION: 10284438 */
/* SUBMISSION TIME: 2012-07-03 05:19:30 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa10678_TheGrazingCow {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		while (T-- > 0) {
			String[] parts = in.readLine().split("[ ]+");
			int D = Integer.parseInt(parts[0]);
			int L = Integer.parseInt(parts[1]);
			
			double A = L / 2.0;
			double B = 0.5 * Math.sqrt(L * L - D * D);
			System.out.printf(Locale.ENGLISH, "%.3f\n", Math.PI * A * B);
		}
		
		in.close();
		System.exit(0);
	}
}
