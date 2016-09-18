package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 482 (541 - Error Correction) */
/* SUBMISSION: 11312700 */
/* SUBMISSION TIME: 2013-02-19 21:57:13 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa00541_ErrorCorrection {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			int N = Integer.parseInt(in.readLine());
			if (N == 0) break;
			
			int[][] mat = new int[N][N];
			for (int i = 0; i < N; ++i) {
				StringTokenizer stk = new StringTokenizer(in.readLine());
				for (int j = 0; j < N; ++j)
					mat[i][j] = Integer.parseInt(stk.nextToken());
			}
			
			int[] rowSum = new int[N];
			int[] colSum = new int[N];
			
			for (int i = 0; i < N; ++i)
				for (int j = 0; j < N; ++j) {
					rowSum[i] += mat[i][j];
					colSum[i] += mat[j][i];
				}
			
			int r = -1, c = -1;
			int rowCnt = 0;
			int colCnt = 0;
			for (int i = 0; i < N; ++i) {
				if (rowSum[i] % 2 == 1) {
					r = i;
					++rowCnt;
				}
				if (colSum[i] % 2 == 1) {
					c = i;
					++colCnt;
				}
			}
			
			if (rowCnt == 0 && colCnt == 0)
				System.out.println("OK");
			else if (rowCnt > 1 || colCnt > 1)
				System.out.println("Corrupt");
			else
				System.out.println("Change bit (" + (r + 1) + "," + (c + 1) + ")");
		}
		
		in.close();
		System.exit(0);
	}
}
