package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 3701 (1260 - Sales) */
/* SUBMISSION: 09959304 */
/* SUBMISSION TIME: 2012-04-05 20:06:46 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa01260_Sales {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		while (T-- > 0) {
			int N = Integer.parseInt(in.readLine());
			int[] A = new int[N];
			int sum = 0;
			
			String[] parts = in.readLine().split("[ ]+");
			for (int i = 0; i < N; ++i)
				A[i] = Integer.parseInt(parts[i]);
			
			for (int i = 1; i < N; ++i) {
				int cnt = 0;
				for (int j = 0; j < i; ++j)
					if (A[j] <= A[i])
						++cnt;
				
				sum += cnt;
			}
			System.out.println(sum);
		}
		
		in.close();
		System.exit(0);
	}
}
