package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2341 (11356 - Dates) */
/* SUBMISSION: 11502866 */
/* SUBMISSION TIME: 2013-03-25 00:39:48 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;
import java.text.*;

public class UVa11356_Dates {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String[] months = {"January", "February", "March", "April", "May", "June", "July", "August",
				"September", "October", "November", "December"};
		
		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; ++t) {
			String line = in.readLine();
			int K = Integer.parseInt(in.readLine());
			
			int m = 0;
			String[] parts = line.split("[-]");
			for (int i = 0; i < 12; ++i)
				if (months[i].equals(parts[1])) {
					m = i + 1;
					break;
				}
			
			String date = parts[0] + "-" + String.format("%02d", m) + "-" + parts[2];
			//System.out.println(date);
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			c.setTime(sdf.parse(date));
			c.add(Calendar.DATE, K);
			String newDate = sdf.format(c.getTime());
			
			parts = newDate.split("[-]");
			String ans = parts[0] + "-" + months[Integer.parseInt(parts[1]) - 1] + "-" + parts[2];
			
			System.out.println("Case " + t + ": " + ans);
		}
		
		in.close();
		System.exit(0);
	}
}
