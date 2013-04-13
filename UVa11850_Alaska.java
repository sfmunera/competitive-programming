package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2950 (11850 - Alaska) */
/* SUBMISSION: 10242685 */
/* SUBMISSION TIME: 2012-06-20 16:12:20 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa11850_Alaska {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			int N = Integer.parseInt(in.readLine());
			if (N == 0)
				break;
			
			int[] location = new int[N];
			for (int i = 0; i < N; ++i)
				location[i] = Integer.parseInt(in.readLine());
			Arrays.sort(location);
			
			boolean ok = true;
			for (int i = 1; i < N; ++i)
				if (location[i] - location[i - 1] > 200) {
					ok = false;
					break;
				}
			if (2 * (1422 - location[N - 1]) > 200) ok = false;
			System.out.println(ok ? "POSSIBLE" : "IMPOSSIBLE");
		}
		
		in.close();
		System.exit(0);
	}
}
