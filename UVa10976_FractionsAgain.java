package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1917 (10976 - Fractions Again?!) */
/* SUBMISSION: 09959400 */
/* SUBMISSION TIME: 2012-04-05 20:49:43 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa10976_FractionsAgain {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String line;
		StringBuilder sb = new StringBuilder();
		while ((line = in.readLine()) != null) {
			int k = Integer.parseInt(line);
			List<Integer> xd = new ArrayList<Integer>();
			List<Integer> yd = new ArrayList<Integer>();
			
			for (int y = k + 1; y <= 2 * k; ++y) {
				if (k * y % (y - k) == 0) {
					int x = k * y / (y - k);
					xd.add(x);
					yd.add(y);
				}
			}
			
			sb.append(xd.size() + "\n");
			for (int i = 0; i < xd.size(); ++i)
				sb.append(String.format("1/%d = 1/%d + 1/%d\n", k, xd.get(i), yd.get(i)));
		}
		
		System.out.print(sb);
		
		in.close();
		System.exit(0);
	}
}
