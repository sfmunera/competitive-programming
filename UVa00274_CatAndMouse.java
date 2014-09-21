package uva;

import java.util.*;
import java.io.*;

public class UVa00274_CatAndMouse {
	
	static int M, C, N;
	static boolean[][] adjCat, adjMouse, adjMouse2;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		in.readLine();
		boolean first = true;
		while (T-- > 0) {
			StringTokenizer stk = new StringTokenizer(in.readLine());
			N = Integer.parseInt(stk.nextToken());
			C = Integer.parseInt(stk.nextToken()) - 1;
			M = Integer.parseInt(stk.nextToken()) - 1;
			
			adjCat = new boolean[N][N];
			adjMouse = new boolean[N][N];
			adjMouse2 = new boolean[N][N];
			
			for (int i = 0; i < N; ++i) {
				adjCat[i][i] = true;
				adjMouse[i][i] = true;
			}
			
			while (true) {
				stk = new StringTokenizer(in.readLine());
				int a = Integer.parseInt(stk.nextToken()) - 1;
				int b = Integer.parseInt(stk.nextToken()) - 1;
				if (a < 0 && b < 0)
					break;
				adjCat[a][b] = true;
			}
			String line;
			while ((line = in.readLine()) != null && !line.isEmpty()) {
				stk = new StringTokenizer(line);
				int a = Integer.parseInt(stk.nextToken()) - 1;
				int b = Integer.parseInt(stk.nextToken()) - 1;
				adjMouse[a][b] = true;
				adjMouse2[a][b] = true;
			}
			
			for (int k = 0; k < N; ++k)
				for (int i = 0; i < N; ++i)
					for (int j = 0; j < N; ++j) {
						adjCat[i][j] |= adjCat[i][k] && adjCat[k][j];
						adjMouse[i][j] |= adjMouse[i][k] && adjMouse[k][j];
					}
			
			// Is there a place where mouse and cat can go?
			boolean ans1 = false;
			for (int i = 0; i < N; ++i)
				if (adjCat[C][i] && adjMouse[M][i])
					ans1 = true;
			
			// Is there a route for the mouse where he does not find the cat?
			boolean ans2 = false;
			for (int i = 0; i < N; ++i)
				if (adjCat[C][i])
					for (int j = 0; j < N; ++j)
						adjMouse2[j][i] = false;
			
			for (int k = 0; k < N; ++k)
				for (int i = 0; i < N; ++i)
					for (int j = 0; j < N; ++j)
						adjMouse2[i][j] |= adjMouse2[i][k] && adjMouse2[k][j];
			
			for (int i = 0; i < N; ++i)
				if (i != M && adjMouse2[M][i] && adjMouse2[i][M])
					ans2 = true;

			if (first) first = false; else System.out.println();
			System.out.println((ans1 ? "Y" : "N") + " " + (ans2 ? "Y" : "N"));
		}
		in.close();
	}
}
