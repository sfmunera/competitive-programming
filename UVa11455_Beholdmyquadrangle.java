package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2450 (11455 - Behold my quadrangle) */
/* SUBMISSION: 10643999 */
/* SUBMISSION TIME: 2012-09-23 21:16:29 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa11455_Beholdmyquadrangle {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine().trim());
		while (T-- > 0) {
			String[] parts = in.readLine().trim().split("[ ]+");
			long[] lens = new long[4];
			
			for (int i = 0; i < 4; ++i)
				lens[i] = Long.parseLong(parts[i]);
			
			Arrays.sort(lens);
			if (lens[0] == lens[1] && lens[1] == lens[2] && lens[2] == lens[3])
				System.out.println("square");
			else if (lens[0] == lens[1] && lens[2] == lens[3])
				System.out.println("rectangle");
			else if (lens[0] + lens[1] + lens[2] <= lens[3])
				System.out.println("banana");
			else
				System.out.println("quadrangle");
		}
		
		in.close();
		System.exit(0);
	}
}
