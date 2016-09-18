package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1985 (11044 - Searching for Nessy) */
/* SUBMISSION: 09973333 */
/* SUBMISSION TIME: 2012-04-09 13:06:25 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa11044_SearchingforNessy {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		while (T-- > 0) {
			String[] parts = in.readLine().split("[ ]+");
			int R = Integer.parseInt(parts[0]);
			int C = Integer.parseInt(parts[1]);
			
			int res = (int)(Math.ceil((double)(R - 2) / 3.0) *
			                Math.ceil((double)(C - 2) / 3.0));
			System.out.println(res);
		}
		
		in.close();
		System.exit(0);
	}
}
