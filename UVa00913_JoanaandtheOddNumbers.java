package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 854 (913 - Joana and the Odd Numbers) */
/* SUBMISSION: 09302753 */
/* SUBMISSION TIME: 2011-09-26 20:16:13 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa00913_JoanaandtheOddNumbers {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String line;
		while ((line = in.readLine()) != null) {
			long N = Long.parseLong(line);
			long res = 3 * ((N + 1) * (N + 1) / 2 - 3);
			System.out.println(res);
		}
		
		in.close();
		System.exit(0);
	}
}