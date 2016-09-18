package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2345 (11360 - Have Fun with Matrices) */
/* SUBMISSION: 11412527 */
/* SUBMISSION TIME: 2013-03-10 01:55:28 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa11360_HaveFunwithMatrices {
	
	static void row(char[][] mat, int a, int b) {
		int N = mat.length;
		char[] tmp = new char[N];
		
		for (int i = 0; i < N; ++i)
			tmp[i] = mat[a][i];
		for (int i = 0; i < N; ++i)
			mat[a][i] = mat[b][i];
		for (int i = 0; i < N; ++i)
			mat[b][i] = tmp[i];
	}
	
	static void col(char[][] mat, int a, int b) {
		int N = mat.length;
		char[] tmp = new char[N];
		
		for (int i = 0; i < N; ++i)
			tmp[i] = mat[i][a];
		for (int i = 0; i < N; ++i)
			mat[i][a] = mat[i][b];
		for (int i = 0; i < N; ++i)
			mat[i][b] = tmp[i];
	}
	
	static void inc(char[][] mat) {
		int N = mat.length;
		for (int i = 0; i < N; ++i)
			for (int j = 0; j < N; ++j)
				mat[i][j] = (char)((mat[i][j] - '0' + 1) % 10 + '0');
	}
	
	static void dec(char[][] mat) {
		int N = mat.length;
		for (int i = 0; i < N; ++i)
			for (int j = 0; j < N; ++j) {
				mat[i][j] = (char)(mat[i][j] - 1);
				if (mat[i][j] < '0')
					mat[i][j] = '9';
			}
	}
	
	static void transpose(char[][] mat) {
		int N = mat.length;
		char[][] tmp = new char[N][N];
		for (int i = 0; i < N; ++i)
			for (int j = 0; j < N; ++j)
				tmp[j][i] = mat[i][j];
		for (int i = 0; i < N; ++i)
			for (int j = 0; j < N; ++j)
				mat[i][j] = tmp[i][j];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; ++t) {
			int N = Integer.parseInt(in.readLine());
			char[][] mat = new char[N][N];
			for (int i = 0; i < N; ++i)
				mat[i] = in.readLine().toCharArray();
			int M = Integer.parseInt(in.readLine());
			for (int i = 0; i < M; ++i) {
				StringTokenizer stk = new StringTokenizer(in.readLine());
				String command = stk.nextToken();
				
				if (command.equals("row")) {
					int a = Integer.parseInt(stk.nextToken()) - 1;
					int b = Integer.parseInt(stk.nextToken()) - 1;
					row(mat, a, b);
				} else if (command.equals("col")) {
					int a = Integer.parseInt(stk.nextToken()) - 1;
					int b = Integer.parseInt(stk.nextToken()) - 1;
					col(mat, a, b);
				} else if (command.equals("inc")) {
					inc(mat);
				} else if (command.equals("dec")) {
					dec(mat);
				} else if (command.equals("transpose")) {
					transpose(mat);
				}
			}
			
			System.out.println("Case #" + t);
			for (int i = 0; i < N; ++i)
				System.out.println(mat[i]);
			System.out.println();
		}
		
		in.close();
		System.exit(0);
	}
}
