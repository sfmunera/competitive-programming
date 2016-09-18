package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2451 (11456 - Trainsorting) */
/* SUBMISSION: 10166234 */
/* SUBMISSION TIME: 2012-05-29 02:39:54 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa11456_Trainsorting {
	
	static int[] lis(int[] sequence) {
		int n = sequence.length;
		int[] q = new int[n];
		
		for (int i = 0; i < n; ++i) {
			int max = 0;
			for (int j = 0; j < i; ++j)
				if (sequence[i] > sequence[j])
					max = Math.max(max, q[j]);
			q[i] = max + 1;
		}
		return q;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			int N = Integer.parseInt(in.readLine());
			int[] listinc = new int[N];
			int[] listdec = new int[N];
			
			for (int i = 0; i < N; ++i) {
				int x = Integer.parseInt(in.readLine());
				listinc[N - 1 - i] = x;
				listdec[N - 1 - i] = -x;
			}
			int[] lis = lis(listinc);
			int[] lds = lis(listdec);

			int max = 0;
			for (int i = 0; i < N; ++i)
				max = Math.max(max, lis[i] + lds[i] - 1);
			
			sb.append(max + "\n");
		}
		System.out.print(sb);
		
		in.close();
		System.exit(0);
	}
}
