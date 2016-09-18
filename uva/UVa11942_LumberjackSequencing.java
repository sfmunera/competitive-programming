package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 3093 (11942 - Lumberjack Sequencing) */
/* SUBMISSION: 09163765 */
/* SUBMISSION TIME: 2011-08-17 21:56:05 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa11942_LumberjackSequencing {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		System.out.println("Lumberjacks:");
		while (N-- > 0) {
			String line = in.readLine();
			StringTokenizer stk = new StringTokenizer(line);
			
			int[] sequence = new int[10];
			int i = 0;
			while (stk.hasMoreTokens())
				sequence[i++] = Integer.parseInt(stk.nextToken());
			
			boolean less = sequence[1] < sequence[0];
			boolean ok = true;
			for (i = 1; i < 10 && ok; ++i)
				if ((less && sequence[i] > sequence[i - 1]) || 
						(!less && sequence[i] < sequence[i - 1]))
					ok = false;
			System.out.println(ok ? "Ordered" : "Unordered");
		}
		
		in.close();
		System.exit(0);
	}
}