package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 3000 (11878 - Homework Checker) */
/* SUBMISSION: 11411999 */
/* SUBMISSION TIME: 2013-03-09 21:37:33 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa11878_HomeworkChecker {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String line;
		int cnt = 0;
		while ((line = in.readLine()) != null) {
			String[] parts = line.split("[=]");
			if (parts[1].equals("?")) continue;
			
			int ans = Integer.parseInt(parts[1]);
			String[] parts2 = parts[0].split("[-]");
			if (parts2.length == 2) {
				int n1 = Integer.parseInt(parts2[0]);
				int n2 = Integer.parseInt(parts2[1]);
				if (n1 - n2 == ans) ++cnt;
			} else {
				parts2 = parts[0].split("[\\+]");
				int n1 = Integer.parseInt(parts2[0]);
				int n2 = Integer.parseInt(parts2[1]);
				if (n1 + n2 == ans) ++cnt;
			}
		}
		System.out.println(cnt);
		
		in.close();
		System.exit(0);
	}
}
