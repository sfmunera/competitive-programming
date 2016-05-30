package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 77 (141 - The Spot Game) */
/* SUBMISSION: 11502993 */
/* SUBMISSION TIME: 2013-03-25 01:26:04 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa00141_TheSpotGame {
	
	static char[][] rotate(char[][] b) {
		int N = b.length;
		
		char[][] ans = new char[N][N];
		for (int i = 0; i < N; ++i)
			for (int j = 0; j < N; ++j)
				ans[j][i] = b[i][N - 1 - j];
		return ans;
	}
	
	static boolean equal(char[][] b1, char[][] b2) {
		int N = b1.length;
		for (int i = 0; i < N; ++i)
			for (int j = 0; j < N; ++j)
				if (b1[i][j] != b2[i][j])
					return false;
		return true;
	}
	
	static char[][] init(int N) {
		char[][] b = new char[N][N];
		for (int i = 0; i < N; ++i)
			for (int j = 0; j < N; ++j)
				b[i][j] = '.';
		return b;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			int N = Integer.parseInt(in.readLine());
			if (N == 0) break;
			
			ArrayList<char[][]> past = new ArrayList<char[][]>();
			
			char[][] board = init(N);
			
			char[][] empty = init(N);
			past.add(empty);
			
			boolean draw = true;
			int turn = 0;
			for (int i = 0; i < 2 * N; ++i) {
				String line = in.readLine();
				
				if (!draw) continue;
				
				StringTokenizer stk = new StringTokenizer(line);
				int r = Integer.parseInt(stk.nextToken()) - 1;
				int c = Integer.parseInt(stk.nextToken()) - 1;
				char move = stk.nextToken().charAt(0);
				
				if (move == '+')
					board[r][c] = '*';
				else
					board[r][c] = '.';
				
				char[][] b1 = new char[N][N];
				for (int j = 0; j < N; ++j)
					for (int k = 0; k < N; ++k)
						b1[j][k] = board[j][k];
				char[][] b2 = rotate(b1);
				char[][] b3 = rotate(b2);
				char[][] b4 = rotate(b3);
				
				/*System.out.println("0 grados");
				for (int j = 0; j < N; ++j)
					System.out.println(Arrays.toString(b1[j]));
				System.out.println("90 grados");
				for (int j = 0; j < N; ++j)
					System.out.println(Arrays.toString(b2[j]));
				System.out.println("180 grados");
				for (int j = 0; j < N; ++j)
					System.out.println(Arrays.toString(b3[j]));
				System.out.println("270 grados");
				for (int j = 0; j < N; ++j)
					System.out.println(Arrays.toString(b4[j]));*/
				
				for (int j = 0; j < past.size(); ++j) {
					char[][] p = past.get(j);
					if (equal(p, board)) {
						draw = false;
						System.out.println("Player " + (2 - turn) + " wins on move " + (i + 1));
						break;
					}
				}
				past.add(b1);
				past.add(b2);
				past.add(b3);
				past.add(b4);
				turn = 1 - turn;
			}
			if (draw) System.out.println("Draw");
		}
		
		in.close();
		System.exit(0);
	}
}
