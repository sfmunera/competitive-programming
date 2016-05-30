package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2384 (11389 - The Bus Driver Problem) */
/* SUBMISSION: 10190356 */
/* SUBMISSION TIME: 2012-06-04 17:30:14 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa11389_TheBusDriverProblem {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			String[] parts = in.readLine().split("[ ]+");
			int n = Integer.parseInt(parts[0]);
			int d = Integer.parseInt(parts[1]);
			int r = Integer.parseInt(parts[2]);
			
			if (n == 0 && d == 0 && r == 0)
				break;
			
			int[] morning = new int[n];
			int[] evening = new int[n];
			parts = in.readLine().split("[ ]+");
			for (int i = 0; i < n; ++i)
				morning[i] = Integer.parseInt(parts[i]);
			
			parts = in.readLine().split("[ ]+");
			for (int i = 0; i < n; ++i)
				evening[i] = Integer.parseInt(parts[i]);
			
			Arrays.sort(morning);
			Arrays.sort(evening);
			
			int ans = 0;
			for (int i = 0; i < n; ++i)
				ans += Math.max(0, morning[i] + evening[n - 1 - i] - d) * r;
			System.out.println(ans);
		}
		
		
		in.close();
		System.exit(0);
	}
}
