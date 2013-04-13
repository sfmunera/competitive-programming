package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2595 (11559 - Event Planning) */
/* SUBMISSION: 11385640 */
/* SUBMISSION TIME: 2013-03-05 13:26:35 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa11559_EventPlanning {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String line;
		while ((line = in.readLine()) != null) {
			String[] parts = line.split("[ ]+");
			int N = Integer.parseInt(parts[0]);
			int B = Integer.parseInt(parts[1]);
			int H = Integer.parseInt(parts[2]);
			int W = Integer.parseInt(parts[3]);
			
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < H; ++i) {
				int p = Integer.parseInt(in.readLine());
				parts = in.readLine().split("[ ]+");
				
				if (N * p > B)
					continue;
				
				for (int j = 0; j < W; ++j) {
					int a = Integer.parseInt(parts[j]);
					if (a >= N) {
						min = Math.min(min, N * p);
						break;
					}
				}
			}
			if (min == Integer.MAX_VALUE)
				System.out.println("stay home");
			else
				System.out.println(min);
		}
		
		in.close();
		System.exit(0);
	}
}
