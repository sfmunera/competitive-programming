package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 788 (847 - A Multiplication Game) */
/* SUBMISSION: 09136058 */
/* SUBMISSION TIME: 2011-08-11 01:00:22 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa00847_AMultiplicationGame {
	
	static Map<Long, Boolean> memo;
	
	static boolean isWinning(long p, long n) {
		if (p >= n) {
			memo.put(p, false);
			return false;
		}

		for (int i = 2; i <= 9; ++i) {
			boolean winning = memo.containsKey(p * i) ? 
					memo.get(p * i) : isWinning(p * i, n);
			if (!winning) {
				memo.put(p, true);
				return true;
			}
		}
		memo.put(p, false);
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String line;
		while ((line = in.readLine()) != null) {
			long n = Long.parseLong(line);
			
			memo = new HashMap<Long, Boolean>();
			if (isWinning(1, n))
				System.out.println("Stan wins.");
			else
				System.out.println("Ollie wins.");
		}
		
		in.close();
		System.exit(0);
	}
}
