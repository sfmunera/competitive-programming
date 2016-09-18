package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2324 (11349 - Symmetric Matrix) */
/* SUBMISSION: 10045388 */
/* SUBMISSION TIME: 2012-04-27 18:30:33 */
/* LANGUAGE: 2 */


import java.io.*;

public class UVa11349_SymmetricMatrix {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; ++t) {
			String[] parts = in.readLine().split("[= ]+");
			int N = Integer.parseInt(parts[1].trim());
						
			long[][] M = new long[N][N];
			for (int i = 0; i < N; ++i) {
				parts = in.readLine().split("[ ]");
				
				for (int j = 0; j < N; ++j)
					M[i][j] = Long.parseLong(parts[j]);
			}
			
			boolean ok = true;
			for (int i = 0; i < N && ok; ++i)
				for (int j = 0; j < N && ok; ++j)
					if (M[i][j] < 0 || M[i][j] != M[N - i - 1][N - j - 1])
						ok = false;
			
			System.out.println("Test #" + t + ": " + (ok ? "Symmetric" : "Non-symmetric") + ".");
		}
		
		in.close();
		System.exit(0);
	}
}
