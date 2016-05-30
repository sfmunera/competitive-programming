package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 681 (740 - Baudot Data Communication Code) */
/* SUBMISSION: 09121706 */
/* SUBMISSION TIME: 2011-08-06 21:14:36 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa00740_BaudotDataCommunicationCode {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		char[] downshift = in.readLine().toCharArray();
		char[] upshift = in.readLine().toCharArray();
		int shiftdown = 27;
		int shiftup = 31;
		
		String line;
		while ((line = in.readLine()) != null) {
			
			boolean isDownshift = true;
			String res = "";
			for (int i = 0; i < line.length(); i += 5) {
				int ind = Integer.parseInt(line.substring(i, i + 5), 2);
				if (ind == shiftdown)
					isDownshift = true;
				else if (ind == shiftup)
					isDownshift = false;
				else
					res += isDownshift ? downshift[ind] : upshift[ind];
			}
			System.out.println(res);
		}
		
		in.close();
		System.exit(0);
	}
}