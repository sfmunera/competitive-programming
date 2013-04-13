package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 834 (893 - Y3K Problem) */
/* SUBMISSION: 09599086 */
/* SUBMISSION TIME: 2011-12-28 19:58:40 */
/* LANGUAGE: 2 */

import java.io.*;
import java.util.*;

public class UVa00893_Y3KProblem {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			String[] parts = in.readLine().split("[ ]+");
			int N = Integer.parseInt(parts[0]);
			int d = Integer.parseInt(parts[1]);
			int m = Integer.parseInt(parts[2]);
			int y = Integer.parseInt(parts[3]);
			
			if (N == 0 && d == 0 && m == 0 && y == 0)
				break;
			
			Calendar cal = new GregorianCalendar();
			cal.set(y, m - 1, d);
			cal.add(Calendar.DATE, N);
			
			System.out.println(cal.get(Calendar.DATE) + " " + (cal.get(Calendar.MONTH) + 1) +
					" " + cal.get(Calendar.YEAR));
		}
		
		in.close();
		System.exit(0);
	}
}