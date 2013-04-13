package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 3960 (12515 - Movie Police) */
/* SUBMISSION: 10772876 */
/* SUBMISSION TIME: 2012-10-21 20:44:26 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa12515_MoviePolice {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		String[] parts = in.readLine().split("[ ]+");
		int M = Integer.parseInt(parts[0]);
		int Q = Integer.parseInt(parts[1]);
		
		String[] signatures = new String[M];
		for (int i = 0; i < M; ++i)
			signatures[i] = in.readLine();
		for (int i = 0; i < Q; ++i) {
			String clip = in.readLine();
			int m = clip.length();
			
			int best = 1000;
			int bestPos = 0;
			
			for (int j = 0; j < M; ++j) {
				String sig = signatures[j];				
				int n = sig.length();

				for (int k = 0; k <= n - m; ++k) {
					int ndiff = 0;
					
					for (int l = 0; l < m; ++l)
						if (clip.charAt(l) != sig.charAt(k + l))
							++ndiff;
					
					if (ndiff < best) {
						best = ndiff;
						bestPos = j + 1;
					}
				}
			}
			sb.append(bestPos + "\n");
		}
		System.out.print(sb);
		
		in.close();
		System.exit(0);
	}
}
