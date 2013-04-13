package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 3593 (1152 - 4 Values whose Sum is 0) */
/* SUBMISSION: 09282791 */
/* SUBMISSION TIME: 2011-09-21 00:44:31 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa01152_4ValueswhoseSumis0 {

	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		boolean first = true;
		while (T-- > 0) {
			in.readLine();
			int N = Integer.parseInt(in.readLine());
			
			if (N == 0)
				break;
			
			int[] A = new int[N];
			int[] B = new int[N];
			int[] C = new int[N];
			int[] D = new int[N];
			
			
			
			for (int i = 0; i < N; ++i) {
				String line = in.readLine();
				StringTokenizer stk = new StringTokenizer(line);
				
				A[i] = Integer.parseInt(stk.nextToken());
				B[i] = Integer.parseInt(stk.nextToken());
				C[i] = Integer.parseInt(stk.nextToken());
				D[i] = Integer.parseInt(stk.nextToken());
			}
			
			int cnt = 0;
			
			int[] pairs = new int[(N / 2) * N];
			
			int j = 0;
			for (int c = 0; c < N / 2; ++c)
				for (int d = 0; d < N; ++d)
					pairs[j++] = C[c] + D[d];
			Arrays.sort(pairs);
			
			
			for (int a = 0; a < N; ++a)
				for (int b = 0; b < N; ++b) {
					int sum = -(A[a] + B[b]);
					int ind = Arrays.binarySearch(pairs, sum);
					
					if (ind >= 0) {
						++cnt;
						for (int k = ind - 1; k >= 0; --k)
							if (pairs[k] == sum)
								++cnt;
							else
								break;
						for (int k = ind + 1; k < pairs.length; ++k)
							if (pairs[k] == sum)
								++cnt;
							else
								break;
					}
				}
			
			pairs = new int[(N - N / 2) * N];
			
			j = 0;
			for (int c = N / 2; c < N; ++c)
				for (int d = 0; d < N; ++d)
					pairs[j++] = C[c] + D[d];
			Arrays.sort(pairs);
			
			
			for (int a = 0; a < N; ++a)
				for (int b = 0; b < N; ++b) {
					int sum = -(A[a] + B[b]);
					int ind = Arrays.binarySearch(pairs, sum);
					
					if (ind >= 0) {
						++cnt;
						for (int k = ind - 1; k >= 0; --k)
							if (pairs[k] == sum)
								++cnt;
							else
								break;
						for (int k = ind + 1; k < pairs.length; ++k)
							if (pairs[k] == sum)
								++cnt;
							else
								break;
					}
				}
			if (first)
				first = false;
			else
				System.out.println();
			System.out.println(cnt);
		}
		
		in.close();
		System.exit(0);
	}
}