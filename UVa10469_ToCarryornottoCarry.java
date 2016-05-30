package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1410 (10469 - To Carry or not to Carry) */
/* SUBMISSION: 09108059 */
/* SUBMISSION TIME: 2011-08-02 15:59:26 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa10469_ToCarryornottoCarry {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String line;
		while ((line = in.readLine()) != null) {
			StringTokenizer stk = new StringTokenizer(line);
			int a = Integer.parseInt(stk.nextToken());
			int b = Integer.parseInt(stk.nextToken());
			
			System.out.println(a ^ b);
		}
		
		in.close();
		System.exit(0);
	}
}