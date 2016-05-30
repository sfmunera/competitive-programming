package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 349 (408 - Uniform Generator) */
/* SUBMISSION: 09086725 */
/* SUBMISSION TIME: 2011-07-27 23:00:31 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa00408_UniformGenerator {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String line;
		while ((line = in.readLine()) != null) {
			StringTokenizer stk = new StringTokenizer(line);
			int step = Integer.parseInt(stk.nextToken());
			int mod = Integer.parseInt(stk.nextToken());
			
			boolean[] selected = new boolean[mod];
			int seed = 0;
			selected[seed] = true;
			
			boolean good = true;
			for (int i = 1; i < mod; ++i) {
				seed = (seed + step) % mod;
				if (selected[seed]) {
					good = false;
					break;
				}
				selected[seed] = true;
			}
			System.out.format("%10d%10d    %s Choice%n%n", step, mod, good ? "Good" : "Bad");
		}
		
		in.close();
		System.exit(0);
	}
}