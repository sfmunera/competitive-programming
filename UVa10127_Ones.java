package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1068 (10127 - Ones) */
/* SUBMISSION: 11039430 */
/* SUBMISSION TIME: 2012-12-17 05:48:46 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa10127_Ones {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String line;
		while ((line = in.readLine()) != null) {
			int N = Integer.parseInt(line);
			
			long mult = 1;
			int k = 1;
			while (mult % N != 0) {
				mult = (mult * 10 + 1) % N;
				++k;
			}
			System.out.println(k);
		}
		
		in.close();
		System.exit(0);
	}
}
