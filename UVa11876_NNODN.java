package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2987 (11876 - N + NOD (N)) */
/* SUBMISSION: 10243614 */
/* SUBMISSION TIME: 2012-06-20 23:34:36 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa11876_NNODN {
	
	static int NOD(int N) {
		
		int ans = 0;
		for (int p = 1; p * p <= N; ++p) {
			if (N % p == 0) {
				++ans;
				if (N / p != p)
					++ans;
			}
		}
		return ans;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int m = 65000;
		int MAXN = 1000005;
		int[] N = new int[m];
		int[] freq = new int[MAXN];
		N[0] = 1;
		for (int i = 1; i < m; ++i) {
			N[i] = N[i - 1] + NOD(N[i - 1]);
			if (N[i - 1] < MAXN)
				freq[N[i - 1]] = 1;
		}
		
		for (int i = 1; i < MAXN; ++i)
			freq[i] += freq[i - 1];
		
		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; ++t) {
			String[] parts = in.readLine().split("[ ]+");
			int A = Integer.parseInt(parts[0]);
			int B = Integer.parseInt(parts[1]);
			
			int ans = freq[B] - freq[A - 1];
			sb.append("Case " + t + ": " + ans + "\n");
		}
		System.out.print(sb);
		
		in.close();
		System.exit(0);
	}
}
